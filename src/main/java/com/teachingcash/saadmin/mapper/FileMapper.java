package com.teachingcash.saadmin.mapper;

import com.teachingcash.common.vo.FileVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.Map;

@Mapper("fileMapper")
public interface FileMapper {
    int insertFile(FileVO fileVO);
    FileVO selectFile(FileVO fileVO);
    int deleteFile(Map<String, Object> map);
    int deleteFileBySeq(int seq);
}
