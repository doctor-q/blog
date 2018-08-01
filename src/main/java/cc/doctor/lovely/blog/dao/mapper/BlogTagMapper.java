package cc.doctor.lovely.blog.dao.mapper;

import cc.doctor.lovely.blog.dao.model.BlogTag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogTag record);

    int insertSelective(BlogTag record);

    BlogTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogTag record);

    int updateByPrimaryKey(BlogTag record);

    void deleteByBlogId(Integer blogId);

    void insertTags(@Param("blogId") Integer blogId, @Param("tags") List<String> tags);
}