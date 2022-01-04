package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.PartnerVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper("partnerMapper")
public interface PartnerMapper {
    HashMap<String, Object> selectPartner(HashMap<String, Object> map);

    int selectCntPartner(PartnerVO partnerVO);

    int insertPartner(PartnerVO partnerVO);

    List<Object> listPartner(PartnerVO partnerVO);

    int updateProcessYN(PartnerVO partnerVO);

    int deletePartner(PartnerVO partnerVO);

    PartnerVO selectPartner(PartnerVO partnerVO);
}
