package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface Rental_productService {

    int selectCntRental_product(Rental_productVO rental_productVO);

    int insertRental_product(HttpServletRequest request, Rental_productVO rental_productVO, MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile file4, MultipartFile file5);

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
