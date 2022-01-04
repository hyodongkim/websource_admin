package com.teachingcash.saadmin.service;

import com.teachingcash.common.Config;
import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.BannerMapper;
import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.vo.BannerVO;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BannerServiceImpl implements BannerService{

    @Autowired
    Config config;

    @Autowired
    FileMapper fileMapper;

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public int selectCntBanner(BannerVO bannerVO){
        return this.bannerMapper.selectCntBanner(bannerVO);
    }

    @Override
    public int insertBanner(HttpServletRequest request, BannerVO bannerVO, MultipartFile file){
        int result = 0;
        int parentId = bannerVO.getId();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", bannerVO.getDeleteFileSeq());

        if (bannerVO.getDeleteFileSeq() > 0) { fileMapper.deleteFile(map); }

        if(bannerVO.getId() > 0) {
            result = bannerMapper.update(bannerVO);
        }else{
            result = bannerMapper.insertBanner(bannerVO);
        }

        if(parentId <= 0) { parentId = getMaxPkBanner(); }

        if (result > 0) {
            if (file.getSize() > 0) {
                String category = "banner";
                String originalName = file.getOriginalFilename();
                String savedName = FileUtils.fileUpload(file, request, category);
                String uploadPath = config.getUploadPath() + category + "/" + savedName;
                long fileSize = file.getSize();

                System.out.println("[log]originalName:::" + originalName);
                System.out.println("[log]uploadPath:::" + uploadPath);

                FileVO fvo = new FileVO(parentId, category, originalName, savedName, fileSize, uploadPath);
                fileMapper.insertFile(fvo);
            }
        }

        return result;
    }

    @Override
    public List<Object> listBanner(BannerVO bannerVO){
        return this.bannerMapper.listBanner(bannerVO);
    }

    @Override
    public int deleteBanner(BannerVO bannerVO){
        return this.bannerMapper.deleteBanner(bannerVO);
    }

    @Override
    public BannerVO selectBanner(BannerVO bannerVO){
        return this.bannerMapper.selectBanner(bannerVO);
    }

    @Override
    public int update(BannerVO bannerVO){
        return this.bannerMapper.update(bannerVO);
    }

    @Override
    public int getMaxPkBanner() {
        return this.bannerMapper.getMaxPkBanner();
    }

    /*
    @Override
    public List<Object> listCategory(){
        return this.bannerMapper.listCategory();
    }

    @Override
    public List<Object> listCategoryEn(){
        return this.bannerMapper.listCategoryEn();
    }

    @Override
    public List<Object> listBannerTopPost(BannerVO bannerVO){
        return this.bannerMapper.listBannerTopPost(bannerVO);
    }

    @Override
    public BannerVO getTopPost(){
        return this.bannerMapper.getTopPost();
    }

    @Override
    public BannerVO selectBannerPrev(HashMap<String, Object> map) {
        return this.bannerMapper.selectBannerPrev(map);
    }

    @Override
    public BannerVO selectBannerNext(HashMap<String, Object> map) {
        return this.bannerMapper.selectBannerNext(map);
    }

     */
}
