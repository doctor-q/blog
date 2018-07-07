package cc.doctor.lovely.blog.dao.mapper;

import cc.doctor.lovely.blog.dao.model.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    int insertUserRoles(@Param("userId") int userId, @Param("roleList") List<Integer> roleList);

    void deleteByUserId(Integer userId);

    List<UserRole> selectByUserIds(List<Integer> userIds);

    List<UserRole> selectByUserId(Integer userId);
}