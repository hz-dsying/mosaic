package com.dsy.main.dao;

import com.dsy.main.pojo.SongAlbumExample;
import com.dsy.main.pojo.SongAlbumKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SongAlbumMapper {
    long countByExample(SongAlbumExample example);

    int deleteByExample(SongAlbumExample example);

    int deleteByPrimaryKey(SongAlbumKey key);

    int insert(SongAlbumKey record);

    int insertSelective(SongAlbumKey record);

    List<SongAlbumKey> selectByExample(SongAlbumExample example);

    int updateByExampleSelective(@Param("record") SongAlbumKey record, @Param("example") SongAlbumExample example);

    int updateByExample(@Param("record") SongAlbumKey record, @Param("example") SongAlbumExample example);
}