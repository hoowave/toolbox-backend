package com.tools.toolbox.apiTest.infrastructure;

import com.tools.toolbox.apiTest.domain.ApiTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiTestRepository extends JpaRepository<ApiTest, Long> {

}
