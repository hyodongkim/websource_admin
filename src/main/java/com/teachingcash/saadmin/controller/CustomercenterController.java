package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.service.CustomercenterService;
import com.teachingcash.saadmin.vo.CustomercenterVO;
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
public class CustomercenterController {
    private static final Logger logger = LoggerFactory.getLogger(CustomercenterController.class);

    @Autowired
    CustomercenterService customercenterService;

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/customercenterView.do", method = RequestMethod.GET)
    public String customercenterView(ModelMap model, HttpServletRequest request, PageVO pageVO, CustomercenterVO customercenterVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(customercenterVO == null){
            customercenterVO = new CustomercenterVO();
        }
        /*customercenterVO.setStart(start);
        customercenterVO.setLimit(10);*/

        int total = customercenterService.selectCntCustomercenter(customercenterVO);
        List<Object> list = customercenterService.listCustomercenter(customercenterVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("customercenterVO", customercenterVO);

        return "customercenter_both";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteCustomercenterAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deleteCustomercenterAction(HttpServletRequest request, CustomercenterVO customercenterVO, HttpSession session){

        int result = customercenterService.deleteCustomercenter(customercenterVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/customercenterBoth.do", method = RequestMethod.GET)
    public String customercenterBoth(ModelMap model, HttpServletRequest request, CustomercenterVO pCustomercenterVO, HttpSession session){
        CustomercenterVO customercenterVO = customercenterService.selectCustomercenter(pCustomercenterVO);

        model.addAttribute("item", customercenterVO);
        return "/admin/customercenter_both";
    }

    @RequestMapping(value = "/customercenterBoth.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String modifyCustomercenterAction(ModelMap model, HttpServletRequest request, CustomercenterVO customercenterVO, HttpSession session) {

        int result = customercenterService.update(customercenterVO);
        if(result > 0) {
            model.addAttribute("alertMsg", "정보를 성공적으로 수정했습니다.");
        }else{
            model.addAttribute("alertMsg", "정보 수정에 실패했습니다.");
        }

        model.addAttribute("redirectUrl", "customercenterBoth.do");

        return "common/alert";
    }
}
