package com.tools.toolbox.cutUrl.infrastructure.repository;

import com.tools.toolbox.cutUrl.core.CutUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CutUrlRepository extends JpaRepository<CutUrl, Long> {

}
