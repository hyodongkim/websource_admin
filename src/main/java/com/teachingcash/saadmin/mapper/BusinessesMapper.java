package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.BusinessesVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("businessesMapper")
public interface BusinessesMapper {
    List<Object> listBusinesses(BusinessesVO businessesVO);
    int removeBusiness(BusinessesVO businessesVO);
}
