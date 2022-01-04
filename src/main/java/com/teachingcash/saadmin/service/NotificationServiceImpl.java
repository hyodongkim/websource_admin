package com.teachingcash.saadmin.service;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.mapper.MemberMapper;
import com.teachingcash.saadmin.mapper.NotificationMapper;
import com.teachingcash.saadmin.vo.MemberVO;
import com.teachingcash.saadmin.vo.NotificationMemberVO;
import com.teachingcash.saadmin.vo.NotificationVO;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotificationServiceImpl implements NotificationService{


    @Autowired
    FileMapper fileMapper;

    @Autowired
    NotificationMapper notificationMapper;

    @Autowired
    MemberMapper memberMapper;


    @Override
    public int selectCntNotification(NotificationVO notificationVO){
        return this.notificationMapper.selectCntNotification(notificationVO);
    }

    @Override
    public int insertNotification(HttpServletRequest request, NotificationVO notificationVO){
        int result = 0;
        int parentId = notificationVO.getId();

        Map<String, Object> map = new HashMap<String, Object>();
        /*map.put("id", notificationVO.getDeleteFileSeq());*/

        /*if (notificationVO.getDeleteFileSeq() > 0) { fileMapper.deleteFile(map); }*/

        if(notificationVO.getId() > 0) {
            result = notificationMapper.update(notificationVO);

            NotificationMemberVO notificationMemberVO1 = new NotificationMemberVO();
            notificationMemberVO1.setNotifications_id(parentId);
            notificationMapper.deleteNotificationsMembers(notificationMemberVO1);
        }else{
            result = notificationMapper.insertNotification(notificationVO);

            parentId = notificationMapper.getMaxPkNotification();
        }

        if(notificationVO.getEnabled().equals("사용") && notificationVO.getPush().equals("진행")){
            List<MemberVO> list = memberMapper.selectAllMember();
            for (int i=0; i<list.size(); i++){

                MemberVO memberVO = (MemberVO) list.get(i);

                NotificationMemberVO notificationMemberVO = new NotificationMemberVO();
                notificationMemberVO.setMembers_id(memberVO.getId());
                notificationMemberVO.setNotifications_id(parentId);

                notificationMapper.insertNotificationsMembers(notificationMemberVO);
            }
        }

        return result;
    }

    @Override
    public List<Object> listNotification(NotificationVO notificationVO){
        return this.notificationMapper.listNotification(notificationVO);
    }

    @Override
    public int deleteNotification(NotificationVO notificationVO){
        return this.notificationMapper.deleteNotification(notificationVO);
    }

    @Override
    public NotificationVO selectNotification(NotificationVO notificationVO){
        return this.notificationMapper.selectNotification(notificationVO);
    }

    @Override
    public int update(NotificationVO notificationVO){
        return this.notificationMapper.update(notificationVO);
    }

    @Override
    public int getMaxPkNotification() {
        return this.notificationMapper.getMaxPkNotification();
    }

    @Override
    public int insertNotificationsMembers(NotificationMemberVO notificationMemberVO){ return this.notificationMapper.insertNotificationsMembers(notificationMemberVO); }

    @Override
    public int deleteNotificationsMembers(NotificationMemberVO notificationMemberVO){ return this.notificationMapper.deleteNotificationsMembers(notificationMemberVO); }


    /*
    @Override
    public List<Object> listCategory(){
        return this.notificationMapper.listCategory();
    }

    @Override
    public List<Object> listCategoryEn(){
        return this.notificationMapper.listCategoryEn();
    }

    @Override
    public List<Object> listNotificationTopPost(NotificationVO notificationVO){
        return this.notificationMapper.listNotificationTopPost(notificationVO);
    }

    @Override
    public NotificationVO getTopPost(){
        return this.notificationMapper.getTopPost();
    }

    @Override
    public NotificationVO selectNotificationPrev(HashMap<String, Object> map) {
        return this.notificationMapper.selectNotificationPrev(map);
    }

    @Override
    public NotificationVO selectNotificationNext(HashMap<String, Object> map) {
        return this.notificationMapper.selectNotificationNext(map);
    }

     */
}
