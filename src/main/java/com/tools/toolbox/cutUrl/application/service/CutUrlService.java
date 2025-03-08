package com.tools.toolbox.cutUrl.application.service;

import com.tools.toolbox.common.exception.BaseException;
import com.tools.toolbox.common.response.MessageCode;
import com.tools.toolbox.config.ToolBoxConfig;
import com.tools.toolbox.cutUrl.application.port.in.CutUrlPort;
import com.tools.toolbox.cutUrl.application.port.out.CutUrlRepositoryPort;
import com.tools.toolbox.cutUrl.core.CutUrl;
import com.tools.toolbox.cutUrl.core.command.CutUrlGetCmd;
import com.tools.toolbox.cutUrl.core.command.CutUrlPostCmd;
import com.tools.toolbox.cutUrl.core.info.CutUrlInfo;
import com.tools.toolbox.utils.UUIDGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CutUrlService implements CutUrlPort {
    private final ToolBoxConfig toolBoxConfig;
    private final CutUrlRepositoryPort cutUrlRepositoryPort;
    private final UUIDGenerator uuidGenerator;

    @Override
    @Transactional
    public CutUrlInfo process(CutUrlGetCmd cutUrlGetCmd){
        Optional<CutUrl> existCutUrl = cutUrlRepositoryPort.findByUuid(cutUrlGetCmd.getUuid());
        if(existCutUrl.isEmpty()) throw new BaseException(MessageCode.CUTURL_PROCESS_ERROR.getMessage());
        String transUrl = toolBoxConfig.getDomain() + existCutUrl.get().getUuid();
        var cutUrlInfo = new CutUrlInfo(existCutUrl.get(), transUrl);
        return cutUrlInfo;
    }

    @Override
    @Transactional
    public CutUrlInfo translate(CutUrlPostCmd cutUrlPostCmd) {
        Optional<CutUrl> existCutUrl = cutUrlRepositoryPort.findByOriginalUrl(cutUrlPostCmd.getOriginalUrl());
        if (existCutUrl.isPresent()){
            String transUrl = toolBoxConfig.getDomain() + existCutUrl.get().getUuid();
            var cutUrlInfo = new CutUrlInfo(existCutUrl.get(), transUrl);
            return cutUrlInfo;
        }
        var uuid = uuidGenerator.generateUUID();
        var initCmd = cutUrlPostCmd.toEntity(uuid);
        cutUrlRepositoryPort.save(initCmd);
        String transUrl = toolBoxConfig.getDomain() + uuid;
        var cutUrlInfo = new CutUrlInfo(initCmd, transUrl);
        return cutUrlInfo;
    }
}
