package com.tools.toolbox.cutUrl.infrastructure.adapter.out;

import com.tools.toolbox.cutUrl.application.port.out.CutUrlRepositoryPort;
import com.tools.toolbox.cutUrl.infrastructure.repository.CutUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CutUrlRepositoryAdapter implements CutUrlRepositoryPort {

    private final CutUrlRepository cutUrlRepository;

    @Override
    public void save() {
        System.out.println("Saving CutUrlRepository");
    }
}
