package com.tools.toolbox.apiTest.domain;

import com.tools.toolbox.apiTest.domain.command.ApiTestGetCmd;
import com.tools.toolbox.apiTest.domain.command.ApiTestPostCmd;
import com.tools.toolbox.apiTest.domain.info.ApiTestGetInfo;
import com.tools.toolbox.apiTest.domain.info.ApiTestPostInfo;

public interface ApiTestService {

    ApiTestGetInfo getAction(ApiTestGetCmd apiTestGetCmd);

    ApiTestPostInfo postAction(ApiTestPostCmd apiTestPostCmd);
}
