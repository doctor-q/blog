package cc.doctor.lovely.blog.dao.mapper;

import cc.doctor.lovely.blog.controller.response.RoleListResponse;
import cc.doctor.lovely.blog.dao.OffsetLimit;
import cc.doctor.lovely.blog.dao.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    int selectAllRole();

    List<Role> selectPageable(OffsetLimit offsetLimit);

    Role selectByName(String name);
}