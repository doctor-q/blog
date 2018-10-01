package cc.doctor.lovely.blog.dao.mapper;

import cc.doctor.lovely.blog.dao.model.BlogPost;
import cc.doctor.lovely.blog.dao.model.BlogPostWithBLOBs;
import cc.doctor.lovely.blog.dao.model.BlogPostWithSummary;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogPostWithBLOBs record);

    int insertSelective(BlogPostWithBLOBs record);

    BlogPost selectById(Integer id);

    BlogPostWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogPostWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BlogPostWithBLOBs record);

    int updateByPrimaryKey(BlogPost record);

    int selectBlogCount(Integer userId);

    List<BlogPostWithSummary> selectPage(RowBounds rowBounds);
}