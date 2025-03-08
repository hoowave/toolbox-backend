package com.tools.toolbox.cutUrl.infrastructure.repository.mybatis;

import com.tools.toolbox.cutUrl.core.CutUrl;
import org.apache.ibatis.annotations.*;

import java.util.Optional;

@Mapper
public interface CutUrlMybatisRepository {

    @Select("SELECT * FROM cut_url WHERE uuid = #{uuid}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uuid", column = "uuid"),
            @Result(property = "originalUrl", column = "original_url"),
            @Result(property = "createdAt", column = "created_at")
    })
    Optional<CutUrl> findByUuid(@Param("uuid") String uuid);

    @Select("SELECT * FROM cut_url WHERE original_url = #{originalUrl}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uuid", column = "uuid"),
            @Result(property = "originalUrl", column = "original_url"),
            @Result(property = "createdAt", column = "created_at")
    })
    Optional<CutUrl> findByOriginalUrl(@Param("originalUrl") String originalUrl);

    @Insert("INSERT INTO cut_url (id, original_url, uuid, created_at) VALUES (#{cutUrl.id}, #{cutUrl.originalUrl}, #{cutUrl.uuid}, #{cutUrl.createdAt})")
    void save(@Param("cutUrl") CutUrl cutUrl);
}