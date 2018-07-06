package cc.doctor.lovely.blog.dao.mapper;

import cc.doctor.lovely.blog.dao.model.BlogPost;
import cc.doctor.lovely.blog.dao.model.BlogPostWithBLOBs;

public interface BlogPostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogPostWithBLOBs record);

    int insertSelective(BlogPostWithBLOBs record);

    BlogPostWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogPostWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BlogPostWithBLOBs record);

    int updateByPrimaryKey(BlogPost record);
}