package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.FaqVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface FaqService {

    int selectCntFaq(FaqVO faqVO);

    int insertFaq(HttpServletRequest request, FaqVO faqVO, MultipartFile file);

    List<FaqVO> listFaq(FaqVO faqVO);

    int deleteFaq(FaqVO faqVO);

    FaqVO selectFaq(FaqVO faqVO);

    int update(FaqVO faqVO);

    int getMaxPkFaq();

    int getSameOrderBy(int order_by);

    int updateOrderByIncrease(int order_by);

    int updateOrderBy(FaqVO faqVO);
}
