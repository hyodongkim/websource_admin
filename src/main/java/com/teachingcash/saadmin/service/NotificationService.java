package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.NotificationMemberVO;
import com.teachingcash.saadmin.vo.NotificationVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface NotificationService {

    int selectCntNotification(NotificationVO notificationVO);

    int insertNotification(HttpServletRequest request, NotificationVO notificationVO);

    List<Object> listNotification(NotificationVO notificationVO);

    int deleteNotification(NotificationVO notificationVO);

    NotificationVO selectNotification(NotificationVO notificationVO);

    int update(NotificationVO notificationVO);

    int getMaxPkNotification();

    int insertNotificationsMembers(NotificationMemberVO notificationMemberVO);

    int deleteNotificationsMembers(NotificationMemberVO notificationMemberVO);

}
