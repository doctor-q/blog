package cc.doctor.lovely.blog.dao.mapper;

import cc.doctor.lovely.blog.dao.model.Attention;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttentionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attention record);

    int insertSelective(Attention record);

    Attention selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);

    int selectFollowerCount(Integer bloggerId);

    int selectAttentionCount(Integer followerId);

    List<Attention> selectFollowers(Integer bloggerId);

    List<Attention> selectAttentions(Integer followerId);
}