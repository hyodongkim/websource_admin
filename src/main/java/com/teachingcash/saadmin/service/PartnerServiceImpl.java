package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.mapper.PartnerMapper;
import com.teachingcash.saadmin.vo.PartnerVO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PartnerServiceImpl implements PartnerService {

    private final PartnerMapper partnerMapper;

    public PartnerServiceImpl(PartnerMapper partnerMapper) {
        this.partnerMapper = partnerMapper;
    }


    @Override
    public HashMap<String, Object> selectPartner(HashMap<String, Object> map) {
        return partnerMapper.selectPartner(map);
    }

    @Override
    public int selectCntPartner(PartnerVO partnerVO) {
        return partnerMapper.selectCntPartner(partnerVO);
    }

    @Override
    public int insertPartner(PartnerVO partnerVO) {
        return partnerMapper.insertPartner(partnerVO);
    }

    @Override
    public List<Object> listPartner(PartnerVO partnerVO) {
        return partnerMapper.listPartner(partnerVO);
    }

    @Override
    public int updateProcessYN(PartnerVO partnerVO) {
        return partnerMapper.updateProcessYN(partnerVO);
    }

    @Override
    public int deletePartner(PartnerVO partnerVO) {
        return partnerMapper.deletePartner(partnerVO);
    }

    @Override
    public PartnerVO selectPartner(PartnerVO partnerVO) {
        return partnerMapper.selectPartner(partnerVO);
    }
}
