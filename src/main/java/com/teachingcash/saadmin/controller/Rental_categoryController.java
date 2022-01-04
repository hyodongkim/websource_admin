package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.Rental_categoryService;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.vo.Rental_categoryVO;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class Rental_categoryController {
    private static final Logger logger = LoggerFactory.getLogger(Rental_categoryController.class);

    @Autowired
    Rental_categoryService rental_categoryService;

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/rental_categoryList.do", method = RequestMethod.GET)
    public String rental_categoryList(ModelMap model, HttpServletRequest request, PageVO pageVO, Rental_categoryVO rental_categoryVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(rental_categoryVO == null){
            rental_categoryVO = new Rental_categoryVO();
        }
        rental_categoryVO.setStart(start);
        rental_categoryVO.setLimit(10);
        int total = rental_categoryService.selectCntRental_category(rental_categoryVO);
        List list = rental_categoryService.listRental_category(rental_categoryVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("rental_categoryVO", rental_categoryVO);

        return "/admin/rental_category_list";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteRental_categoryAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deleteRental_categoryAction(HttpServletRequest request, Rental_categoryVO rental_categoryVO, HttpSession session){

        int result = rental_categoryService.deleteRental_category(rental_categoryVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/rental_categoryBoth.do", method = RequestMethod.GET)
    public String rental_categoryBoth(ModelMap model, HttpServletRequest request, Rental_categoryVO pRental_categoryVO, HttpSession session){
        Rental_categoryVO rental_categoryVO = new Rental_categoryVO();
        FileVO fileVO = new FileVO();

        if(pRental_categoryVO.getId() > 0){
            rental_categoryVO = rental_categoryService.selectRental_category(pRental_categoryVO);
            fileVO.setParentId(pRental_categoryVO.getId());
            fileVO = fileService.selectFile(fileVO);

            model.addAttribute("fvo", fileVO);
        }

        model.addAttribute("item", rental_categoryVO);

//        List<Object> listCategory = rental_categoryService.listCategory();
//        model.addAttribute("listCategory", listCategory);

        return "/admin/rental_category_both";
    }

    @RequestMapping(value = "/rental_categoryBoth.do", method = RequestMethod.POST)
    public String rental_categoryBoth (ModelMap model, HttpServletRequest request, Rental_categoryVO bvo, @RequestParam(value = "community", required = false) MultipartFile file) throws Exception {

        /*
        if(bvo.getCategory_new() != null && !bvo.getCategory_new().equals("")){
            bvo.setCategory(bvo.getCategory_new());
        }

        if(bvo.getCategory_en_new() != null && !bvo.getCategory_en_new().equals("")){
            bvo.setCategory_en(bvo.getCategory_en_new());
        }
        
         */

        int result = rental_categoryService.insertRental_category(request, bvo, file);

        if (result > 0) {
            model.addAttribute("redirectUrl", "rental_categoryList.do");

            if (bvo.getId() > 0) {
                model.addAttribute("alertMsg", "카테고리를 성공적으로 수정했습니다.");
            } else {
                model.addAttribute("alertMsg", "카테고리를 성공적으로 작성했습니다.");
            }
        } else {
            model.addAttribute("alertMsg", "카테고리 작성에 실패했습니다.");
        }

        return "common/alert";
    }

    @ResponseBody
    @RequestMapping(value = "/modifyRental_categoryAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String modifyRental_categoryAction(HttpServletRequest request, Rental_categoryVO rental_categoryVO, HttpSession session){

        int result = rental_categoryService.update(rental_categoryVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }
}
