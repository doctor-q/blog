package cc.doctor.lovely.blog.dao.mapper;

import cc.doctor.lovely.blog.dao.model.BlogPostTag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogPostTag record);

    int insertSelective(BlogPostTag record);

    BlogPostTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogPostTag record);

    int updateByPrimaryKey(BlogPostTag record);

    int insertPostTags(@Param("blogId") Integer blogId, @Param("tagList") List<String> tagList);

    List<BlogPostTag> selectByBlogId(Integer id);
}