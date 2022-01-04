package com.teachingcash.saadmin.service;

import com.teachingcash.common.vo.FileVO;

import java.util.HashMap;

public interface FileService {
    int insertFile(FileVO fileVO);
    FileVO selectFile(FileVO fileVO);
    int deleteFile(HashMap<String, Object> hashMap);
    int deleteFileBySeq(int seq);
}
