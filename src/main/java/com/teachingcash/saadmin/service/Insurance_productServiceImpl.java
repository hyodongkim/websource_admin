package com.teachingcash.saadmin.service;

import com.teachingcash.common.Config;
import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.mapper.Insurance_productMapper;
import com.teachingcash.saadmin.vo.Insurance_productVO;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Insurance_productServiceImpl implements Insurance_productService{

    @Autowired
    Config config;

    @Autowired
    FileMapper fileMapper;

    @Autowired
    Insurance_productMapper insurance_productMapper;

    @Override
    public int selectCntInsurance_product(Insurance_productVO insurance_productVO){
        return this.insurance_productMapper.selectCntInsurance_product(insurance_productVO);
    }

    @Override
    public int insertInsurance_product(HttpServletRequest request, Insurance_productVO insurance_productVO, MultipartFile file1, MultipartFile file2){
        int result = 0;
        int parentId = insurance_productVO.getId();

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("id", insurance_productVO.getDeleteFileSeq1());
        if (insurance_productVO.getDeleteFileSeq1() > 0) { fileMapper.deleteFile(map1); }

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id", insurance_productVO.getDeleteFileSeq2());
        if (insurance_productVO.getDeleteFileSeq2() > 0) { fileMapper.deleteFile(map2); }

        if (insurance_productVO.getId() > 0) {
            result = insurance_productMapper.update(insurance_productVO);
        }else{
            result = insurance_productMapper.insertInsurance_product(insurance_productVO);
        }

        if (parentId <= 0) { parentId = getMaxPkInsurance_product(); }

        if (result > 0) {
            if (file1.getSize() > 0) {
                String product = "insurance_product";
                String originalName = file1.getOriginalFilename();
                String savedName = FileUtils.fileUpload(file1, request, product);
                String uploadPath = config.getUploadPath() + product + "/" + savedName;
                long fileSize = file1.getSize();

                System.out.println("[log]originalName:::" + originalName);
                System.out.println("[log]uploadPath:::" + uploadPath);

                FileVO fvo = new FileVO(parentId, product, originalName, savedName, fileSize, uploadPath);
                fileMapper.insertFile(fvo);
            }

            if (file2.getSize() > 0) {
                String product = "insurance_desc";
                String originalName = file2.getOriginalFilename();
                String savedName = FileUtils.fileUpload(file2, request, product);
                String uploadPath = config.getUploadPath() + product + "/" + savedName;
                long fileSize = file2.getSize();

                System.out.println("[log]originalName:::" + originalName);
                System.out.println("[log]uploadPath:::" + uploadPath);

                FileVO fvo = new FileVO(parentId, product, originalName, savedName, fileSize, uploadPath);
                fileMapper.insertFile(fvo);
            }
        }

        return result;
    }

    @Override
    public List<Object> listInsurance_product(Insurance_productVO insurance_productVO){
        return this.insurance_productMapper.listInsurance_product(insurance_productVO);
    }

    @Override
    public int deleteInsurance_product(Insurance_productVO insurance_productVO){
        return this.insurance_productMapper.deleteInsurance_product(insurance_productVO);
    }

    @Override
    public Insurance_productVO selectInsurance_product(Insurance_productVO insurance_productVO){
        return this.insurance_productMapper.selectInsurance_product(insurance_productVO);
    }

    @Override
    public int update(Insurance_productVO insurance_productVO){
        return this.insurance_productMapper.update(insurance_productVO);
    }

    @Override
    public int getMaxPkInsurance_product() {
        return this.insurance_productMapper.getMaxPkInsurance_product();
    }

    /*
    @Override
    public List<Object> listProduct(){
        return this.insurance_productMapper.listProduct();
    }

    @Override
    public List<Object> listProductEn(){
        return this.insurance_productMapper.listProductEn();
    }

    @Override
    public List<Object> listInsurance_productTopPost(Insurance_productVO insurance_productVO){
        return this.insurance_productMapper.listInsurance_productTopPost(insurance_productVO);
    }

    @Override
    public Insurance_productVO getTopPost(){
        return this.insurance_productMapper.getTopPost();
    }

    @Override
    public Insurance_productVO selectInsurance_productPrev(HashMap<String, Object> map) {
        return this.insurance_productMapper.selectInsurance_productPrev(map);
    }

    @Override
    public Insurance_productVO selectInsurance_productNext(HashMap<String, Object> map) {
        return this.insurance_productMapper.selectInsurance_productNext(map);
    }

     */
}
