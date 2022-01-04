package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.BlogVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper("blogMapper")
public interface BlogMapper {
    BlogVO selectBlog(HashMap<String, Object> map);

    int selectCntBlog(BlogVO blogVO);

    int insertBlog(BlogVO blogVO);

    List<Object> listBlog(BlogVO blogVO);

    int deleteBlog(BlogVO blogVO);

    BlogVO selectBlog(BlogVO blogVO);

    int update(BlogVO blogVO);

    int getMaxPkBlog();

    List<Object> listCategory();
    List<Object> listCategoryEn();

    List<Object> listBlogTopPost(BlogVO blogVO);

    BlogVO getTopPost();

    BlogVO selectBlogPrev(HashMap<String, Object> map);
    BlogVO selectBlogNext(HashMap<String, Object> map);
}
