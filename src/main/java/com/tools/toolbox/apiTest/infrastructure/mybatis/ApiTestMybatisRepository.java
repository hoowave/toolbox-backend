package com.tools.toolbox.apiTest.infrastructure.mybatis;

import com.tools.toolbox.apiTest.domain.ApiTest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ApiTestMybatisRepository {

    @Insert("INSERT INTO api_test (created_at) VALUES (#{apiTest.createdAt})")
    void save(@Param("apiTest") ApiTest apiTest);
}