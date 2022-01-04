package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.CustomercenterVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("customercenterMapper")
public interface CustomercenterMapper {
    int selectCntCustomercenter(CustomercenterVO customercenterVO);

    int insertCustomercenter(CustomercenterVO customercenterVO);

    List<Object> listCustomercenter(CustomercenterVO customercenterVO);

    int deleteCustomercenter(CustomercenterVO customercenterVO);

    CustomercenterVO selectCustomercenter(CustomercenterVO customercenterVO);

    int update(CustomercenterVO customercenterVO);

    int getMaxPkCustomercenter();
}
