package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.BannerVO;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

public interface BannerService {

    int selectCntBanner(BannerVO bannerVO);

    int insertBanner(HttpServletRequest request, BannerVO bannerVO, MultipartFile file);

    List<Object> listBanner(BannerVO bannerVO);

    int deleteBanner(BannerVO bannerVO);

    BannerVO selectBanner(BannerVO bannerVO);

    int update(BannerVO bannerVO);

    int getMaxPkBanner();
}
