package com.tools.toolbox.cutUrl.application.service;

import com.tools.toolbox.cutUrl.application.port.in.CutUrlPort;
import com.tools.toolbox.cutUrl.application.port.out.CutUrlRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CutUrlService implements CutUrlPort {
    private final CutUrlRepositoryPort cutUrlRepositoryPort;

    @Override
    public void save() {
        System.out.println("CutUrlService start");
        cutUrlRepositoryPort.save();
    }
}
