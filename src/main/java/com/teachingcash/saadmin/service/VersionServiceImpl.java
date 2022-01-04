package com.teachingcash.saadmin.service;

import com.teachingcash.common.Config;
import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.VersionMapper;
import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.vo.VersionVO;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VersionServiceImpl implements VersionService{

    @Autowired
    Config config;

    @Autowired
    FileMapper fileMapper;

    @Autowired
    VersionMapper versionMapper;

    @Override
    public int selectCntVersion(VersionVO versionVO){
        return this.versionMapper.selectCntVersion(versionVO);
    }

    @Override
    public int insertVersion(HttpServletRequest request, VersionVO versionVO, MultipartFile file){
        int result = 0;
        int parentId = versionVO.getId();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", versionVO.getDeleteFileSeq());

        if (versionVO.getDeleteFileSeq() > 0) { fileMapper.deleteFile(map); }

        if(versionVO.getId() > 0) {
            result = versionMapper.update(versionVO);
        }else{
            result = versionMapper.insertVersion(versionVO);
        }

        if(parentId <= 0) { parentId = getMaxPkVersion(); }

        if (result > 0) {
            if (file.getSize() > 0) {
                String category = "version";
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
    public List<Object> listVersion(VersionVO versionVO){
        return this.versionMapper.listVersion(versionVO);
    }

    @Override
    public int deleteVersion(VersionVO versionVO){
        return this.versionMapper.deleteVersion(versionVO);
    }

    @Override
    public VersionVO selectVersion(VersionVO versionVO){
        return this.versionMapper.selectVersion(versionVO);
    }

    @Override
    public int update(VersionVO versionVO){
        return this.versionMapper.update(versionVO);
    }

    @Override
    public int getMaxPkVersion() {
        return this.versionMapper.getMaxPkVersion();
    }

    /*
    @Override
    public List<Object> listCategory(){
        return this.versionMapper.listCategory();
    }

    @Override
    public List<Object> listCategoryEn(){
        return this.versionMapper.listCategoryEn();
    }

    @Override
    public List<Object> listVersionTopPost(VersionVO versionVO){
        return this.versionMapper.listVersionTopPost(versionVO);
    }

    @Override
    public VersionVO getTopPost(){
        return this.versionMapper.getTopPost();
    }

    @Override
    public VersionVO selectVersionPrev(HashMap<String, Object> map) {
        return this.versionMapper.selectVersionPrev(map);
    }

    @Override
    public VersionVO selectVersionNext(HashMap<String, Object> map) {
        return this.versionMapper.selectVersionNext(map);
    }

     */
}
