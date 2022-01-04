package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.Insurance_productVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface Insurance_productService {

    int selectCntInsurance_product(Insurance_productVO insurance_productVO);

    int insertInsurance_product(HttpServletRequest request, Insurance_productVO insurance_productVO, MultipartFile file1, MultipartFile file2);

    List<Object> listInsurance_product(Insurance_productVO insurance_productVO);

    int deleteInsurance_product(Insurance_productVO insurance_productVO);

    Insurance_productVO selectInsurance_product(Insurance_productVO insurance_productVO);

    int update(Insurance_productVO insurance_productVO);

    int getMaxPkInsurance_product();
}
