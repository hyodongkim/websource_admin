package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.mapper.QuoteMapper;
import com.teachingcash.saadmin.vo.QuoteVO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    private final QuoteMapper quoteMapper;

    public QuoteServiceImpl(QuoteMapper quoteMapper) {
        this.quoteMapper = quoteMapper;
    }


    @Override
    public HashMap<String, Object> selectQuote(HashMap<String, Object> map) {
        return quoteMapper.selectQuote(map);
    }

    @Override
    public QuoteVO selectQuote(QuoteVO quoteVO) { return quoteMapper.selectQuote(quoteVO); }

    @Override
    public int selectCntQuote(QuoteVO quoteVO) {
        return quoteMapper.selectCntQuote(quoteVO);
    }

    @Override
    public int insertQuote(QuoteVO quoteVO) {
        return quoteMapper.insertQuote(quoteVO);
    }

    @Override
    public int updateProcessYN(QuoteVO quoteVO) {
        return quoteMapper.updateProcessYN(quoteVO);
    }

    @Override
    public int deleteQuote(QuoteVO quoteVO) {
        return quoteMapper.deleteQuote(quoteVO);
    }

    @Override
    public List listQuote(QuoteVO quoteVO) {
        return quoteMapper.listQuote(quoteVO);
    }
}
