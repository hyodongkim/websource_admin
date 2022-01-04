package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.NotificationMemberVO;
import com.teachingcash.saadmin.vo.NotificationVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("notificationMapper")
public interface NotificationMapper {
    int selectCntNotification(NotificationVO notificationVO);

    int insertNotification(NotificationVO notificationVO);

    List<Object> listNotification(NotificationVO notificationVO);

    int deleteNotification(NotificationVO notificationVO);

    NotificationVO selectNotification(NotificationVO notificationVO);

    int update(NotificationVO notificationVO);

    int getMaxPkNotification();

    int insertNotificationsMembers(NotificationMemberVO notificationMemberVO);

    int deleteNotificationsMembers(NotificationMemberVO notificationMemberVO);

}
