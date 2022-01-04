package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.VersionVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper("versionMapper")
public interface VersionMapper {
    int selectCntVersion(VersionVO versionVO);

    int insertVersion(VersionVO versionVO);

    List<Object> listVersion(VersionVO versionVO);

    int deleteVersion(VersionVO versionVO);

    VersionVO selectVersion(VersionVO versionVO);

    int update(VersionVO versionVO);

    int getMaxPkVersion();

}
