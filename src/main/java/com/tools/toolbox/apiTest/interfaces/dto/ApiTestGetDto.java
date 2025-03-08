package com.tools.toolbox.apiTest.interfaces.dto;

import com.tools.toolbox.apiTest.domain.command.ApiTestGetCmd;
import com.tools.toolbox.apiTest.domain.info.ApiTestGetInfo;
import com.tools.toolbox.common.response.CommonResponse;
import com.tools.toolbox.common.response.MessageCode;
import com.tools.toolbox.common.response.ResponseType;
import lombok.Getter;
import lombok.Setter;

public class ApiTestGetDto {

    @Getter
    @Setter
    public static class Request{
        private int getData;

        public Request(int id){
            this.getData = id;
        }

        public ApiTestGetCmd toCommand(){
            return ApiTestGetCmd.builder()
                    .getData(getData)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private int id;
        private String name;
        private int age;
        private String gender;

        public Response(ApiTestGetInfo apiTestGetInfo) {
            this.id = apiTestGetInfo.getId();
            this.name = apiTestGetInfo.getName();
            this.age = apiTestGetInfo.getAge();
            this.gender = apiTestGetInfo.getGender();
        }


        public CommonResponse<Object> toResponse() {
            return CommonResponse.builder()
                    .responseType(ResponseType.SUCCESS)
                    .data(this)
                    .message(MessageCode.API_GET_SUCCESS.getMessage())
                    .build();
        }
    }
}
