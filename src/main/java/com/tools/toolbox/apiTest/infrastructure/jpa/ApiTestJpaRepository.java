package com.tools.toolbox.apiTest.infrastructure.jpa;

import com.tools.toolbox.apiTest.domain.ApiTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiTestJpaRepository extends JpaRepository<ApiTest, Long> {

}
