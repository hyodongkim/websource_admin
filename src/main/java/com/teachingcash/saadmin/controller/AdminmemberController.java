package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.AdminmemberService;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.vo.AdminmemberVO;
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
public class AdminmemberController {
    private static final Logger logger = LoggerFactory.getLogger(AdminmemberController.class);

    @Autowired
    AdminmemberService adminmemberService;

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/adminmemberList.do", method = RequestMethod.GET)
    public String adminmemberList(ModelMap model, HttpServletRequest request, PageVO pageVO, AdminmemberVO adminmemberVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(adminmemberVO == null){
            adminmemberVO = new AdminmemberVO();
        }
        adminmemberVO.setStart(start);
        adminmemberVO.setLimit(10);
        int total = adminmemberService.selectCntAdminmember(adminmemberVO);
        List list = adminmemberService.listAdminmember(adminmemberVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("adminmemberVO", adminmemberVO);

        return "/admin/adminmember_list";
    }


    @RequestMapping(value = "/adminmemberExcelList.do", method = RequestMethod.GET)
    public String adminmemberExcelList(ModelMap model, HttpServletRequest request, PageVO pageVO, AdminmemberVO adminmemberVO) {

        int start = 0;

        if(adminmemberVO == null){
            adminmemberVO = new AdminmemberVO();
        }
        adminmemberVO.setStart(start);
        adminmemberVO.setLimit(9999999);
        int total = adminmemberService.selectCntAdminmember(adminmemberVO);
        List list = adminmemberService.listAdminmember(adminmemberVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("adminmemberVO", adminmemberVO);

        return "/admin/adminmember_excel_list";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteAdminmemberAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deleteAdminmemberAction(HttpServletRequest request, AdminmemberVO adminmemberVO, HttpSession session){

        int result = adminmemberService.deleteAdminmember(adminmemberVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/adminmemberBoth.do", method = RequestMethod.GET)
    public String adminmemberBoth(ModelMap model, HttpServletRequest request, AdminmemberVO pAdminmemberVO, HttpSession session){
        AdminmemberVO adminmemberVO = new AdminmemberVO();
        FileVO fileVO = new FileVO();

        if(pAdminmemberVO.getId() > 0){
            adminmemberVO = adminmemberService.selectAdminmember(pAdminmemberVO);
            fileVO.setParentId(pAdminmemberVO.getId());
            fileVO = fileService.selectFile(fileVO);

            model.addAttribute("fvo", fileVO);
        }

        model.addAttribute("item", adminmemberVO);

//        List<Object> listCategory = adminmemberService.listCategory();
//        model.addAttribute("listCategory", listCategory);

        return "/admin/adminmember_both";
    }

    @RequestMapping(value = "/adminmemberBoth.do", method = RequestMethod.POST)
    public String adminmemberBoth (ModelMap model, HttpServletRequest request, AdminmemberVO bvo, @RequestParam(value = "community", required = false) MultipartFile file) throws Exception {


        int result = adminmemberService.insertAdminmember(request, bvo, file);

        if (result > 0) {
            model.addAttribute("redirectUrl", "adminmemberList.do");

            if (bvo.getId() > 0) {
                model.addAttribute("alertMsg", "관리자를 성공적으로 수정했습니다.");
            } else {
                model.addAttribute("alertMsg", "관리자를 성공적으로 등록했습니다.");
            }
        } else {
            model.addAttribute("alertMsg", "관리자를 등록하는 데 실패했습니다.");
        }

        return "common/alert";
    }

    @ResponseBody
    @RequestMapping(value = "/modifyAdminmemberAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String modifyAdminmemberAction(HttpServletRequest request, AdminmemberVO adminmemberVO, HttpSession session){

        int result = adminmemberService.update(adminmemberVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }
}
