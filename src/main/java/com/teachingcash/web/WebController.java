package com.teachingcash.web;

import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.BlogService;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.vo.BlogVO;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value="/web")
public class WebController {
    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @Autowired
    BlogService blogService;

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/landing.do", method = RequestMethod.GET)
    public String landing(ModelMap model, HttpServletRequest request) {
        return "/web/landing/index";
    }

    @RequestMapping(value = "/main.do", method = RequestMethod.GET)
    public String main(ModelMap model, HttpServletRequest request) {
        return "/web/index";
    }

    @RequestMapping(value = "/index_1.do", method = RequestMethod.GET)
    public String index_1(ModelMap model, HttpServletRequest request) {
        return "/web/index_1";
    }

    @RequestMapping(value = "/technology.do", method = RequestMethod.GET)
    public String technology(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_1_1";
    }

    @RequestMapping(value = "/data.do", method = RequestMethod.GET)
    public String data(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_1_2";
    }

    @RequestMapping(value = "/service.do", method = RequestMethod.GET)
    public String service(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_2_1";
    }

    @RequestMapping(value = "/priceQuote.do", method = RequestMethod.GET)
    public String priceQuote(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_1_4";
    }

    @RequestMapping(value = "/solutionControlMonitoring.do", method = RequestMethod.GET)
    public String solutionControlMonitoring(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_2_2";
    }

    @RequestMapping(value = "/solutionAssetManagement.do", method = RequestMethod.GET)
    public String solutionAssetManagement(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_2_3";
    }

    @RequestMapping(value = "/solutionIncidentManagement.do", method = RequestMethod.GET)
    public String solutionIncidentManagement(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_2_4";
    }

    @RequestMapping(value = "/solutionAutoEntryExitManagement.do", method = RequestMethod.GET)
    public String solutionAutoEntryExitManagement(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_2_5";
    }

    @RequestMapping(value = "/solutionHyperProximityMarketing.do", method = RequestMethod.GET)
    public String solutionHyperProximityMarketing(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_2_6";
    }

    @RequestMapping(value = "/solutionNavigation.do", method = RequestMethod.GET)
    public String solutionNavigation(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_2_7";
    }

    @RequestMapping(value = "/solutionDataStatistics.do", method = RequestMethod.GET)
    public String solutionDataStatistics(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_2_8";
    }

    @RequestMapping(value = "/solutionSmartParking.do", method = RequestMethod.GET)
    public String solutionSmartParking(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_2_8_e1";
    }

    @RequestMapping(value = "/solutionFactoryLogistic.do", method = RequestMethod.GET)
    public String solutionFactoryLogistic(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_2_9";
    }

    @RequestMapping(value = "/solutionRetailStore.do", method = RequestMethod.GET)
    public String solutionRetailStore(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_2_10";
    }

    @RequestMapping(value = "/solutionOfficeBuilding.do", method = RequestMethod.GET)
    public String solutionOfficeBuilding(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_3_5";
    }

    @RequestMapping(value = "/solutionMobilityParking.do", method = RequestMethod.GET)
    public String solutionMobilityParking(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_3_6";
    }

    @RequestMapping(value = "/solutionHospital.do", method = RequestMethod.GET)
    public String solutionHospital(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_2_11";
    }

    @RequestMapping(value = "/solutionHotel.do", method = RequestMethod.GET)
    public String solutionHotel(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_2_12";
    }

    @RequestMapping(value = "/contact.do", method = RequestMethod.GET)
    public String contact(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_1_7";
    }

    @RequestMapping(value = "/platform.do", method = RequestMethod.GET)
    public String platform(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_1_3";
    }

    @RequestMapping(value = "/about.do", method = RequestMethod.GET)
    public String about(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_5_1";
    }

    @RequestMapping(value = "/StudyCase.do", method = RequestMethod.GET)
    public String useCases(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_1_5";
    }

    @RequestMapping(value = "/useCasesDetail.do", method = RequestMethod.GET)
    public String useCasesDetail(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_1_6";
    }

    @RequestMapping(value = "/demoIntro.do", method = RequestMethod.GET)
    public String demoIntro(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_5_2";
    }


    /*
    이차 작업분
     */
    @RequestMapping(value = "/documentation.do", method = RequestMethod.GET)
    public String documentation(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_4_1";
    }

    @RequestMapping(value = "/blog.do", method = RequestMethod.GET)
    public String blog(ModelMap model, HttpServletRequest request, PageVO pageVO, BlogVO blogVO) {

        pageVO.setPageSize(6);

        int start = (pageVO.getPageIndex() -1) * 10;

        if(blogVO == null){
            blogVO = new BlogVO();
        }
        blogVO.setStart(start);
        blogVO.setLimit(10);
        int total = blogService.selectCntBlog(blogVO);
        List list = blogService.listBlog(blogVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("blogVO", blogVO);

        List listTopPost = blogService.listBlogTopPost(blogVO);
        model.addAttribute("listTopPost", listTopPost);

        BlogVO topPost = blogService.getTopPost();
        model.addAttribute("topPost", topPost);

        return "/web/sub/sub_6_3";
    }

    @RequestMapping(value = "/blogView.do", method = RequestMethod.GET)
    public String blogView(ModelMap model, HttpServletRequest request, BlogVO blogVO) {
        BlogVO blogVo = blogService.selectBlog(blogVO);
        model.addAttribute("item", blogVo);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("pk_blog", blogVO.getPk_blog());
        BlogVO prev = blogService.selectBlogPrev(map);
        model.addAttribute("prev", prev);

        BlogVO next = blogService.selectBlogNext(map);
        model.addAttribute("next", next);

        List listTopPost = blogService.listBlogTopPost(blogVO);
        model.addAttribute("listTopPost", listTopPost);

        return "/web/sub/sub_6_3_view";
    }

    @RequestMapping(value = "/hire.do", method = RequestMethod.GET)
    public String hire(ModelMap model, HttpServletRequest request) {
        return "/web/sub/sub_5_3";
    }

    @RequestMapping(value = "/privacy.do", method = RequestMethod.GET)
    public String privacy(ModelMap model, HttpServletRequest request) {
        return "/web/sub/privacy";
    }

    @RequestMapping(value = "/contract.do", method = RequestMethod.GET)
    public String contract(ModelMap model, HttpServletRequest request) {
        return "/web/sub/contract";
    }

	@RequestMapping(value = "/partner.do", method = RequestMethod.GET)
    public String partner(ModelMap model, HttpServletRequest request) {
        return "/web/sub/partner";
    }
}