package com.teachingcash.saadmin.service;

import com.teachingcash.common.Config;
import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.SellerMapper;
import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.vo.SellerVO;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    Config config;

    @Autowired
    FileMapper fileMapper;

    @Autowired
    SellerMapper sellerMapper;

    @Override
    public int selectCntSeller(SellerVO sellerVO){
        return this.sellerMapper.selectCntSeller(sellerVO);
    }

    @Override
    public int insertSeller(HttpServletRequest request, SellerVO sellerVO, MultipartFile file){
        int result = 0;
        int parentId = sellerVO.getId();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", sellerVO.getDeleteFileSeq());

        if (sellerVO.getDeleteFileSeq() > 0) { fileMapper.deleteFile(map); }

        if(sellerVO.getId() > 0) {
            result = sellerMapper.update(sellerVO);
        }else{
            result = sellerMapper.insertSeller(sellerVO);
        }

        if(parentId <= 0) { parentId = getMaxPkSeller(); }

        if (result > 0) {
            if (file.getSize() > 0) {
                String category = "seller";
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
    public List<Object> listSeller(SellerVO sellerVO){
        return this.sellerMapper.listSeller(sellerVO);
    }

    @Override
    public int deleteSeller(SellerVO sellerVO){
        return this.sellerMapper.deleteSeller(sellerVO);
    }

    @Override
    public SellerVO selectSeller(SellerVO sellerVO){
        return this.sellerMapper.selectSeller(sellerVO);
    }

    @Override
    public int update(SellerVO sellerVO){
        return this.sellerMapper.update(sellerVO);
    }

    @Override
    public int getMaxPkSeller() {
        return this.sellerMapper.getMaxPkSeller();
    }

    /*
    @Override
    public List<Object> listCategory(){
        return this.sellerMapper.listCategory();
    }

    @Override
    public List<Object> listCategoryEn(){
        return this.sellerMapper.listCategoryEn();
    }

    @Override
    public List<Object> listSellerTopPost(SellerVO sellerVO){
        return this.sellerMapper.listSellerTopPost(sellerVO);
    }

    @Override
    public SellerVO getTopPost(){
        return this.sellerMapper.getTopPost();
    }

    @Override
    public SellerVO selectSellerPrev(HashMap<String, Object> map) {
        return this.sellerMapper.selectSellerPrev(map);
    }

    @Override
    public SellerVO selectSellerNext(HashMap<String, Object> map) {
        return this.sellerMapper.selectSellerNext(map);
    }

     */
}
