package cc.doctor.lovely.blog.dao.mapper;

import cc.doctor.lovely.blog.dao.model.RoleResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    RoleResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleResource record);

    int updateByPrimaryKey(RoleResource record);

    List<RoleResource> selectByRoleIds(List<Integer> roleIds);

    void insertRoleResources(Integer roleId, List<Integer> resourceIds);

    void deleteByRoleId(Integer roleId);
}