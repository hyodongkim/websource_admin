package com.teachingcash.saadmin.service;

import com.teachingcash.common.Config;
import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.PopupMapper;
import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.vo.PopupVO;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PopupServiceImpl implements PopupService{

    @Autowired
    Config config;

    @Autowired
    FileMapper fileMapper;

    @Autowired
    PopupMapper popupMapper;

    @Override
    public int selectCntPopup(PopupVO popupVO){
        return this.popupMapper.selectCntPopup(popupVO);
    }

    @Override
    public int insertPopup(HttpServletRequest request, PopupVO popupVO, MultipartFile file){
        int result = 0;
        int parentId = popupVO.getId();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", popupVO.getDeleteFileSeq());

        if (popupVO.getDeleteFileSeq() > 0) { fileMapper.deleteFile(map); }

        if(popupVO.getId() > 0) {
            result = popupMapper.update(popupVO);
        }else{
            result = popupMapper.insertPopup(popupVO);
        }

        if(parentId <= 0) { parentId = getMaxPkPopup(); }

        if (result > 0) {
            if (file.getSize() > 0) {
                String category = "popup";
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
    public List<Object> listPopup(PopupVO popupVO){
        return this.popupMapper.listPopup(popupVO);
    }

    @Override
    public int deletePopup(PopupVO popupVO){
        return this.popupMapper.deletePopup(popupVO);
    }

    @Override
    public PopupVO selectPopup(PopupVO popupVO){
        return this.popupMapper.selectPopup(popupVO);
    }

    @Override
    public int update(PopupVO popupVO){
        return this.popupMapper.update(popupVO);
    }

    @Override
    public int getMaxPkPopup() {
        return this.popupMapper.getMaxPkPopup();
    }

    /*
    @Override
    public List<Object> listCategory(){
        return this.popupMapper.listCategory();
    }

    @Override
    public List<Object> listCategoryEn(){
        return this.popupMapper.listCategoryEn();
    }

    @Override
    public List<Object> listPopupTopPost(PopupVO popupVO){
        return this.popupMapper.listPopupTopPost(popupVO);
    }

    @Override
    public PopupVO getTopPost(){
        return this.popupMapper.getTopPost();
    }

    @Override
    public PopupVO selectPopupPrev(HashMap<String, Object> map) {
        return this.popupMapper.selectPopupPrev(map);
    }

    @Override
    public PopupVO selectPopupNext(HashMap<String, Object> map) {
        return this.popupMapper.selectPopupNext(map);
    }

     */
}
