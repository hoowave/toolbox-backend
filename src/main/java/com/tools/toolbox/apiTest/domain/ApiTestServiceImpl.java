package com.tools.toolbox.apiTest.domain;

import com.tools.toolbox.apiTest.domain.command.ApiTestGetCmd;
import com.tools.toolbox.apiTest.domain.command.ApiTestPostCmd;
import com.tools.toolbox.apiTest.domain.info.ApiTestGetInfo;
import com.tools.toolbox.apiTest.domain.info.ApiTestPostInfo;
import com.tools.toolbox.apiTest.infrastructure.MemoryRepository;
import com.tools.toolbox.apiTest.infrastructure.jpa.ApiTestJpaRepository;
import com.tools.toolbox.apiTest.infrastructure.mybatis.ApiTestMybatisRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiTestServiceImpl implements ApiTestService {

    private final ApiTestJpaRepository apiTestRepository;
//    private final ApiTestMybatisRepository apiTestRepository;
    private final MemoryRepository memoryRepository;

    @Override
    @Transactional
    public ApiTestGetInfo getAction(ApiTestGetCmd apiTestGetCmd) {
        var initCmd = apiTestGetCmd.toEntity();
        apiTestRepository.save(initCmd);
        var character = memoryRepository.getCharacterById(initCmd.getGetData());
        var apiTestGetInfo = new ApiTestGetInfo(character);
        return apiTestGetInfo;
    }

    @Override
    @Transactional
    public ApiTestPostInfo postAction(ApiTestPostCmd apiTestPostCmd) {
        var initCmd = apiTestPostCmd.toEntity();
        apiTestRepository.save(initCmd);
        var apiTestPostInfo = new ApiTestPostInfo(initCmd);
        return apiTestPostInfo;
    }
}
