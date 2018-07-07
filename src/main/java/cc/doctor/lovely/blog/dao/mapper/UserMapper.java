package cc.doctor.lovely.blog.dao.mapper;

import cc.doctor.lovely.blog.dao.OffsetLimit;
import cc.doctor.lovely.blog.dao.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByName(String username);

    User selectByEmail(String email);

    User selectByNameAndPassword(String username, String password);

    int selectCount();

    List<User> selectPageable(OffsetLimit offsetLimit);
}