package com.teachingcash.saadmin.service;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    FileMapper fileMapper;

    @Override
    public int insertFile(FileVO fileVO) {
        return fileMapper.insertFile(fileVO);
    }

    @Override
    public FileVO selectFile(FileVO fileVO) {
        return fileMapper.selectFile(fileVO);
    }

    @Override
    public int deleteFile(HashMap<String, Object> hashMap) {
        return fileMapper.deleteFile(hashMap);
    }

    @Override
    public int deleteFileBySeq(int seq) {
        return fileMapper.deleteFileBySeq(seq);
    }
}
