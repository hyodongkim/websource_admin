package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.FaqService;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.vo.FaqVO;
import com.teachingcash.saadmin.vo.MemberVO;
import com.teachingcash.util.Utils;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class FaqController {
    private static final Logger logger = LoggerFactory.getLogger(FaqController.class);

    @Autowired
    FaqService faqService;

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/faqList.do", method = RequestMethod.GET)
    public String faqList(ModelMap model, HttpServletRequest request, PageVO pageVO, FaqVO faqVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(faqVO == null){
            faqVO = new FaqVO();
        }
        faqVO.setStart(start);
        faqVO.setLimit(10);

        int total = faqService.selectCntFaq(faqVO);
        List<FaqVO> list = faqService.listFaq(faqVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("faqVO", faqVO);

        return "/admin/faq_list";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteFaqAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deleteFaqAction(HttpServletRequest request, FaqVO faqVO, HttpSession session){

        int result = faqService.deleteFaq(faqVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/faqBoth.do", method = RequestMethod.GET)
    public String faqBoth(ModelMap model, HttpServletRequest request, FaqVO pFaqVO, HttpSession session){
        FaqVO faqVO = new FaqVO();
        FileVO fileVO = new FileVO();

        if(pFaqVO.getId() > 0){
            faqVO = faqService.selectFaq(pFaqVO);
            fileVO.setParentId(pFaqVO.getId());
            fileVO = fileService.selectFile(fileVO);

            model.addAttribute("fvo", fileVO);
        }

        model.addAttribute("item", faqVO);

        return "/admin/faq_both";
    }

    @RequestMapping(value = "/faqBoth.do", method = RequestMethod.POST)
    public String faqBoth (ModelMap model, HttpServletRequest request, FaqVO pvo) throws Exception {

        int result = faqService.insertFaq(request, pvo, null);

        if (result > 0) {
            model.addAttribute("redirectUrl", "faqList.do");

            if (pvo.getId() > 0) {
                model.addAttribute("alertMsg", "FAQ를 성공적으로 수정했습니다.");
            } else {
                model.addAttribute("alertMsg", "FAQ를 성공적으로 작성했습니다.");
            }
        } else {
            model.addAttribute("alertMsg", "FAQ 작성에 실패했습니다.");
        }

        return "common/alert";
    }

    @ResponseBody
    @RequestMapping(value = "/modifyFaqAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String modifyFaqAction(HttpServletRequest request, FaqVO faqVO, HttpSession session){

        int result = faqService.update(faqVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/faqExcelList.do", method = RequestMethod.GET)
    public String memberExcelList(ModelMap model, HttpServletRequest request, PageVO pageVO, FaqVO faqVO) {

        int start = 0;//(pageVO.getPageIndex() -1) * 10;

        if(faqVO == null){
            faqVO = new FaqVO();
        }
        faqVO.setStart(start);
        faqVO.setLimit(99999999);
        int total = faqService.selectCntFaq(faqVO);
        List list = faqService.listFaq(faqVO);

        List list1 = new ArrayList<FaqVO>();
        for (int i=0; i<list.size(); i++){
            FaqVO faqVO1 = (FaqVO) list.get(i);
            faqVO1.setContent_editor(Utils.removeTags(faqVO1.getContent_editor()));
            list1.add(faqVO1);
        }

        model.addAttribute("list", list1);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("faqVO", faqVO);

        return "/admin/faq_excel_list";
    }
}
