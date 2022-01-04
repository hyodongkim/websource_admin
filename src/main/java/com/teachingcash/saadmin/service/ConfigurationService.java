package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.ConfigurationVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ConfigurationService {

    int selectCntConfiguration(ConfigurationVO configurationVO);

    int insertConfiguration(HttpServletRequest request, ConfigurationVO configurationVO, MultipartFile file);

    List<Object> listConfiguration(ConfigurationVO configurationVO);

    int deleteConfiguration(ConfigurationVO configurationVO);

    ConfigurationVO selectConfiguration(ConfigurationVO configurationVO);

    int update(ConfigurationVO configurationVO);

    int getMaxPkConfiguration();
}
