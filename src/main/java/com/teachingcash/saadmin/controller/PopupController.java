package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.PopupService;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.vo.PopupVO;
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
public class PopupController {
    private static final Logger logger = LoggerFactory.getLogger(PopupController.class);

    @Autowired
    PopupService popupService;

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/popupList.do", method = RequestMethod.GET)
    public String popupList(ModelMap model, HttpServletRequest request, PageVO pageVO, PopupVO popupVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(popupVO == null){
            popupVO = new PopupVO();
        }
        popupVO.setStart(start);
        popupVO.setLimit(10);

        int total = popupService.selectCntPopup(popupVO);
        List<Object> list = popupService.listPopup(popupVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("popupVO", popupVO);

        return "/admin/popup_list";
    }

    @ResponseBody
    @RequestMapping(value = "/deletePopupAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deletePopupAction(HttpServletRequest request, PopupVO popupVO, HttpSession session){

        int result = popupService.deletePopup(popupVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/popupBoth.do", method = RequestMethod.GET)
    public String popupBoth(ModelMap model, HttpServletRequest request, PopupVO pPopupVO, HttpSession session){
        PopupVO popupVO = new PopupVO();
        FileVO fileVO = new FileVO();

        if(pPopupVO.getId() > 0){
            popupVO = popupService.selectPopup(pPopupVO);
            fileVO.setParentId(pPopupVO.getId());
            fileVO = fileService.selectFile(fileVO);

            model.addAttribute("fvo", fileVO);
        }

        model.addAttribute("item", popupVO);

//        List<Object> listCategory = popupService.listCategory();
//        model.addAttribute("listCategory", listCategory);

        return "/admin/popup_both";
    }

    @RequestMapping(value = "/popupBoth.do", method = RequestMethod.POST)
    public String popupBoth (ModelMap model, HttpServletRequest request, PopupVO pvo, @RequestParam(value = "community", required = false) MultipartFile file) throws Exception {

        /*
        if(pvo.getCategory_new() != null && !pvo.getCategory_new().equals("")){
            pvo.setCategory(pvo.getCategory_new());
        }

        if(pvo.getCategory_en_new() != null && !pvo.getCategory_en_new().equals("")){
            pvo.setCategory_en(pvo.getCategory_en_new());
        }
        
         */

        int result = popupService.insertPopup(request, pvo, file);

        if (result > 0) {
            model.addAttribute("redirectUrl", "popupList.do");

            if (pvo.getId() > 0) {
                model.addAttribute("alertMsg", "팝업을 성공적으로 수정했습니다.");
            } else {
                model.addAttribute("alertMsg", "팝업을 성공적으로 작성했습니다.");
            }
        } else {
            model.addAttribute("alertMsg", "팝업 작성에 실패했습니다.");
        }

        return "common/alert";
    }

    @ResponseBody
    @RequestMapping(value = "/modifyPopupAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String modifyPopupAction(HttpServletRequest request, PopupVO popupVO, HttpSession session){

        int result = popupService.update(popupVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }
}
