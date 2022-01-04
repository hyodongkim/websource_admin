package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.VersionVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

public interface VersionService {

    int selectCntVersion(VersionVO versionVO);

    int insertVersion(HttpServletRequest request, VersionVO versionVO, MultipartFile file);

    List<Object> listVersion(VersionVO versionVO);

    int deleteVersion(VersionVO versionVO);

    VersionVO selectVersion(VersionVO versionVO);

    int update(VersionVO versionVO);

    int getMaxPkVersion();
}
