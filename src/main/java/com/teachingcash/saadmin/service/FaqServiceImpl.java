package com.teachingcash.saadmin.service;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.mapper.FaqMapper;
import com.teachingcash.saadmin.vo.FaqVO;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FaqServiceImpl implements FaqService{


    @Autowired
    FileMapper fileMapper;

    @Autowired
    FaqMapper faqMapper;

    @Override
    public int selectCntFaq(FaqVO faqVO){
        return this.faqMapper.selectCntFaq(faqVO);
    }

    @Override
    public int insertFaq(HttpServletRequest request, FaqVO faqVO, MultipartFile file){
        int result = 0;

        int sameOrderBy = faqMapper.getSameOrderBy(Integer.parseInt(faqVO.getOrder_by()));

        if(sameOrderBy > 0){
            faqMapper.updateOrderByIncrease(Integer.parseInt(faqVO.getOrder_by()));
        }

        if(faqVO.getId() > 0) {
            result = faqMapper.update(faqVO);
        }else{
            result = faqMapper.insertFaq(faqVO);
        }

        //순서 재정렬
        faqVO.setLimit(999999);
        List<FaqVO> list = faqMapper.listFaq(faqVO);
        for (int i=0; i<list.size(); i++){

            FaqVO item = (FaqVO)list.get(i);

            FaqVO faqVO1 = new FaqVO();
            faqVO1.setId(item.getId());
            faqVO1.setOrder_by(new Integer(i+1).toString());

            faqMapper.updateOrderBy(faqVO1);
        }


        return result;
    }

    @Override
    public List<FaqVO> listFaq(FaqVO faqVO){
        return this.faqMapper.listFaq(faqVO);
    }

    @Override
    public int deleteFaq(FaqVO faqVO){
        return this.faqMapper.deleteFaq(faqVO);
    }

    @Override
    public FaqVO selectFaq(FaqVO faqVO){
        return this.faqMapper.selectFaq(faqVO);
    }

    @Override
    public int update(FaqVO faqVO){
        return this.faqMapper.update(faqVO);
    }

    @Override
    public int getMaxPkFaq() {
        return this.faqMapper.getMaxPkFaq();
    }

    @Override
    public int getSameOrderBy(int order_by){ return this.faqMapper.getSameOrderBy(order_by);}

    @Override
    public int updateOrderByIncrease(int order_by){ return this.faqMapper.updateOrderByIncrease(order_by);}

    @Override
    public int updateOrderBy(FaqVO faqVO){ return this.faqMapper.updateOrderBy(faqVO);}
}
