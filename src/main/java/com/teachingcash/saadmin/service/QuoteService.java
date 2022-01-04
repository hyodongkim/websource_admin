package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.QuoteVO;

import java.util.HashMap;
import java.util.List;

public interface QuoteService {
    HashMap<String, Object> selectQuote(HashMap<String, Object> map);

    QuoteVO selectQuote(QuoteVO quoteVO);

    int selectCntQuote(QuoteVO quoteVO);

    int insertQuote(QuoteVO quoteVO);

    int updateProcessYN(QuoteVO quoteVO);

    int deleteQuote(QuoteVO quoteVO);

    List listQuote(QuoteVO quoteVO);
}

