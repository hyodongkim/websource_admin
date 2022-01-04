package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.PartnerService;
import com.teachingcash.saadmin.vo.PartnerVO;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class PartnerController {
    private static final Logger logger = LoggerFactory.getLogger(PartnerController.class);

    @Autowired
    PartnerService partnerService;

    @RequestMapping(value = "/partnerList.do", method = RequestMethod.GET)
    public String partnerList(ModelMap model, HttpServletRequest request, PageVO pageVO, PartnerVO partnerVO)  {

        logger.debug("partnerVO:::::" + partnerVO);

        int start = (pageVO.getPageIndex() -1) * 10;

        if(partnerVO == null){
            partnerVO = new PartnerVO();
        }
        partnerVO.setStart(start);
        partnerVO.setLimit(10);
        List<Object> list = partnerService.listPartner(partnerVO);
        int total = partnerService.selectCntPartner(partnerVO);

        logger.debug("total:::::::::::::" + total);

        SimpleDateFormat formatToday = new SimpleDateFormat( "yyyy-MM-dd");
        Date time = new Date();
        String today = formatToday.format(time);

        model.addAttribute("today", today);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("partnerVO", partnerVO);

        logger.debug("partnerVO::::" + partnerVO.getName());


        return "/admin/partner_list";
    }

    @ResponseBody
    @RequestMapping(value = "/changePartnerProcessAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String changePartnerProcessAction(HttpServletRequest request, PartnerVO partnerVO, HttpSession session){

        int result = partnerService.updateProcessYN(partnerVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/deletePartnerAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deletePartnerAction(HttpServletRequest request, PartnerVO partnerVO, HttpSession session){

        int result = partnerService.deletePartner(partnerVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/viewPartner.do", method = RequestMethod.GET)
    public String viewPartner(ModelMap model, HttpServletRequest request, PartnerVO partnerVO, HttpSession session){

        partnerVO = partnerService.selectPartner(partnerVO);

        model.addAttribute("item", partnerVO);

        return "/admin/partner_view";

    }
}
