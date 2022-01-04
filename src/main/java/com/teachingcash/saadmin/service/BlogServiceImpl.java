package com.teachingcash.saadmin.service;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.mapper.BlogMapper;
import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.vo.BlogVO;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService{


    @Autowired
    FileMapper fileMapper;

    @Autowired
    BlogMapper blogMapper;

    @Override
    public BlogVO selectBlog(HashMap<String, Object> map){
        return this.blogMapper.selectBlog(map);
    }

    @Override
    public int selectCntBlog(BlogVO blogVO){
        return this.blogMapper.selectCntBlog(blogVO);
    }

    @Override
    public int getMaxPkBlog() {
        return this.blogMapper.getMaxPkBlog();
    }

    @Override
    public int insertBlog(HttpServletRequest request, BlogVO blogVO, MultipartFile file){
        int result = 0;
        int parentSeq = blogVO.getPk_blog();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("seq", parentSeq);

        if (blogVO.getDeleteFileSeq() > 0) { fileMapper.deleteFile(map); }

        if(blogVO.getPk_blog() > 0) {
            result = blogMapper.update(blogVO);
        }else{
            result = blogMapper.insertBlog(blogVO);
        }

        if(parentSeq <= 0) { parentSeq = getMaxPkBlog(); }

        if (result > 0) {
            if (file.getSize() > 0) {
                String category = "blog";
                String originName = file.getOriginalFilename();
                String savedName = FileUtils.fileUpload(file, request, category);
                String uploadPath = "/upload/" + category + "/" + savedName;
                long fileSize = file.getSize();

                System.out.println("[log]originName:::" + originName);
                System.out.println("[log]uploadPath:::" + uploadPath);

                FileVO fvo = new FileVO(parentSeq, category, originName, savedName, fileSize, uploadPath);
                fileMapper.insertFile(fvo);
            }
        }

        return result;
    }

    @Override
    public List<Object> listBlog(BlogVO blogVO){
        return this.blogMapper.listBlog(blogVO);
    }

    @Override
    public int deleteBlog(BlogVO blogVO){
        return this.blogMapper.deleteBlog(blogVO);
    }

    @Override
    public BlogVO selectBlog(BlogVO blogVO){
        return this.blogMapper.selectBlog(blogVO);
    }

    @Override
    public int update(BlogVO blogVO){
        return this.blogMapper.update(blogVO);
    }

    @Override
    public List<Object> listCategory(){
        return this.blogMapper.listCategory();
    }

    @Override
    public List<Object> listCategoryEn(){
        return this.blogMapper.listCategoryEn();
    }

    @Override
    public List<Object> listBlogTopPost(BlogVO blogVO){
        return this.blogMapper.listBlogTopPost(blogVO);
    }

    @Override
    public BlogVO getTopPost(){
        return this.blogMapper.getTopPost();
    }

    @Override
    public BlogVO selectBlogPrev(HashMap<String, Object> map) {
        return this.blogMapper.selectBlogPrev(map);
    }

    @Override
    public BlogVO selectBlogNext(HashMap<String, Object> map) {
        return this.blogMapper.selectBlogNext(map);
    }
}
