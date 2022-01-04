package com.teachingcash.saadmin.service;

import com.teachingcash.common.Config;
import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.mapper.PushMapper;
import com.teachingcash.saadmin.vo.PushVO;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PushServiceImpl implements PushService{

    @Autowired
    Config config;

    @Autowired
    FileMapper fileMapper;

    @Autowired
    PushMapper pushMapper;

    @Override
    public int selectCntPush(PushVO pushVO){
        return this.pushMapper.selectCntPush(pushVO);
    }

    @Override
    public int insertPush(HttpServletRequest request, PushVO pushVO, MultipartFile file){
        int result = 0;
        int parentId = pushVO.getId();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", pushVO.getDeleteFileSeq());

        if (pushVO.getDeleteFileSeq() > 0) { fileMapper.deleteFile(map); }

        if(pushVO.getId() > 0) {
            result = pushMapper.update(pushVO);
        }else{
            result = pushMapper.insertPush(pushVO);
        }

        if(parentId <= 0) { parentId = getMaxPkPush(); }

        if (result > 0) {
            if (file.getSize() > 0) {
                String category = "push";
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
    public List<Object> listPush(PushVO pushVO){
        return this.pushMapper.listPush(pushVO);
    }

    @Override
    public int deletePush(PushVO pushVO){
        return this.pushMapper.deletePush(pushVO);
    }

    @Override
    public PushVO selectPush(PushVO pushVO){
        return this.pushMapper.selectPush(pushVO);
    }

    @Override
    public int update(PushVO pushVO){
        return this.pushMapper.update(pushVO);
    }

    @Override
    public int getMaxPkPush() {
        return this.pushMapper.getMaxPkPush();
    }

    /*
    @Override
    public List<Object> listCategory(){
        return this.pushMapper.listCategory();
    }

    @Override
    public List<Object> listCategoryEn(){
        return this.pushMapper.listCategoryEn();
    }

    @Override
    public List<Object> listPushTopPost(PushVO pushVO){
        return this.pushMapper.listPushTopPost(pushVO);
    }

    @Override
    public PushVO getTopPost(){
        return this.pushMapper.getTopPost();
    }

    @Override
    public PushVO selectPushPrev(HashMap<String, Object> map) {
        return this.pushMapper.selectPushPrev(map);
    }

    @Override
    public PushVO selectPushNext(HashMap<String, Object> map) {
        return this.pushMapper.selectPushNext(map);
    }

     */
}
