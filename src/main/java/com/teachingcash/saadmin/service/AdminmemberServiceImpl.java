package com.teachingcash.saadmin.service;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.AdminmemberMapper;
import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.vo.AdminmemberVO;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminmemberServiceImpl implements AdminmemberService{


    @Autowired
    FileMapper fileMapper;

    @Autowired
    AdminmemberMapper adminmemberMapper;

    @Override
    public int selectCntAdminmember(AdminmemberVO adminmemberVO){
        return this.adminmemberMapper.selectCntAdminmember(adminmemberVO);
    }

    @Override
    public int insertAdminmember(HttpServletRequest request, AdminmemberVO adminmemberVO, MultipartFile file){
        int result = 0;
        int parentId = adminmemberVO.getId();

        if(adminmemberVO.getId() > 0) {
            result = adminmemberMapper.update(adminmemberVO);
        }else{
            result = adminmemberMapper.insertAdminmember(adminmemberVO);
        }
        return result;
    }

    @Override
    public List<Object> listAdminmember(AdminmemberVO adminmemberVO){
        return this.adminmemberMapper.listAdminmember(adminmemberVO);
    }

    @Override
    public int deleteAdminmember(AdminmemberVO adminmemberVO){
        return this.adminmemberMapper.deleteAdminmember(adminmemberVO);
    }

    @Override
    public AdminmemberVO selectAdminmember(AdminmemberVO adminmemberVO){
        return this.adminmemberMapper.selectAdminmember(adminmemberVO);
    }

    @Override
    public AdminmemberVO selectAdminmemberLogin(AdminmemberVO adminmemberVO){
        return this.adminmemberMapper.selectAdminmemberLogin(adminmemberVO);
    }



    @Override
    public int update(AdminmemberVO adminmemberVO){
        return this.adminmemberMapper.update(adminmemberVO);
    }

    @Override
    public int getMaxPkAdminmember() {
        return this.adminmemberMapper.getMaxPkAdminmember();
    }

    @Override
    public int updateRecentAccess(AdminmemberVO adminmemberVO){ return adminmemberMapper.updateRecentAccess(adminmemberVO);}
}
