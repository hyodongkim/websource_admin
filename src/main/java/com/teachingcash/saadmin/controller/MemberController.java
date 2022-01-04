package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.BusinessesService;
import com.teachingcash.saadmin.service.MemberService;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.vo.BusinessesVO;
import com.teachingcash.saadmin.vo.MemberLeaveVO;
import com.teachingcash.saadmin.vo.MemberVO;
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
import java.lang.reflect.Member;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    MemberService memberService;

    @Autowired
    BusinessesService businessesService;

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
    public String memberList(ModelMap model, HttpServletRequest request, PageVO pageVO, MemberVO memberVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(memberVO == null){
            memberVO = new MemberVO();
        }
        memberVO.setStart(start);
        memberVO.setLimit(10);
        int total = memberService.selectCntMember(memberVO);
        List list = memberService.listMember(memberVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("memberVO", memberVO);

        return "/admin/member_list";
    }

    @RequestMapping(value = "/leaveList.do", method = RequestMethod.GET)
    public String leaveList(ModelMap model, HttpServletRequest request, PageVO pageVO, MemberLeaveVO memberLeaveVO) {

        int start = (pageVO.getPageIndex() -1) * 10;
        memberLeaveVO.setStart(start);
        memberLeaveVO.setLimit(10);
        int total = memberService.selectCntMemberLeave(memberLeaveVO);
        List list = memberService.listMemberLeave(memberLeaveVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("item", memberLeaveVO);

        return "/admin/member_leave_list";
    }

    @RequestMapping(value = "/memberExcelList.do", method = RequestMethod.GET)
    public String memberExcelList(ModelMap model, HttpServletRequest request, PageVO pageVO, MemberVO memberVO) {

        int start = 0;//(pageVO.getPageIndex() -1) * 10;

        if(memberVO == null){
            memberVO = new MemberVO();
        }
        memberVO.setStart(start);
        memberVO.setLimit(99999999);
        int total = memberService.selectCntMember(memberVO);
        List list = memberService.listMember(memberVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("memberVO", memberVO);

        return "/admin/member_excel_list";
    }

    @RequestMapping(value = "/memberLeaveExcelList.do", method = RequestMethod.GET)
    public String memberLeaveExcelList(ModelMap model, HttpServletRequest request, PageVO pageVO, MemberLeaveVO memberLeaveVO) {

        int start = 0;//(pageVO.getPageIndex() -1) * 10;

        if(memberLeaveVO == null){
            memberLeaveVO = new MemberLeaveVO();
        }
        memberLeaveVO.setStart(start);
        memberLeaveVO.setLimit(99999999);
        int total = memberService.selectCntMemberLeave(memberLeaveVO);
        List list = memberService.listMemberLeave(memberLeaveVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("item", memberLeaveVO);

        return "/admin/member_leave_excel_list";
    }

    @RequestMapping(value = "/memberView.do", method = RequestMethod.GET)
    public String memberView(ModelMap model, HttpServletRequest request, MemberVO memberVO, BusinessesVO businessesVO, HttpSession session){
        FileVO fileVO = new FileVO();
        memberVO = memberService.selectMember(memberVO);

        model.addAttribute("item", memberVO);

        businessesVO.setMember_id(memberVO.getId());
        List<Object> listBusinesses = businessesService.listBusinesses(businessesVO);

        model.addAttribute("listBusinesses",  listBusinesses);

        if(memberVO.getId() > 0){
            fileVO.setParentId(memberVO.getId());
            fileVO = fileService.selectFile(fileVO);

            model.addAttribute("fvo", fileVO);
        }

        return "/admin/member_view";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteMemberAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deleteMemberAction(HttpServletRequest request, MemberVO memberVO, HttpSession session){

        int result = memberService.deleteMember(memberVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/memberBoth.do", method = RequestMethod.GET)
    public String memberBoth(ModelMap model, HttpServletRequest request, MemberVO pMemberVO, BusinessesVO businessesVO, HttpSession session){
        MemberVO memberVO = new MemberVO();
        FileVO fileVO = new FileVO();

        if(pMemberVO.getId() > 0){
            memberVO = memberService.selectMember(pMemberVO);
            fileVO.setParentId(pMemberVO.getId());
            fileVO = fileService.selectFile(fileVO);

            model.addAttribute("fvo", fileVO);
        }

        model.addAttribute("item", memberVO);

        businessesVO.setMember_id(memberVO.getId());
        List<Object> listBusinesses = businessesService.listBusinesses(businessesVO);

        model.addAttribute("listBusinesses",  listBusinesses);

        return "/admin/member_both";
    }

    @RequestMapping(value = "/leave.do", method = RequestMethod.GET)
    public String memberBoth(ModelMap model, HttpServletRequest request, MemberVO memberVO){

        MemberVO memberVO1 = memberService.selectMember(memberVO);
        MemberLeaveVO memberLeaveVO = new MemberLeaveVO();
        memberLeaveVO.setName(memberVO1.getName());
        memberLeaveVO.setEmail(memberVO1.getEmail());
        memberService.insertLeaveMember(memberLeaveVO);

        memberService.leaveBusinesses(memberVO);
        memberService.leave(memberVO);
        model.addAttribute("redirectUrl", "memberList.do");
        model.addAttribute("alertMsg", "해당 회원을 탈퇴처리하였습니다.");

        return "common/alert";
    }

    @RequestMapping(value = "/memberBoth.do", method = RequestMethod.POST)
    public String memberBoth (ModelMap model, HttpServletRequest request, MemberVO bvo, @RequestParam(value = "community", required = false) MultipartFile file) throws Exception {

        int result = memberService.insertMember(request, bvo, file);

        if (result > 0) {
            model.addAttribute("redirectUrl", "memberList.do");
            model.addAttribute("alertMsg", "회원을 성공적으로 수정했습니다.");
        } else {
            model.addAttribute("alertMsg", "회원을 등록하는 데 실패했습니다.");
        }

        return "common/alert";
    }

    @ResponseBody
    @RequestMapping(value = "/modifyMemberAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String modifyMemberAction(HttpServletRequest request, MemberVO memberVO, HttpSession session){

        int result = memberService.update(memberVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/resetPassword.do", method = RequestMethod.GET)
    public String resetPassword(ModelMap model, HttpServletRequest request, String id){

        memberService.resetPassword(id);
        return "common/alert";
    }

    @RequestMapping(value = "/removeBusiness.do", method = RequestMethod.GET)
    public String removeBusiness(ModelMap model, HttpServletRequest request, String id){

        BusinessesVO businessesVO = new BusinessesVO();
        businessesVO.setId(new Integer(id).intValue());
        businessesService.removeBusiness(businessesVO);
        return "common/alert";
    }
}
