package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.service.PolicyService;
import com.teachingcash.saadmin.vo.PolicyVO;
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
public class PolicyController {
    private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);

    @Autowired
    PolicyService policyService;

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/policyList.do", method = RequestMethod.GET)
    public String policyList(ModelMap model, HttpServletRequest request, PageVO pageVO, PolicyVO policyVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(policyVO == null){
            policyVO = new PolicyVO();
        }
        policyVO.setStart(start);
        policyVO.setLimit(10);

        int total = policyService.selectCntPolicy(policyVO);
        List<Object> list = policyService.listPolicy(policyVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("policyVO", policyVO);

        return "/admin/policy_list";
    }

    @ResponseBody
    @RequestMapping(value = "/deletePolicyAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deletePolicyAction(HttpServletRequest request, PolicyVO policyVO, HttpSession session){

        int result = policyService.deletePolicy(policyVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/policyBoth.do", method = RequestMethod.GET)
    public String policyBoth(ModelMap model, HttpServletRequest request, PolicyVO pPolicyVO, HttpSession session){
        PolicyVO policyVO = new PolicyVO();
        FileVO fileVO = new FileVO();

        if(pPolicyVO.getId() > 0){
            policyVO = policyService.selectPolicy(pPolicyVO);
            fileVO.setParentId(pPolicyVO.getId());
            fileVO = fileService.selectFile(fileVO);

            model.addAttribute("fvo", fileVO);
        }

        model.addAttribute("item", policyVO);

//        List<Object> listCategory = policyService.listCategory();
//        model.addAttribute("listCategory", listCategory);

        return "/admin/policy_both";
    }

    @RequestMapping(value = "/policyBoth.do", method = RequestMethod.POST)
    public String policyBoth (ModelMap model, HttpServletRequest request, PolicyVO pvo) throws Exception {

        int result = policyService.insertPolicy(request, pvo, null);

        if (result > 0) {
            model.addAttribute("redirectUrl", "policyList.do");

            if (pvo.getId() > 0) {
                model.addAttribute("alertMsg", "약관을 성공적으로 수정했습니다.");
            } else {
                model.addAttribute("alertMsg", "약관을 성공적으로 작성했습니다.");
            }
        } else {
            model.addAttribute("alertMsg", "약관 작성에 실패했습니다.");
        }

        return "common/alert";
    }
}
