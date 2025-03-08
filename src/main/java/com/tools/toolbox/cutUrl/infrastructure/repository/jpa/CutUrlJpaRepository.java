package com.tools.toolbox.cutUrl.infrastructure.repository.jpa;

import com.tools.toolbox.cutUrl.core.CutUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CutUrlJpaRepository extends JpaRepository<CutUrl, Long> {

    Optional<CutUrl> findByUuid(String uuid);

    Optional<CutUrl> findByOriginalUrl(String originalUrl);
}
