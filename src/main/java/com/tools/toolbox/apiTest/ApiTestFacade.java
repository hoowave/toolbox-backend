package com.tools.toolbox.apiTest;

import com.tools.toolbox.apiTest.domain.ApiTestService;
import com.tools.toolbox.apiTest.domain.command.ApiTestGetCmd;
import com.tools.toolbox.apiTest.domain.command.ApiTestPostCmd;
import com.tools.toolbox.apiTest.domain.info.ApiTestGetInfo;
import com.tools.toolbox.apiTest.domain.info.ApiTestPostInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiTestFacade {
    private final ApiTestService apiTestService;

    public ApiTestGetInfo getAction(ApiTestGetCmd apiTestGetCmd) {
        var apiTestGetInfo = apiTestService.getAction(apiTestGetCmd);
        return apiTestGetInfo;
    }

    public ApiTestPostInfo postAction(ApiTestPostCmd apiTestPostCmd) {
        var apiTestPostInfo = apiTestService.postAction(apiTestPostCmd);
        return apiTestPostInfo;
    }

}
