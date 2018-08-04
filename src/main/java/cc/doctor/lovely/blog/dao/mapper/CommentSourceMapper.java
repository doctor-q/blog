package cc.doctor.lovely.blog.dao.mapper;

import cc.doctor.lovely.blog.dao.model.CommentSource;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentSourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentSource record);

    int insertSelective(CommentSource record);

    CommentSource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentSource record);

    int updateByPrimaryKey(CommentSource record);
}