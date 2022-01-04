package com.teachingcash.saadmin.service;

import com.teachingcash.common.Config;
import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.mapper.Insurance_categoryMapper;
import com.teachingcash.saadmin.vo.Insurance_categoryVO;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Insurance_categoryServiceImpl implements Insurance_categoryService{

    @Autowired
    Config config;

    @Autowired
    FileMapper fileMapper;

    @Autowired
    Insurance_categoryMapper insurance_categoryMapper;

    @Override
    public int selectCntInsurance_category(Insurance_categoryVO insurance_categoryVO){
        return this.insurance_categoryMapper.selectCntInsurance_category(insurance_categoryVO);
    }

    @Override
    public int insertInsurance_category(HttpServletRequest request, Insurance_categoryVO insurance_categoryVO, MultipartFile file){
        int result = 0;
        int parentId = insurance_categoryVO.getId();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", insurance_categoryVO.getDeleteFileSeq());

        if (insurance_categoryVO.getDeleteFileSeq() > 0) { fileMapper.deleteFile(map); }

        if (insurance_categoryVO.getId() > 0) {
            result = insurance_categoryMapper.update(insurance_categoryVO);
        }else{
            result = insurance_categoryMapper.insertInsurance_category(insurance_categoryVO);
        }

        if (parentId <= 0) { parentId = getMaxPkInsurance_category(); }

        if (result > 0) {
            if (file.getSize() > 0) {
                String category = "insurance_category";
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
    public List<Object> listInsurance_category(Insurance_categoryVO insurance_categoryVO){
        return this.insurance_categoryMapper.listInsurance_category(insurance_categoryVO);
    }

    @Override
    public int deleteInsurance_category(Insurance_categoryVO insurance_categoryVO){
        return this.insurance_categoryMapper.deleteInsurance_category(insurance_categoryVO);
    }

    @Override
    public Insurance_categoryVO selectInsurance_category(Insurance_categoryVO insurance_categoryVO){
        return this.insurance_categoryMapper.selectInsurance_category(insurance_categoryVO);
    }

    @Override
    public int update(Insurance_categoryVO insurance_categoryVO){
        return this.insurance_categoryMapper.update(insurance_categoryVO);
    }

    @Override
    public int getMaxPkInsurance_category() {
        return this.insurance_categoryMapper.getMaxPkInsurance_category();
    }

    @Override
    public List<Object> listEnabledInsuranceCategory(){
        return this.insurance_categoryMapper.listEnabledInsuranceCategory();
    }
}
