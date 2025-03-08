package com.tools.toolbox.apiTest.domain.command;

import com.tools.toolbox.apiTest.domain.ApiTest;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class ApiTestPostCmd {
    private Map<String, Object> postData;

    public ApiTest toEntity() {
        return ApiTest.builder()
                .postData(postData)
                .build();
    }
}
