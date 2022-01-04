package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.Insurance_categoryVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface Insurance_categoryService {

    int selectCntInsurance_category(Insurance_categoryVO insurance_categoryVO);

    int insertInsurance_category(HttpServletRequest request, Insurance_categoryVO insurance_categoryVO, MultipartFile file);

    List<Object> listInsurance_category(Insurance_categoryVO insurance_categoryVO);

    int deleteInsurance_category(Insurance_categoryVO insurance_categoryVO);

    Insurance_categoryVO selectInsurance_category(Insurance_categoryVO insurance_categoryVO);

    int update(Insurance_categoryVO insurance_categoryVO);

    int getMaxPkInsurance_category();

    List<Object> listEnabledInsuranceCategory();
}
