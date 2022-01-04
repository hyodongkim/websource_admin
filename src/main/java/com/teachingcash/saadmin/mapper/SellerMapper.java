package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.SellerVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("sellerMapper")
public interface SellerMapper {
    int selectCntSeller(SellerVO sellerVO);

    int insertSeller(SellerVO sellerVO);

    List<Object> listSeller(SellerVO sellerVO);

    int deleteSeller(SellerVO sellerVO);

    SellerVO selectSeller(SellerVO sellerVO);

    int update(SellerVO sellerVO);

    int getMaxPkSeller();
}
