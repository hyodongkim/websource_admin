package com.teachingcash.saadmin.controller;

import com.teachingcash.saadmin.service.AdminService;
import com.teachingcash.saadmin.service.AdminmemberService;
import com.teachingcash.saadmin.vo.AdminmemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping(value="/")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    AdminmemberService adminmemberService;

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String index(ModelMap model, HttpServletRequest request) {
        return login(model, request);
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String login(ModelMap model, HttpServletRequest request) {
        return "/admin/login";
    }

    @ResponseBody
    @RequestMapping(value = "/loginAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String loginAction(HttpServletRequest request, AdminmemberVO adminmemberVO, HttpSession session){

        /*
        아이디, 비밀번호 필수체크
         */
        if(adminmemberVO.getAdminid() == null || adminmemberVO.getAdminid().equals("")){
            return "아이디를 입력하세요.";
        }
        if(adminmemberVO.getPasswd() == null || adminmemberVO.getPasswd().equals("")){
            return "비밀번호를 입력하세요.";
        }

        /*
        로그인 성공시, pk_admin을 세션에 저장, 최근 방문일 업데이트...
         */
        AdminmemberVO adminmemberVOResult = adminmemberService.selectAdminmemberLogin(adminmemberVO);
        if(adminmemberVOResult != null && adminmemberVOResult.getAdminid() != null && ((Integer) adminmemberVOResult.getId()).intValue() > 0) {
            adminmemberService.updateRecentAccess(adminmemberVOResult);
            session.setAttribute("adminLogin", "Y");
            return "SUCCESS";
        }else{
            return "아이디와 비밀번호를 확인하세요.";
        }
    }

    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    public String logout(ModelMap model, HttpServletRequest request, HttpSession session) {
        session.setAttribute("adminLogin", "");
        return "/admin/login";
    }
}
