package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.Rental_productVO;
import com.teachingcash.saadmin.vo.LastMonthVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("lastMonthMapper")
public interface LastMonthMapper {
    int selectCntLastMonth(LastMonthVO LastMonthVO);

    int insertLastMonth(LastMonthVO LastMonthVO);

    int deleteLastMonth(int rental_product_id);

    List<Object> listLastMonth(LastMonthVO LastMonthVO);

    int update(LastMonthVO LastMonthVO);

    List<LastMonthVO> selectLastMonth(LastMonthVO LastMonthVO);

    int getMaxPkLastMonth();
}
