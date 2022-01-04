package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.mapper.LastMonthMapper;
import com.teachingcash.saadmin.mapper.SalesConditionMapper;
import com.teachingcash.saadmin.service.Rental_categoryService;
import com.teachingcash.saadmin.service.Rental_productService;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.vo.LastMonthVO;
import com.teachingcash.saadmin.vo.Rental_productVO;
import com.teachingcash.saadmin.vo.SalesConditionVO;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class Rental_productController {
    private static final Logger logger = LoggerFactory.getLogger(Rental_productController.class);

    @Autowired
    Rental_productService rental_productService;

    @Autowired
    SalesConditionMapper salesConditionMapper;

    @Autowired
    LastMonthMapper lastMonthMapper;

    @Autowired
    FileService fileService;

    @Autowired
    Rental_categoryService rental_categoryService;

    @RequestMapping(value = "/rental_productList.do", method = RequestMethod.GET)
    public String rental_productList(ModelMap model, HttpServletRequest request, PageVO pageVO, Rental_productVO rental_productVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(rental_productVO == null){
            rental_productVO = new Rental_productVO();
        }
        rental_productVO.setStart(start);
        rental_productVO.setLimit(10);
        int total = rental_productService.selectCntRental_product(rental_productVO);
        List list = rental_productService.listRental_product(rental_productVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("rental_productVO", rental_productVO);

        return "/admin/rental_product_list";
    }

    @RequestMapping(value = "/rental_productExcelList.do", method = RequestMethod.GET)
    public String rental_productExcelList(ModelMap model, HttpServletRequest request, PageVO pageVO, Rental_productVO rental_productVO) {

        int start = 0;//(pageVO.getPageIndex() -1) * 10;

        if(rental_productVO == null){
            rental_productVO = new Rental_productVO();
        }
        rental_productVO.setStart(start);
        rental_productVO.setLimit(99999999);
        int total = rental_productService.selectCntRental_product(rental_productVO);
        List list = rental_productService.listRental_product(rental_productVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("rental_productVO", rental_productVO);

        return "/admin/rental_product_excel_list";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteRental_productAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deleteRental_productAction(HttpServletRequest request, Rental_productVO rental_productVO, HttpSession session){

        int result = rental_productService.deleteRental_product(rental_productVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/rental_productBoth.do", method = RequestMethod.GET)
    public String rental_productBoth(ModelMap model, HttpServletRequest request, Rental_productVO pRental_productVO, HttpSession session){
        Rental_productVO rental_productVO = new Rental_productVO();


        if(pRental_productVO.getId() > 0){
            rental_productVO = rental_productService.selectRental_product(pRental_productVO);

            SalesConditionVO salesConditionVO = new SalesConditionVO();
            salesConditionVO.setRental_product_id(rental_productVO.getId());
            List<SalesConditionVO> salesConditionVOS  = salesConditionMapper.selectSalesCondition(salesConditionVO);

            model.addAttribute("salesConditionVOS", salesConditionVOS);

            rental_productVO.setSalesConditionVOS(salesConditionVOS);

            LastMonthVO lastMonthVO = new LastMonthVO();
            lastMonthVO.setRental_product_id(rental_productVO.getId());
            List<LastMonthVO> lastMonthVOS = lastMonthMapper.selectLastMonth(lastMonthVO);

            model.addAttribute("lastMonthVOS", lastMonthVOS);

            rental_productVO.setLastMonthVOS(lastMonthVOS);

        }
        model.addAttribute("item", rental_productVO);

        List<Object> listEnabledRentalCategory = rental_categoryService.listEnabledRentalCategory();
        model.addAttribute("listEnabledRentalCategory", listEnabledRentalCategory);

        return "/admin/rental_product_both";
    }

    @RequestMapping(value = "/rental_productBoth.do", method = RequestMethod.POST)
    public String rental_productBoth (ModelMap model, HttpServletRequest request, Rental_productVO rental_productVO, @RequestParam(value = "file1", required = false) MultipartFile file1, @RequestParam(value = "file2", required = false) MultipartFile file2, @RequestParam(value = "file3", required = false) MultipartFile file3, @RequestParam(value = "file4", required = false) MultipartFile file4, @RequestParam(value = "file5", required = false) MultipartFile file5) throws Exception {

        System.out.println("rental_productVO..........");
        System.out.println(rental_productVO.getSalesConditionVOS());
        System.out.println(rental_productVO.getLastMonthVOS());

        int result = rental_productService.insertRental_product(request, rental_productVO, file1, file2, file3, file4, file5);

        if (result > 0) {
            model.addAttribute("redirectUrl", "rental_productList.do");

            if (rental_productVO.getId() > 0) {
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
    @RequestMapping(value = "/modifyRental_productAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String modifyRental_productAction(HttpServletRequest request, Rental_productVO rental_productVO, HttpSession session){

        int result = rental_productService.update(rental_productVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }
}
