package com.teachingcash.saadmin.service;

import com.teachingcash.common.Config;
import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.CustomercenterMapper;
import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.vo.CustomercenterVO;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomercenterServiceImpl implements CustomercenterService{

    @Autowired
    Config config;

    @Autowired
    FileMapper fileMapper;

    @Autowired
    CustomercenterMapper customercenterMapper;

    @Override
    public int selectCntCustomercenter(CustomercenterVO customercenterVO){
        return this.customercenterMapper.selectCntCustomercenter(customercenterVO);
    }

    @Override
    public int insertCustomercenter(HttpServletRequest request, CustomercenterVO customercenterVO, MultipartFile file){
        int result = 0;
        int parentId = customercenterVO.getId();

        Map<String, Object> map = new HashMap<String, Object>();
        /*map.put("id", customercenterVO.getDeleteFileSeq());*/

        /*if (customercenterVO.getDeleteFileSeq() > 0) { fileMapper.deleteFile(map); }*/

        if(customercenterVO.getId() > 0) {
            result = customercenterMapper.update(customercenterVO);
        }else{
            result = customercenterMapper.insertCustomercenter(customercenterVO);
        }

        if(parentId <= 0) { parentId = getMaxPkCustomercenter(); }

        if (result > 0) {
            if (file.getSize() > 0) {
                String category = "customercenter";
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
    public List<Object> listCustomercenter(CustomercenterVO customercenterVO){
        return this.customercenterMapper.listCustomercenter(customercenterVO);
    }

    @Override
    public int deleteCustomercenter(CustomercenterVO customercenterVO){
        return this.customercenterMapper.deleteCustomercenter(customercenterVO);
    }

    @Override
    public CustomercenterVO selectCustomercenter(CustomercenterVO customercenterVO){
        return this.customercenterMapper.selectCustomercenter(customercenterVO);
    }

    @Override
    public int update(CustomercenterVO customercenterVO){
        return this.customercenterMapper.update(customercenterVO);
    }

    @Override
    public int getMaxPkCustomercenter() {
        return this.customercenterMapper.getMaxPkCustomercenter();
    }

    /*
    @Override
    public List<Object> listCategory(){
        return this.customercenterMapper.listCategory();
    }

    @Override
    public List<Object> listCategoryEn(){
        return this.customercenterMapper.listCategoryEn();
    }

    @Override
    public List<Object> listCustomercenterTopPost(CustomercenterVO customercenterVO){
        return this.customercenterMapper.listCustomercenterTopPost(customercenterVO);
    }

    @Override
    public CustomercenterVO getTopPost(){
        return this.customercenterMapper.getTopPost();
    }

    @Override
    public CustomercenterVO selectCustomercenterPrev(HashMap<String, Object> map) {
        return this.customercenterMapper.selectCustomercenterPrev(map);
    }

    @Override
    public CustomercenterVO selectCustomercenterNext(HashMap<String, Object> map) {
        return this.customercenterMapper.selectCustomercenterNext(map);
    }

     */
}
