package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.RentalAgreementVO;
import com.teachingcash.saadmin.vo.RentalLastmonth;
import com.teachingcash.saadmin.vo.Rental_productVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("rental_productMapper")
public interface Rental_productMapper {
    int selectCntRental_product(Rental_productVO rental_productVO);

    int insertRental_product(Rental_productVO rental_productVO);

    List<Object> listRental_product(Rental_productVO rental_productVO);

    int deleteRental_product(Rental_productVO rental_productVO);

    Rental_productVO selectRental_product(Rental_productVO rental_productVO);

    int update(Rental_productVO rental_productVO);

    int getMaxPkRental_product();

    List<RentalAgreementVO> selectRentalAgreement(RentalAgreementVO rentalAgreementVO);

    int insertRentalAgreement(RentalAgreementVO rentalAgreementVO);

    List<RentalLastmonth> selectRentalLastmonth(RentalLastmonth rentalLastmonth);

    int insertRentalLastmonth(RentalLastmonth rentalLastmonth);

    int deleteRentalAgreement(RentalAgreementVO rentalAgreementVO);

    int deleteRentalLastmonth(RentalLastmonth rentalLastmonth);

}
