package com.tools.toolbox.apiTest.domain.command;

import com.tools.toolbox.apiTest.domain.ApiTest;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiTestGetCmd {
    private int getData;

    public ApiTest toEntity(){
        return ApiTest.builder()
                .getData(getData)
                .build();
    }

}
