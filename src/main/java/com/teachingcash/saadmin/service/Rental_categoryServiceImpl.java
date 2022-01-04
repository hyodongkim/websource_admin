package com.teachingcash.saadmin.service;

import com.teachingcash.common.Config;
import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.Rental_categoryMapper;
import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.vo.Rental_categoryVO;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Rental_categoryServiceImpl implements Rental_categoryService{

    @Autowired
    Config config;

    @Autowired
    FileMapper fileMapper;

    @Autowired
    Rental_categoryMapper rental_categoryMapper;

    @Override
    public int selectCntRental_category(Rental_categoryVO rental_categoryVO){
        return this.rental_categoryMapper.selectCntRental_category(rental_categoryVO);
    }

    @Override
    public int insertRental_category(HttpServletRequest request, Rental_categoryVO rental_categoryVO, MultipartFile file){
        int result = 0;
        int parentId = rental_categoryVO.getId();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", rental_categoryVO.getDeleteFileSeq());

        if (rental_categoryVO.getDeleteFileSeq() > 0) { fileMapper.deleteFile(map); }

        if (rental_categoryVO.getId() > 0) {
            result = rental_categoryMapper.update(rental_categoryVO);
        }else{
            result = rental_categoryMapper.insertRental_category(rental_categoryVO);
        }

        if (parentId <= 0) { parentId = getMaxPkRental_category(); }

        if (result > 0) {
            if (file.getSize() > 0) {
                String category = "rental_category";
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
    public List<Object> listRental_category(Rental_categoryVO rental_categoryVO){
        return this.rental_categoryMapper.listRental_category(rental_categoryVO);
    }

    @Override
    public int deleteRental_category(Rental_categoryVO rental_categoryVO){
        return this.rental_categoryMapper.deleteRental_category(rental_categoryVO);
    }

    @Override
    public Rental_categoryVO selectRental_category(Rental_categoryVO rental_categoryVO){
        return this.rental_categoryMapper.selectRental_category(rental_categoryVO);
    }

    @Override
    public int update(Rental_categoryVO rental_categoryVO){
        return this.rental_categoryMapper.update(rental_categoryVO);
    }

    @Override
    public int getMaxPkRental_category() {
        return this.rental_categoryMapper.getMaxPkRental_category();
    }

    @Override
    public List<Object> listEnabledRentalCategory(){
        return this.rental_categoryMapper.listEnabledRentalCategory();
    }
}
