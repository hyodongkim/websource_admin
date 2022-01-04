package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.service.PushService;
import com.teachingcash.saadmin.vo.PushVO;
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
public class PushController {
    private static final Logger logger = LoggerFactory.getLogger(PushController.class);

    @Autowired
    PushService pushService;

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/pushList.do", method = RequestMethod.GET)
    public String pushList(ModelMap model, HttpServletRequest request, PageVO pageVO, PushVO pushVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(pushVO == null){
            pushVO = new PushVO();
        }
        pushVO.setStart(start);
        pushVO.setLimit(10);

        int total = pushService.selectCntPush(pushVO);
        List<Object> list = pushService.listPush(pushVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("pushVO", pushVO);

        return "/admin/push_list";
    }

    @ResponseBody
    @RequestMapping(value = "/deletePushAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deletePushAction(HttpServletRequest request, PushVO pushVO, HttpSession session){

        int result = pushService.deletePush(pushVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/pushBoth.do", method = RequestMethod.GET)
    public String pushBoth(ModelMap model, HttpServletRequest request, PushVO pPushVO, HttpSession session){
        PushVO pushVO = new PushVO();
        FileVO fileVO = new FileVO();

        if(pPushVO.getId() > 0){
            pushVO = pushService.selectPush(pPushVO);
            fileVO.setParentId(pPushVO.getId());
            fileVO = fileService.selectFile(fileVO);

            model.addAttribute("fvo", fileVO);
        }

        model.addAttribute("item", pushVO);

//        List<Object> listCategory = pushService.listCategory();
//        model.addAttribute("listCategory", listCategory);

        return "/admin/push_both";
    }

    @RequestMapping(value = "/pushBoth.do", method = RequestMethod.POST)
    public String pushBoth (ModelMap model, HttpServletRequest request, PushVO pvo, @RequestParam(value = "community", required = false) MultipartFile file) throws Exception {

        /*
        if(pvo.getCategory_new() != null && !pvo.getCategory_new().equals("")){
            pvo.setCategory(pvo.getCategory_new());
        }

        if(pvo.getCategory_en_new() != null && !pvo.getCategory_en_new().equals("")){
            pvo.setCategory_en(pvo.getCategory_en_new());
        }
        
         */

        int result = pushService.insertPush(request, pvo, file);

        if (result > 0) {
            model.addAttribute("redirectUrl", "pushList.do");

            if (result == 1) {
                model.addAttribute("alertMsg", "푸시를 성공적으로 작성했습니다.");
            } else if (result == 2) {
                model.addAttribute("alertMsg", "푸시를 성공적으로 수정했습니다.");
            }
        } else {
            model.addAttribute("alertMsg", "푸시 작성에 실패했습니다.");
        }

        return "common/alert";
    }

    @ResponseBody
    @RequestMapping(value = "/modifyPushAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String modifyPushAction(HttpServletRequest request, PushVO pushVO, HttpSession session){

        int result = pushService.update(pushVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }
}
