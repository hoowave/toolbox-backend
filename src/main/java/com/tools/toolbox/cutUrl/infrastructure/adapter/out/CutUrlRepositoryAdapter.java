package com.tools.toolbox.cutUrl.infrastructure.adapter.out;

import com.tools.toolbox.cutUrl.application.port.out.CutUrlRepositoryPort;
import com.tools.toolbox.cutUrl.core.CutUrl;
import com.tools.toolbox.cutUrl.infrastructure.repository.jpa.CutUrlJpaRepository;
import com.tools.toolbox.cutUrl.infrastructure.repository.mybatis.CutUrlMybatisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CutUrlRepositoryAdapter implements CutUrlRepositoryPort {

//    private final CutUrlMybatisRepository cutUrlRepository;
    private final CutUrlJpaRepository cutUrlRepository;

    @Override
    public Optional<CutUrl> findByUuid(String uuid) {
        Optional<CutUrl> existCutUrl = cutUrlRepository.findByUuid(uuid);
        return existCutUrl;
    }

    @Override
    public Optional<CutUrl> findByOriginalUrl(String originalUrl) {
        Optional<CutUrl> existCutUrl = cutUrlRepository.findByOriginalUrl(originalUrl);
        return existCutUrl;
    }

    @Override
    public void save(CutUrl cutUrl) {
        cutUrlRepository.save(cutUrl);
    }
}
