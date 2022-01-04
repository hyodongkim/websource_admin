package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.service.Insurance_productService;
import com.teachingcash.saadmin.service.Insurance_categoryService;
import com.teachingcash.saadmin.vo.Insurance_productVO;
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
public class Insurance_productController {
    private static final Logger logger = LoggerFactory.getLogger(Insurance_productController.class);

    @Autowired
    Insurance_productService insurance_productService;

    @Autowired
    FileService fileService;

    @Autowired
    Insurance_categoryService insurance_categoryService;

    @RequestMapping(value = "/insurance_productList.do", method = RequestMethod.GET)
    public String insurance_productList(ModelMap model, HttpServletRequest request, PageVO pageVO, Insurance_productVO insurance_productVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(insurance_productVO == null){
            insurance_productVO = new Insurance_productVO();
        }
        insurance_productVO.setStart(start);
        insurance_productVO.setLimit(10);
        int total = insurance_productService.selectCntInsurance_product(insurance_productVO);
        List list = insurance_productService.listInsurance_product(insurance_productVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("insurance_productVO", insurance_productVO);

        return "/admin/insurance_product_list";
    }

    @RequestMapping(value = "/insurance_productExcelList.do", method = RequestMethod.GET)
    public String insurance_productExcelList(ModelMap model, HttpServletRequest request, PageVO pageVO, Insurance_productVO insurance_productVO) {

        int start = 0;//(pageVO.getPageIndex() -1) * 10;

        if(insurance_productVO == null){
            insurance_productVO = new Insurance_productVO();
        }
        insurance_productVO.setStart(start);
        insurance_productVO.setLimit(99999999);
        int total = insurance_productService.selectCntInsurance_product(insurance_productVO);
        List list = insurance_productService.listInsurance_product(insurance_productVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("insurance_productVO", insurance_productVO);

        return "/admin/insurance_product_excel_list";
    }


    @ResponseBody
    @RequestMapping(value = "/deleteInsurance_productAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deleteInsurance_productAction(HttpServletRequest request, Insurance_productVO insurance_productVO, HttpSession session){

        int result = insurance_productService.deleteInsurance_product(insurance_productVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/insurance_productBoth.do", method = RequestMethod.GET)
    public String insurance_productBoth(ModelMap model, HttpServletRequest request, Insurance_productVO pInsurance_productVO, HttpSession session){
        Insurance_productVO insurance_productVO = new Insurance_productVO();
        FileVO fileVO = new FileVO();

        if(pInsurance_productVO.getId() > 0){
            insurance_productVO = insurance_productService.selectInsurance_product(pInsurance_productVO);
            fileVO.setParentId(pInsurance_productVO.getId());
            fileVO = fileService.selectFile(fileVO);

            model.addAttribute("fvo", fileVO);
        }

        model.addAttribute("item", insurance_productVO);

        List<Object> listEnabledInsuranceCategory = insurance_categoryService.listEnabledInsuranceCategory();
        model.addAttribute("listEnabledInsuranceCategory", listEnabledInsuranceCategory);

        return "/admin/insurance_product_both";
    }

    @RequestMapping(value = "/insurance_productBoth.do", method = RequestMethod.POST)
    public String insurance_productBoth (ModelMap model, HttpServletRequest request, Insurance_productVO bvo, @RequestParam(value = "file1", required = false) MultipartFile file1, @RequestParam(value = "file2", required = false) MultipartFile file2) throws Exception {

        int result = insurance_productService.insertInsurance_product(request, bvo, file1, file2);

        if (result > 0) {
            model.addAttribute("redirectUrl", "insurance_productList.do");

            if (bvo.getId() > 0) {
                model.addAttribute("alertMsg", "상품을 성공적으로 수정했습니다.");
            } else {
                model.addAttribute("alertMsg", "상품을 성공적으로 등록했습니다.");
            }
        } else {
            model.addAttribute("alertMsg", "상품을 등록하는 데 실패했습니다.");
        }

        return "common/alert";
    }

    @ResponseBody
    @RequestMapping(value = "/modifyInsurance_productAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String modifyInsurance_productAction(HttpServletRequest request, Insurance_productVO insurance_productVO, HttpSession session){

        int result = insurance_productService.update(insurance_productVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }
}
