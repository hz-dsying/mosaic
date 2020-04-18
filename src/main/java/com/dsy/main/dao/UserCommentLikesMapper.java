package com.dsy.main.dao;

import com.dsy.main.pojo.UserCommentLikesExample;
import com.dsy.main.pojo.UserCommentLikesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCommentLikesMapper {
    long countByExample(UserCommentLikesExample example);

    int deleteByExample(UserCommentLikesExample example);

    int deleteByPrimaryKey(UserCommentLikesKey key);

    int insert(UserCommentLikesKey record);

    int insertSelective(UserCommentLikesKey record);

    List<UserCommentLikesKey> selectByExample(UserCommentLikesExample example);

    int updateByExampleSelective(@Param("record") UserCommentLikesKey record, @Param("example") UserCommentLikesExample example);

    int updateByExample(@Param("record") UserCommentLikesKey record, @Param("example") UserCommentLikesExample example);
}