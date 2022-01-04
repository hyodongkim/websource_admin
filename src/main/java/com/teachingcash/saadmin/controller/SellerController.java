package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.SellerService;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.vo.SellerVO;
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
public class SellerController {
    private static final Logger logger = LoggerFactory.getLogger(SellerController.class);

    @Autowired
    SellerService sellerService;

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/sellerList.do", method = RequestMethod.GET)
    public String sellerList(ModelMap model, HttpServletRequest request, PageVO pageVO, SellerVO sellerVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(sellerVO == null){
            sellerVO = new SellerVO();
        }
        sellerVO.setStart(start);
        sellerVO.setLimit(10);
        int total = sellerService.selectCntSeller(sellerVO);
        List list = sellerService.listSeller(sellerVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("sellerVO", sellerVO);

        return "/admin/seller_list";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteSellerAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deleteSellerAction(HttpServletRequest request, SellerVO sellerVO, HttpSession session){

        int result = sellerService.deleteSeller(sellerVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/sellerBoth.do", method = RequestMethod.GET)
    public String sellerBoth(ModelMap model, HttpServletRequest request, SellerVO pSellerVO, HttpSession session){
        SellerVO sellerVO = new SellerVO();
        FileVO fileVO = new FileVO();

        if(pSellerVO.getId() > 0){
            sellerVO = sellerService.selectSeller(pSellerVO);
            fileVO.setParentId(pSellerVO.getId());
            fileVO = fileService.selectFile(fileVO);

            model.addAttribute("fvo", fileVO);
        }

        model.addAttribute("item", sellerVO);

//        List<Object> listCategory = sellerService.listCategory();
//        model.addAttribute("listCategory", listCategory);

        return "/admin/seller_both";
    }

    @RequestMapping(value = "/sellerBoth.do", method = RequestMethod.POST)
    public String sellerBoth (ModelMap model, HttpServletRequest request, SellerVO bvo, @RequestParam(value = "community", required = false) MultipartFile file) throws Exception {


        int result = sellerService.insertSeller(request, bvo, file);

        if (result > 0) {
            model.addAttribute("redirectUrl", "sellerList.do");

            if (bvo.getId() > 0 ) {
                model.addAttribute("alertMsg", "판매처를 성공적으로 수정했습니다.");
            } else {
                model.addAttribute("alertMsg", "판매처를 성공적으로 등록했습니다.");
            }
        } else {
            model.addAttribute("alertMsg", "판매처 등록에 실패했습니다.");
        }

        return "common/alert";
    }

    @ResponseBody
    @RequestMapping(value = "/modifySellerAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String modifySellerAction(HttpServletRequest request, SellerVO sellerVO, HttpSession session){

        int result = sellerService.update(sellerVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }
}
