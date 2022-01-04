package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.MemberService;
import com.teachingcash.saadmin.service.NotificationService;
import com.teachingcash.saadmin.vo.MemberVO;
import com.teachingcash.saadmin.vo.NotificationVO;
import com.teachingcash.util.Utils;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class NotificationController {
    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    NotificationService notificationService;

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/notificationList.do", method = RequestMethod.GET)
    public String notificationList(ModelMap model, HttpServletRequest request, PageVO pageVO, NotificationVO notificationVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(notificationVO == null){
            notificationVO = new NotificationVO();
        }
        notificationVO.setStart(start);
        notificationVO.setLimit(10);

        int total = notificationService.selectCntNotification(notificationVO);
        List<Object> list = notificationService.listNotification(notificationVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("notificationVO", notificationVO);

        return "/admin/notification_list";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteNotificationAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deleteNotificationAction(HttpServletRequest request, NotificationVO notificationVO, HttpSession session){

        int result = notificationService.deleteNotification(notificationVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/notificationBoth.do", method = RequestMethod.GET)
    public String notificationBoth(ModelMap model, HttpServletRequest request, NotificationVO pNotificationVO, HttpSession session){
        NotificationVO notificationVO = new NotificationVO();

        if(pNotificationVO.getId() > 0){
            notificationVO = notificationService.selectNotification(pNotificationVO);
        }

        model.addAttribute("item", notificationVO);

//        List<Object> listCategory = notificationService.listCategory();
//        model.addAttribute("listCategory", listCategory);

        return "/admin/notification_both";
    }

    @RequestMapping(value = "/notificationView.do", method = RequestMethod.GET)
    public String notificationView(ModelMap model, HttpServletRequest request, NotificationVO notificationVO, HttpSession session){

        notificationVO = notificationService.selectNotification(notificationVO);

        model.addAttribute("item", notificationVO);

        return "/admin/notification_view";
    }

    @RequestMapping(value = "/notificationBoth.do", method = RequestMethod.POST)
    public String notificationBoth (ModelMap model, HttpServletRequest request, NotificationVO pvo) throws Exception {

        /*
        if(pvo.getCategory_new() != null && !pvo.getCategory_new().equals("")){
            pvo.setCategory(pvo.getCategory_new());
        }

        if(pvo.getCategory_en_new() != null && !pvo.getCategory_en_new().equals("")){
            pvo.setCategory_en(pvo.getCategory_en_new());
        }

         */

        int result = notificationService.insertNotification(request, pvo);

        if (result > 0) {
            model.addAttribute("redirectUrl", "notificationList.do");

            if (result == 1) {
                model.addAttribute("alertMsg", "알림을 성공적으로 작성했습니다.");
            } else if (result == 2) {
                model.addAttribute("alertMsg", "알림을 성공적으로 수정했습니다.");
            }
        } else {
            model.addAttribute("alertMsg", "알림 작성에 실패했습니다.");
        }

        return "common/alert";
    }

    @ResponseBody
    @RequestMapping(value = "/modifyNotificationAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String modifyNotificationAction(HttpServletRequest request, NotificationVO notificationVO, HttpSession session){

        int result = notificationService.update(notificationVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @ResponseBody
    @GetMapping(value = "/sendPush.do", produces = "text/html; charset=UTF-8")
    public String sendPush(HttpServletRequest request, String id){

        System.out.println("id::::::::::::::::::::" + id);

        NotificationVO notificationVO = new NotificationVO();
        notificationVO.setId(new Integer(id).intValue());
        notificationVO = notificationService.selectNotification(notificationVO);

        List<MemberVO> memberVOList = memberService.listPushMember(notificationVO);

        System.out.println(memberVOList);

        for (int i=0; i<memberVOList.size(); i++){
            MemberVO memberVO = (MemberVO) memberVOList.get(i);
            String _token = memberVO.getApp_token();
            String _title = notificationVO.getSubject();
            String _body = notificationVO.getPush_msg();
            try {
                Utils.sendPush(_token, _title, _body);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "SUCCESS";
    }
}
