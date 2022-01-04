package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.FaqVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("faqMapper")
public interface FaqMapper {
    int selectCntFaq(FaqVO faqVO);

    int insertFaq(FaqVO faqVO);

    List<FaqVO> listFaq(FaqVO faqVO);

    int deleteFaq(FaqVO faqVO);

    FaqVO selectFaq(FaqVO faqVO);

    int update(FaqVO faqVO);

    int getMaxPkFaq();

    int getSameOrderBy(int order_by);

    int updateOrderByIncrease(int order_by);

    int updateOrderBy(FaqVO faqVO);
}
