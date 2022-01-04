package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.PopupVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PopupService {

    int selectCntPopup(PopupVO popupVO);

    int insertPopup(HttpServletRequest request, PopupVO popupVO, MultipartFile file);

    List<Object> listPopup(PopupVO popupVO);

    int deletePopup(PopupVO popupVO);

    PopupVO selectPopup(PopupVO popupVO);

    int update(PopupVO popupVO);

    int getMaxPkPopup();
}
