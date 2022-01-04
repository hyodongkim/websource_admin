package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.BlogVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

public interface BlogService {

    BlogVO selectBlog(HashMap<String, Object> map);

    int selectCntBlog(BlogVO blogVO);

    int insertBlog(HttpServletRequest request, BlogVO blogVO, MultipartFile file);

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
