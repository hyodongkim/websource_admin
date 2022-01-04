package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.mapper.BlogMapper;
import com.teachingcash.saadmin.mapper.BusinessesMapper;
import com.teachingcash.saadmin.vo.BusinessesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessesServiceImpl implements BusinessesService {

    @Autowired
    BusinessesMapper businessesMapper;

    public List<Object> listBusinesses(BusinessesVO businessesVO){
        return this.businessesMapper.listBusinesses(businessesVO);
    }

    public int removeBusiness(BusinessesVO businessesVO){
        return this.businessesMapper.removeBusiness(businessesVO);
    }
}
