package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.PushVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("pushMapper")
public interface PushMapper {
    int selectCntPush(PushVO pushVO);

    int insertPush(PushVO pushVO);

    List<Object> listPush(PushVO pushVO);

    int deletePush(PushVO pushVO);

    PushVO selectPush(PushVO pushVO);

    int update(PushVO pushVO);

    int getMaxPkPush();

}
