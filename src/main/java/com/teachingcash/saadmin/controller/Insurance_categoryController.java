package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.service.Insurance_categoryService;
import com.teachingcash.saadmin.vo.Insurance_categoryVO;
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
public class Insurance_categoryController {
    private static final Logger logger = LoggerFactory.getLogger(Insurance_categoryController.class);

    @Autowired
    Insurance_categoryService insurance_categoryService;

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/insurance_categoryList.do", method = RequestMethod.GET)
    public String insurance_categoryList(ModelMap model, HttpServletRequest request, PageVO pageVO, Insurance_categoryVO insurance_categoryVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(insurance_categoryVO == null){
            insurance_categoryVO = new Insurance_categoryVO();
        }
        insurance_categoryVO.setStart(start);
        insurance_categoryVO.setLimit(10);
        int total = insurance_categoryService.selectCntInsurance_category(insurance_categoryVO);
        List list = insurance_categoryService.listInsurance_category(insurance_categoryVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("insurance_categoryVO", insurance_categoryVO);

        return "/admin/insurance_category_list";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteInsurance_categoryAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deleteInsurance_categoryAction(HttpServletRequest request, Insurance_categoryVO insurance_categoryVO, HttpSession session){

        int result = insurance_categoryService.deleteInsurance_category(insurance_categoryVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/insurance_categoryBoth.do", method = RequestMethod.GET)
    public String insurance_categoryBoth(ModelMap model, HttpServletRequest request, Insurance_categoryVO pInsurance_categoryVO, HttpSession session){
        Insurance_categoryVO insurance_categoryVO = new Insurance_categoryVO();
        FileVO fileVO = new FileVO();

        if(pInsurance_categoryVO.getId() > 0){
            insurance_categoryVO = insurance_categoryService.selectInsurance_category(pInsurance_categoryVO);
            fileVO.setParentId(pInsurance_categoryVO.getId());
            fileVO = fileService.selectFile(fileVO);

            model.addAttribute("fvo", fileVO);
        }

        model.addAttribute("item", insurance_categoryVO);

//        List<Object> listCategory = insurance_categoryService.listCategory();
//        model.addAttribute("listCategory", listCategory);

        return "/admin/insurance_category_both";
    }

    @RequestMapping(value = "/insurance_categoryBoth.do", method = RequestMethod.POST)
    public String insurance_categoryBoth (ModelMap model, HttpServletRequest request, Insurance_categoryVO bvo, @RequestParam(value = "community", required = false) MultipartFile file) throws Exception {

        /*
        if(bvo.getCategory_new() != null && !bvo.getCategory_new().equals("")){
            bvo.setCategory(bvo.getCategory_new());
        }

        if(bvo.getCategory_en_new() != null && !bvo.getCategory_en_new().equals("")){
            bvo.setCategory_en(bvo.getCategory_en_new());
        }
        
         */

        int result = insurance_categoryService.insertInsurance_category(request, bvo, file);

        if (result > 0) {
            model.addAttribute("redirectUrl", "insurance_categoryList.do");

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
    @RequestMapping(value = "/modifyInsurance_categoryAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String modifyInsurance_categoryAction(HttpServletRequest request, Insurance_categoryVO insurance_categoryVO, HttpSession session){

        int result = insurance_categoryService.update(insurance_categoryVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }
}
