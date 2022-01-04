package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.PopupVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("popupMapper")
public interface PopupMapper {
    int selectCntPopup(PopupVO popupVO);

    int insertPopup(PopupVO popupVO);

    List<Object> listPopup(PopupVO popupVO);

    int deletePopup(PopupVO popupVO);

    PopupVO selectPopup(PopupVO popupVO);

    int update(PopupVO popupVO);

    int getMaxPkPopup();

}
