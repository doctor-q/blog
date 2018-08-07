package cc.doctor.lovely.blog.dao.mapper;

import cc.doctor.lovely.blog.dao.model.Blogger;
import org.springframework.stereotype.Repository;

@Repository
public interface BloggerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Blogger record);

    int insertSelective(Blogger record);

    Blogger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Blogger record);

    int updateByPrimaryKey(Blogger record);

    Blogger selectByUserId(Integer userId);
}