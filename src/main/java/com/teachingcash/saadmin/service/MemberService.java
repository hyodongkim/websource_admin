package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.MemberLeaveVO;
import com.teachingcash.saadmin.vo.MemberVO;
import com.teachingcash.saadmin.vo.NotificationVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MemberService {

    int selectCntMember(MemberVO memberVO);

    int insertMember(HttpServletRequest request, MemberVO memberVO, MultipartFile file);

    List<Object> listMember(MemberVO memberVO);

    int deleteMember(MemberVO memberVO);

    MemberVO selectMember(MemberVO memberVO);

    MemberVO selectMemberLogin(MemberVO memberVO);

    int update(MemberVO memberVO);

    int leave(MemberVO memberVO);
    int leaveBusinesses(MemberVO memberVO);

    int getMaxPkMember();

    int resetPassword(String id);

    List<MemberVO> selectAllMember();

    List<MemberLeaveVO> listMemberLeave(MemberLeaveVO memberLeaveVO);
    int selectCntMemberLeave(MemberLeaveVO memberLeaveVO);

    int insertLeaveMember(MemberLeaveVO memberLeaveVO);

    List<MemberVO> listPushMember(NotificationVO notificationVO);
}
