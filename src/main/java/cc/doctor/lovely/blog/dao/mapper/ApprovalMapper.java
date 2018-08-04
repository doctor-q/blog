package cc.doctor.lovely.blog.dao.mapper;

import cc.doctor.lovely.blog.dao.model.Approval;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Approval record);

    int insertSelective(Approval record);

    Approval selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Approval record);

    int updateByPrimaryKey(Approval record);
}