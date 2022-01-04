package com.teachingcash.saadmin.service;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.MemberMapper;
import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.vo.MemberLeaveVO;
import com.teachingcash.saadmin.vo.MemberVO;
import com.teachingcash.saadmin.vo.NotificationVO;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService{


    @Autowired
    FileMapper fileMapper;

    @Autowired
    MemberMapper memberMapper;

    @Override
    public List<MemberVO> selectAllMember(){ return this.memberMapper.selectAllMember(); }

    @Override
    public int selectCntMember(MemberVO memberVO){
        return this.memberMapper.selectCntMember(memberVO);
    }

    @Override
    public int insertMember(HttpServletRequest request, MemberVO memberVO, MultipartFile file){
        int result = 0;

        if(memberVO.getId() > 0) {
            result = memberMapper.update(memberVO);
        }
        return result;
    }

    @Override
    public List<Object> listMember(MemberVO memberVO){
        return this.memberMapper.listMember(memberVO);
    }

    @Override
    public int deleteMember(MemberVO memberVO){
        return this.memberMapper.deleteMember(memberVO);
    }

    @Override
    public MemberVO selectMember(MemberVO memberVO){
        return this.memberMapper.selectMember(memberVO);
    }

    @Override
    public MemberVO selectMemberLogin(MemberVO memberVO){
        return this.memberMapper.selectMemberLogin(memberVO);
    }



    @Override
    public int update(MemberVO memberVO){
        return this.memberMapper.update(memberVO);
    }

    @Override
    public int leave(MemberVO memberVO){
        return this.memberMapper.leave(memberVO);
    }

    @Override
    public int getMaxPkMember() {
        return this.memberMapper.getMaxPkMember();
    }

    @Override
    public int resetPassword(String id){ return this.memberMapper.resetPassword(id);}

    @Override
    public List<MemberLeaveVO> listMemberLeave(MemberLeaveVO memberLeaveVO){ return this.memberMapper.listMemberLeave(memberLeaveVO);}

    @Override
    public int leaveBusinesses(MemberVO memberVO) { return this.memberMapper.leaveBusinesses(memberVO);}

    @Override
    public int selectCntMemberLeave(MemberLeaveVO memberLeaveVO){ return this.memberMapper.selectCntMemberLeave(memberLeaveVO);}

    @Override
    public int insertLeaveMember(MemberLeaveVO memberLeaveVO){ return this.memberMapper.insertLeaveMember(memberLeaveVO);}

    @Override
    public List<MemberVO> listPushMember(NotificationVO notificationVO){ return this.memberMapper.listPushMember(notificationVO);}
}
