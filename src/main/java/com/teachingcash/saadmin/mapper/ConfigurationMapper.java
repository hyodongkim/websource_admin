package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.ConfigurationVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("configurationMapper")
public interface ConfigurationMapper {
    int selectCntConfiguration(ConfigurationVO configurationVO);

    int insertConfiguration(ConfigurationVO configurationVO);

    List<Object> listConfiguration(ConfigurationVO configurationVO);

    int deleteConfiguration(ConfigurationVO configurationVO);

    ConfigurationVO selectConfiguration(ConfigurationVO configurationVO);

    int update(ConfigurationVO configurationVO);

    int getMaxPkConfiguration();
}
