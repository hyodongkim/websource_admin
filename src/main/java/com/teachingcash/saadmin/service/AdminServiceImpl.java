package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.mapper.AdminMapper;
import com.teachingcash.saadmin.vo.AdminmemberVO;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public HashMap<String, Object> selectAdmin(HashMap<String, Object> map) {
        return adminMapper.selectAdmin(map);
    }

    @Override
    public int insertAdminLog(HashMap<String, Object> map) {
        return adminMapper.insertAdminLog(map);
    }


}
