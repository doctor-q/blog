package cc.doctor.lovely.blog.dao.mapper;

import cc.doctor.lovely.blog.dao.model.Blogger;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloggerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Blogger record);

    int insertSelective(Blogger record);

    Blogger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Blogger record);

    int updateByPrimaryKey(Blogger record);

    List<Blogger> selectPage(RowBounds rowBounds);

    Blogger selectByPassword(@Param("username") String username, @Param("password") String password);
}