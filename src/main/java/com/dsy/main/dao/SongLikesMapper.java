package com.dsy.main.dao;

import com.dsy.main.pojo.SongLikesExample;
import com.dsy.main.pojo.SongLikesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SongLikesMapper {
    long countByExample(SongLikesExample example);

    int deleteByExample(SongLikesExample example);

    int deleteByPrimaryKey(SongLikesKey key);

    int insert(SongLikesKey record);

    int insertSelective(SongLikesKey record);

    List<SongLikesKey> selectByExample(SongLikesExample example);

    int updateByExampleSelective(@Param("record") SongLikesKey record, @Param("example") SongLikesExample example);

    int updateByExample(@Param("record") SongLikesKey record, @Param("example") SongLikesExample example);
}