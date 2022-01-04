package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.PolicyVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("policyMapper")
public interface PolicyMapper {
    int selectCntPolicy(PolicyVO policyVO);

    int insertPolicy(PolicyVO policyVO);

    List<Object> listPolicy(PolicyVO policyVO);

    int deletePolicy(PolicyVO policyVO);

    PolicyVO selectPolicy(PolicyVO policyVO);

    int update(PolicyVO policyVO);

    int getMaxPkPolicy();

}
