package com.teachingcash.saadmin.service;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.mapper.PolicyMapper;
import com.teachingcash.saadmin.vo.PolicyVO;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PolicyServiceImpl implements PolicyService{


    @Autowired
    FileMapper fileMapper;

    @Autowired
    PolicyMapper policyMapper;

    @Override
    public int selectCntPolicy(PolicyVO policyVO){
        return this.policyMapper.selectCntPolicy(policyVO);
    }

    @Override
    public int insertPolicy(HttpServletRequest request, PolicyVO policyVO, MultipartFile file){
        int result = 0;

        if(policyVO.getId() > 0) {
            result = policyMapper.update(policyVO);
        }else{
            result = policyMapper.insertPolicy(policyVO);
        }
        return result;
    }

    @Override
    public List<Object> listPolicy(PolicyVO policyVO){
        return this.policyMapper.listPolicy(policyVO);
    }

    @Override
    public int deletePolicy(PolicyVO policyVO){
        return this.policyMapper.deletePolicy(policyVO);
    }

    @Override
    public PolicyVO selectPolicy(PolicyVO policyVO){
        return this.policyMapper.selectPolicy(policyVO);
    }

    @Override
    public int update(PolicyVO policyVO){
        return this.policyMapper.update(policyVO);
    }

    @Override
    public int getMaxPkPolicy() {
        return this.policyMapper.getMaxPkPolicy();
    }

    /*
    @Override
    public List<Object> listCategory(){
        return this.policyMapper.listCategory();
    }

    @Override
    public List<Object> listCategoryEn(){
        return this.policyMapper.listCategoryEn();
    }

    @Override
    public List<Object> listPolicyTopPost(PolicyVO policyVO){
        return this.policyMapper.listPolicyTopPost(policyVO);
    }

    @Override
    public PolicyVO getTopPost(){
        return this.policyMapper.getTopPost();
    }

    @Override
    public PolicyVO selectPolicyPrev(HashMap<String, Object> map) {
        return this.policyMapper.selectPolicyPrev(map);
    }

    @Override
    public PolicyVO selectPolicyNext(HashMap<String, Object> map) {
        return this.policyMapper.selectPolicyNext(map);
    }

     */
}
