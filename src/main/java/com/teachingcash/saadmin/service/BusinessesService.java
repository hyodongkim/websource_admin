package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.BusinessesVO;
import java.util.List;

public interface BusinessesService {
    List<Object> listBusinesses(BusinessesVO businessesVO);
    int removeBusiness(BusinessesVO businessesVO);
}
