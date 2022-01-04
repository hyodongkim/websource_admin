package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.PolicyVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PolicyService {

    int selectCntPolicy(PolicyVO policyVO);

    int insertPolicy(HttpServletRequest request, PolicyVO policyVO, MultipartFile file);

    List<Object> listPolicy(PolicyVO policyVO);

    int deletePolicy(PolicyVO policyVO);

    PolicyVO selectPolicy(PolicyVO policyVO);

    int update(PolicyVO policyVO);

    int getMaxPkPolicy();
}
