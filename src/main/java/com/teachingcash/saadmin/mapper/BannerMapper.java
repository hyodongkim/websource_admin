package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.BannerVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper("bannerMapper")
public interface BannerMapper {
    int selectCntBanner(BannerVO bannerVO);

    int insertBanner(BannerVO bannerVO);

    List<Object> listBanner(BannerVO bannerVO);

    int deleteBanner(BannerVO bannerVO);

    BannerVO selectBanner(BannerVO bannerVO);

    int update(BannerVO bannerVO);

    int getMaxPkBanner();

}
