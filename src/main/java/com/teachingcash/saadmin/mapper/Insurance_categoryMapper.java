package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.Insurance_categoryVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("insurance_categoryMapper")
public interface Insurance_categoryMapper {
    int selectCntInsurance_category(Insurance_categoryVO insurance_categoryVO);

    int insertInsurance_category(Insurance_categoryVO insurance_categoryVO);

    List<Object> listInsurance_category(Insurance_categoryVO insurance_categoryVO);

    int deleteInsurance_category(Insurance_categoryVO insurance_categoryVO);

    Insurance_categoryVO selectInsurance_category(Insurance_categoryVO insurance_categoryVO);

    int update(Insurance_categoryVO insurance_categoryVO);

    int getMaxPkInsurance_category();

    List<Object> listEnabledInsuranceCategory();

}
