package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.Rental_productVO;
import com.teachingcash.saadmin.vo.SalesConditionVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("sales_conditionMapper")
public interface SalesConditionMapper {
    int selectCntSalesCondition(SalesConditionVO salesConditionVO);

    int insertSalesCondition(SalesConditionVO salesConditionVO);

    int deleteSalesCondition(int rental_product_id	);

    List<Object> listSalesCondition(SalesConditionVO salesConditionVO);

    int update(SalesConditionVO salesConditionVO);

    List<SalesConditionVO> selectSalesCondition(SalesConditionVO salesConditionVO);

    int getMaxPkSalesCondition();
}
