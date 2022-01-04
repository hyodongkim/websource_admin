package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.CustomercenterVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CustomercenterService {

    int selectCntCustomercenter(CustomercenterVO customercenterVO);

    int insertCustomercenter(HttpServletRequest request, CustomercenterVO customercenterVO, MultipartFile file);

    List<Object> listCustomercenter(CustomercenterVO customercenterVO);

    int deleteCustomercenter(CustomercenterVO customercenterVO);

    CustomercenterVO selectCustomercenter(CustomercenterVO customercenterVO);

    int update(CustomercenterVO customercenterVO);

    int getMaxPkCustomercenter();
}
