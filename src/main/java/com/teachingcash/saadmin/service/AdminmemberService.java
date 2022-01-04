package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.AdminmemberVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AdminmemberService {

    int selectCntAdminmember(AdminmemberVO adminmemberVO);

    int insertAdminmember(HttpServletRequest request, AdminmemberVO adminmemberVO, MultipartFile file);

    List<Object> listAdminmember(AdminmemberVO adminmemberVO);

    int deleteAdminmember(AdminmemberVO adminmemberVO);

    AdminmemberVO selectAdminmember(AdminmemberVO adminmemberVO);

    AdminmemberVO selectAdminmemberLogin(AdminmemberVO adminmemberVO);

    int update(AdminmemberVO adminmemberVO);

    int getMaxPkAdminmember();

    int updateRecentAccess(AdminmemberVO adminmemberVO);
}
