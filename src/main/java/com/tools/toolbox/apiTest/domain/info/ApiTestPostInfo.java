package com.tools.toolbox.apiTest.domain.info;

import com.tools.toolbox.apiTest.domain.ApiTest;
import lombok.Getter;

import java.util.Map;

@Getter
public class ApiTestPostInfo {
    private Map<String, Object> responseData;

    public ApiTestPostInfo(ApiTest apiTest) {
        this.responseData = apiTest.getPostData();
    }
}
