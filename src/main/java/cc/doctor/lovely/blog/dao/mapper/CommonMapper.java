package cc.doctor.lovely.blog.dao.mapper;

import org.apache.ibatis.annotations.Param;

public interface CommonMapper {
    boolean selectUnique(@Param("table") String table, @Param("id") Integer id);
}
