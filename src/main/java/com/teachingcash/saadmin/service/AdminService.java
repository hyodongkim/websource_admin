package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.AdminmemberVO;

import java.util.HashMap;

public interface AdminService {
    HashMap<String, Object> selectAdmin(HashMap<String, Object> map);

    int insertAdminLog(HashMap<String, Object> map);


}

