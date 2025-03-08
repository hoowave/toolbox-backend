package com.tools.toolbox.apiTest.interfaces.dto;

import com.tools.toolbox.apiTest.domain.command.ApiTestPostCmd;
import com.tools.toolbox.apiTest.domain.info.ApiTestPostInfo;
import com.tools.toolbox.common.response.CommonResponse;
import com.tools.toolbox.common.response.MessageCode;
import com.tools.toolbox.common.response.ResponseType;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class ApiTestPostDto {

    @Getter
    @Setter
    public static class Request {
        private Map<String, Object> responseData;

        public ApiTestPostCmd toCommand() {
            return ApiTestPostCmd.builder()
                    .postData(responseData)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private Map<String, Object> responseData;

        public Response(ApiTestPostInfo apiTestPostInfo) {
            this.responseData = apiTestPostInfo.getResponseData();
        }

        public CommonResponse<Object> toResponse() {
            return CommonResponse.builder()
                    .responseType(ResponseType.SUCCESS)
                    .data(this)
                    .message(MessageCode.API_POST_SUCCESS.getMessage())
                    .build();
        }
    }
}
