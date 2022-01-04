package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.VersionService;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.vo.VersionVO;
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
public class VersionController {
    private static final Logger logger = LoggerFactory.getLogger(VersionController.class);

    @Autowired
    VersionService versionService;

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/versionList.do", method = RequestMethod.GET)
    public String versionList(ModelMap model, HttpServletRequest request, PageVO pageVO, VersionVO versionVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(versionVO == null){
            versionVO = new VersionVO();
        }
        versionVO.setStart(start);
        versionVO.setLimit(10);
        int total = versionService.selectCntVersion(versionVO);
        List list = versionService.listVersion(versionVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("versionVO", versionVO);

        return "/admin/version_list";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteVersionAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deleteVersionAction(HttpServletRequest request, VersionVO versionVO, HttpSession session){

        int result = versionService.deleteVersion(versionVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/versionBoth.do", method = RequestMethod.GET)
    public String versionBoth(ModelMap model, HttpServletRequest request, VersionVO pVersionVO, HttpSession session){
        VersionVO versionVO = new VersionVO();
        FileVO fileVO = new FileVO();

        if(pVersionVO.getId() > 0){
            versionVO = versionService.selectVersion(pVersionVO);
            fileVO.setParentId(pVersionVO.getId());
            fileVO = fileService.selectFile(fileVO);

            model.addAttribute("fvo", fileVO);
        }

        model.addAttribute("item", versionVO);

//        List<Object> listCategory = versionService.listCategory();
//        model.addAttribute("listCategory", listCategory);

        return "/admin/version_both";
    }

    @RequestMapping(value = "/versionBoth.do", method = RequestMethod.POST)
    public String versionBoth (ModelMap model, HttpServletRequest request, VersionVO bvo, @RequestParam(value = "community", required = false) MultipartFile file) throws Exception {

        int result = versionService.insertVersion(request, bvo, file);

        if (result > 0) {
            model.addAttribute("redirectUrl", "versionList.do");

            if (bvo.getId() > 0) {
                model.addAttribute("alertMsg", "수정되었습니다.");
            } else {
                model.addAttribute("alertMsg", "작성되었습니다.");
            }
        } else {
            model.addAttribute("alertMsg", "작성에 실패했습니다.");
        }

        return "common/alert";
    }

    @ResponseBody
    @RequestMapping(value = "/modifyVersionAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String modifyVersionAction(HttpServletRequest request, VersionVO versionVO, HttpSession session){

        int result = versionService.update(versionVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }
}
