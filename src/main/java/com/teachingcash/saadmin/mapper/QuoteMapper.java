package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.QuoteVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper("quoteMapper")
public interface QuoteMapper {
    HashMap<String, Object> selectQuote(HashMap<String, Object> map);

    QuoteVO selectQuote(QuoteVO quoteVO);

    int selectCntQuote(QuoteVO quoteVO);

    int insertQuote(QuoteVO quoteVO);

    int updateProcessYN(QuoteVO quoteVO);

    int deleteQuote(QuoteVO quoteVO);

    List listQuote(QuoteVO quoteVO);
}
