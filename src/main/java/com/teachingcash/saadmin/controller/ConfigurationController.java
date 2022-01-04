package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.service.ConfigurationService;
import com.teachingcash.saadmin.vo.ConfigurationVO;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class ConfigurationController {
    private static final Logger logger = LoggerFactory.getLogger(ConfigurationController.class);

    @Autowired
    ConfigurationService configurationService;

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/configurationView.do", method = RequestMethod.GET)
    public String configurationView(ModelMap model, HttpServletRequest request, PageVO pageVO, ConfigurationVO configurationVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(configurationVO == null){
            configurationVO = new ConfigurationVO();
        }
        /*configurationVO.setStart(start);
        configurationVO.setLimit(10);*/

        int total = configurationService.selectCntConfiguration(configurationVO);
        List<Object> list = configurationService.listConfiguration(configurationVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("configurationVO", configurationVO);

        return "configuration_both";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteConfigurationAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deleteConfigurationAction(HttpServletRequest request, ConfigurationVO configurationVO, HttpSession session){

        int result = configurationService.deleteConfiguration(configurationVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/configurationBoth.do", method = RequestMethod.GET)
    public String configurationBoth(ModelMap model, HttpServletRequest request, ConfigurationVO pConfigurationVO, HttpSession session){
        ConfigurationVO configurationVO = configurationService.selectConfiguration(pConfigurationVO);

        model.addAttribute("item", configurationVO);
        return "/admin/configuration_both";
    }

    @RequestMapping(value = "/configurationBoth.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String modifyConfigurationAction(ModelMap model, HttpServletRequest request, ConfigurationVO configurationVO, HttpSession session){

        int result = configurationService.update(configurationVO);
        if(result > 0) {
            model.addAttribute("alertMsg", "환경설정을 성공적으로 수정했습니다.");
        }else{
            model.addAttribute("alertMsg", "환경설정 수정에 실패했습니다.");
        }

        model.addAttribute("redirectUrl", "configurationBoth.do");

        return "common/alert";
    }
}
