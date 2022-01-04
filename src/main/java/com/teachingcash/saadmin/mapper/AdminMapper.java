package com.teachingcash.saadmin.mapper;


import com.teachingcash.saadmin.vo.AdminmemberVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.HashMap;


@Mapper("adminMapper")
public interface AdminMapper {
    HashMap<String, Object> selectAdmin(HashMap<String, Object> map);
    int insertAdminLog(HashMap<String, Object> map);

}
