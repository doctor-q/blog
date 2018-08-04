package cc.doctor.lovely.blog.dao.mapper;

import cc.doctor.lovely.blog.dao.model.BlogPostTag;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogPostTag record);

    int insertSelective(BlogPostTag record);

    BlogPostTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogPostTag record);

    int updateByPrimaryKey(BlogPostTag record);
}