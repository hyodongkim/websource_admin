package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.MemberLeaveVO;
import com.teachingcash.saadmin.vo.MemberVO;
import com.teachingcash.saadmin.vo.NotificationMemberVO;
import com.teachingcash.saadmin.vo.NotificationVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("memberMapper")
public interface MemberMapper {
    int selectCntMember(MemberVO memberVO);

    int insertMember(MemberVO memberVO);

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
