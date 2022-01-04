package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.QuoteService;
import com.teachingcash.saadmin.vo.QuoteVO;
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
public class QuoteController {
    private static final Logger logger = LoggerFactory.getLogger(QuoteController.class);

    @Autowired
    QuoteService quoteService;

    @RequestMapping(value = "/quoteList.do", method = RequestMethod.GET)
    public String quoteList(ModelMap model, HttpServletRequest request, PageVO pageVO, QuoteVO quoteVO) {

        logger.debug("quoteVO:::::" + quoteVO);

        int start = (pageVO.getPageIndex() -1) * 10;

        if(quoteVO == null){
            quoteVO = new QuoteVO();
        }
        quoteVO.setStart(start);
        quoteVO.setLimit(10);
        int total = quoteService.selectCntQuote(quoteVO);
        List list = quoteService.listQuote(quoteVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("quoteVO", quoteVO);

        logger.debug("quoteVO::::" + quoteVO.getName());

        SimpleDateFormat formatToday = new SimpleDateFormat( "yyyy-MM-dd");
        Date time = new Date();
        String today = formatToday.format(time);

        model.addAttribute("today", today);

        return "/admin/quote_list";
    }

    @ResponseBody
    @RequestMapping(value = "/changeQuoteProcessAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String changeQuoteProcessAction(HttpServletRequest request, QuoteVO quoteVO, HttpSession session){

        int result = quoteService.updateProcessYN(quoteVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/deleteQuoteAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deleteQuoteAction(HttpServletRequest request, QuoteVO quoteVO, HttpSession session){

        int result = quoteService.deleteQuote(quoteVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/viewQuote.do", method = RequestMethod.GET)
    public String viewQuote(ModelMap model, HttpServletRequest request, QuoteVO quoteVO, HttpSession session){

        quoteVO = quoteService.selectQuote(quoteVO);

        model.addAttribute("item", quoteVO);

        return "/admin/quote_view";
    }
}
