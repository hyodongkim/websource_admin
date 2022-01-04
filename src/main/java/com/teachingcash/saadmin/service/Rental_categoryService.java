package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.Rental_categoryVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface Rental_categoryService {

    int selectCntRental_category(Rental_categoryVO rental_categoryVO);

    int insertRental_category(HttpServletRequest request, Rental_categoryVO rental_categoryVO, MultipartFile file);

    List<Object> listRental_category(Rental_categoryVO rental_categoryVO);

    int deleteRental_category(Rental_categoryVO rental_categoryVO);

    Rental_categoryVO selectRental_category(Rental_categoryVO rental_categoryVO);

    int update(Rental_categoryVO rental_categoryVO);

    int getMaxPkRental_category();

    List<Object> listEnabledRentalCategory();
}
