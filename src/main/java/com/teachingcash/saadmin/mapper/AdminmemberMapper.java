package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.AdminmemberVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("adminmemberMapper")
public interface AdminmemberMapper {
    int selectCntAdminmember(AdminmemberVO adminmemberVO);

    int insertAdminmember(AdminmemberVO adminmemberVO);

    List<Object> listAdminmember(AdminmemberVO adminmemberVO);

    int deleteAdminmember(AdminmemberVO adminmemberVO);

    AdminmemberVO selectAdminmember(AdminmemberVO adminmemberVO);

    AdminmemberVO selectAdminmemberLogin(AdminmemberVO adminmemberVO);

    int update(AdminmemberVO adminmemberVO);

    int getMaxPkAdminmember();

    int updateRecentAccess(AdminmemberVO adminmemberVO);

}
