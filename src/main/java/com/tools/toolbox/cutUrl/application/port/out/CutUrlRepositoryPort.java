package com.tools.toolbox.cutUrl.application.port.out;

import com.tools.toolbox.cutUrl.core.CutUrl;

import java.util.Optional;

public interface CutUrlRepositoryPort {

    Optional<CutUrl> findByUuid(String uuid);

    Optional<CutUrl> findByOriginalUrl(String originalUrl);

    void save(CutUrl cutUrl);
}
