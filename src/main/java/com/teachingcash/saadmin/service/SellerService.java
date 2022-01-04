package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.SellerVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SellerService {

    int selectCntSeller(SellerVO sellerVO);

    int insertSeller(HttpServletRequest request, SellerVO sellerVO, MultipartFile file);

    List<Object> listSeller(SellerVO sellerVO);

    int deleteSeller(SellerVO sellerVO);

    SellerVO selectSeller(SellerVO sellerVO);

    int update(SellerVO sellerVO);

    int getMaxPkSeller();
}
