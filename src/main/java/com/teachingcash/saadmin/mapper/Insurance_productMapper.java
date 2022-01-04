package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.Insurance_productVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("insurance_productMapper")
public interface Insurance_productMapper {
    int selectCntInsurance_product(Insurance_productVO insurance_productVO);

    int insertInsurance_product(Insurance_productVO insurance_productVO);

    List<Object> listInsurance_product(Insurance_productVO insurance_productVO);

    int deleteInsurance_product(Insurance_productVO insurance_productVO);

    Insurance_productVO selectInsurance_product(Insurance_productVO insurance_productVO);

    int update(Insurance_productVO insurance_productVO);

    int getMaxPkInsurance_product();

}
