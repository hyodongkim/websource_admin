package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.BannerService;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.vo.BannerVO;
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
public class BannerController {
    private static final Logger logger = LoggerFactory.getLogger(BannerController.class);

    @Autowired
    BannerService bannerService;

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/bannerList.do", method = RequestMethod.GET)
    public String bannerList(ModelMap model, HttpServletRequest request, PageVO pageVO, BannerVO bannerVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(bannerVO == null){
            bannerVO = new BannerVO();
        }
        bannerVO.setStart(start);
        bannerVO.setLimit(10);
        int total = bannerService.selectCntBanner(bannerVO);
        List list = bannerService.listBanner(bannerVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("bannerVO", bannerVO);

        return "/admin/banner_list";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteBannerAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deleteBannerAction(HttpServletRequest request, BannerVO bannerVO, HttpSession session){

        int result = bannerService.deleteBanner(bannerVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/bannerBoth.do", method = RequestMethod.GET)
    public String bannerBoth(ModelMap model, HttpServletRequest request, BannerVO pBannerVO, HttpSession session){
        BannerVO bannerVO = new BannerVO();
        FileVO fileVO = new FileVO();

        if(pBannerVO.getId() > 0){
            bannerVO = bannerService.selectBanner(pBannerVO);
            fileVO.setParentId(pBannerVO.getId());
            fileVO = fileService.selectFile(fileVO);

            model.addAttribute("fvo", fileVO);
        }

        model.addAttribute("item", bannerVO);

//        List<Object> listCategory = bannerService.listCategory();
//        model.addAttribute("listCategory", listCategory);

        return "/admin/banner_both";
    }

    @RequestMapping(value = "/bannerBoth.do", method = RequestMethod.POST)
    public String bannerBoth (ModelMap model, HttpServletRequest request, BannerVO bvo, @RequestParam(value = "community", required = false) MultipartFile file) throws Exception {

        /*
        if(bvo.getCategory_new() != null && !bvo.getCategory_new().equals("")){
            bvo.setCategory(bvo.getCategory_new());
        }

        if(bvo.getCategory_en_new() != null && !bvo.getCategory_en_new().equals("")){
            bvo.setCategory_en(bvo.getCategory_en_new());
        }
        
         */

        int result = bannerService.insertBanner(request, bvo, file);

        if (result > 0) {
            model.addAttribute("redirectUrl", "bannerList.do");

            if (bvo.getId() > 0) {
                model.addAttribute("alertMsg", "배너를 성공적으로 수정했습니다.");
            } else {
                model.addAttribute("alertMsg", "배너를 성공적으로 등록했습니다.");
            }
        } else {
            model.addAttribute("alertMsg", "작성에 실패했습니다.");
        }

        return "common/alert";
    }

    @ResponseBody
    @RequestMapping(value = "/modifyBannerAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String modifyBannerAction(HttpServletRequest request, BannerVO bannerVO, HttpSession session){

        int result = bannerService.update(bannerVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }
}
