package com.teachingcash.saadmin.service;

import com.teachingcash.common.Config;
import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.mapper.ConfigurationMapper;
import com.teachingcash.saadmin.vo.ConfigurationVO;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConfigurationServiceImpl implements ConfigurationService{


    @Autowired
    Config config;

    @Autowired
    FileMapper fileMapper;

    @Autowired
    ConfigurationMapper configurationMapper;

    @Override
    public int selectCntConfiguration(ConfigurationVO configurationVO){
        return this.configurationMapper.selectCntConfiguration(configurationVO);
    }

    @Override
    public int insertConfiguration(HttpServletRequest request, ConfigurationVO configurationVO, MultipartFile file){
        int result = 0;
        int parentId = configurationVO.getId();

        Map<String, Object> map = new HashMap<String, Object>();
        /*map.put("id", configurationVO.getDeleteFileSeq());*/

        /*if (configurationVO.getDeleteFileSeq() > 0) { fileMapper.deleteFile(map); }*/

        if(configurationVO.getId() > 0) {
            result = configurationMapper.update(configurationVO);
        }else{
            result = configurationMapper.insertConfiguration(configurationVO);
        }

        if(parentId <= 0) { parentId = getMaxPkConfiguration(); }

        if (result > 0) {
            if (file.getSize() > 0) {
                String category = "configuration";
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
    public List<Object> listConfiguration(ConfigurationVO configurationVO){
        return this.configurationMapper.listConfiguration(configurationVO);
    }

    @Override
    public int deleteConfiguration(ConfigurationVO configurationVO){
        return this.configurationMapper.deleteConfiguration(configurationVO);
    }

    @Override
    public ConfigurationVO selectConfiguration(ConfigurationVO configurationVO){
        return this.configurationMapper.selectConfiguration(configurationVO);
    }

    @Override
    public int update(ConfigurationVO configurationVO){
        return this.configurationMapper.update(configurationVO);
    }

    @Override
    public int getMaxPkConfiguration() {
        return this.configurationMapper.getMaxPkConfiguration();
    }

    /*
    @Override
    public List<Object> listCategory(){
        return this.configurationMapper.listCategory();
    }

    @Override
    public List<Object> listCategoryEn(){
        return this.configurationMapper.listCategoryEn();
    }

    @Override
    public List<Object> listConfigurationTopPost(ConfigurationVO configurationVO){
        return this.configurationMapper.listConfigurationTopPost(configurationVO);
    }

    @Override
    public ConfigurationVO getTopPost(){
        return this.configurationMapper.getTopPost();
    }

    @Override
    public ConfigurationVO selectConfigurationPrev(HashMap<String, Object> map) {
        return this.configurationMapper.selectConfigurationPrev(map);
    }

    @Override
    public ConfigurationVO selectConfigurationNext(HashMap<String, Object> map) {
        return this.configurationMapper.selectConfigurationNext(map);
    }

     */
}
