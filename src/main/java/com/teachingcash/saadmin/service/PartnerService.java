package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.PartnerVO;

import java.util.HashMap;
import java.util.List;

public interface PartnerService {
    HashMap<String, Object> selectPartner(HashMap<String, Object> map);

    int selectCntPartner(PartnerVO partnerVO);

    int insertPartner(PartnerVO partnerVO);

    List<Object> listPartner(PartnerVO partnerVO);

    int updateProcessYN(PartnerVO partnerVO);

    int deletePartner(PartnerVO partnerVO);

    PartnerVO selectPartner(PartnerVO partnerVO);
}

