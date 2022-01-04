package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.PushVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PushService {

    int selectCntPush(PushVO pushVO);

    int insertPush(HttpServletRequest request, PushVO pushVO, MultipartFile file);

    List<Object> listPush(PushVO pushVO);

    int deletePush(PushVO pushVO);

    PushVO selectPush(PushVO pushVO);

    int update(PushVO pushVO);

    int getMaxPkPush();
}
