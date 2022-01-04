package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.Rental_categoryVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("rental_categoryMapper")
public interface Rental_categoryMapper {
    int selectCntRental_category(Rental_categoryVO rental_categoryVO);

    int insertRental_category(Rental_categoryVO rental_categoryVO);

    List<Object> listRental_category(Rental_categoryVO rental_categoryVO);

    int deleteRental_category(Rental_categoryVO rental_categoryVO);

    Rental_categoryVO selectRental_category(Rental_categoryVO rental_categoryVO);

    int update(Rental_categoryVO rental_categoryVO);

    int getMaxPkRental_category();

    List<Object> listEnabledRentalCategory();
}
