package com.tools.toolbox.apiTest.interfaces.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class ApiTestPostDto {

    @Getter
    @Setter
    public static class ApiTestRequest{
        private Map<String, Object> requestData;
        private Map<String, Object> responseData;
    }

    @Getter
    public static class ApiTestResponse{
        private Map<String, Object> responseData;
    }

}
