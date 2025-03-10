package com.tools.toolbox.account.application.dto;

import com.tools.toolbox.account.core.command.LoginCmd;
import com.tools.toolbox.account.core.info.LoginInfo;
import com.tools.toolbox.common.response.CommonResponse;
import com.tools.toolbox.common.response.MessageCode;
import com.tools.toolbox.common.response.ResponseType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class LoginDto {

    @Getter
    @Setter
    public static class Request{
        @NotBlank(message = "아이디를 입력해주세요.")
        @Size(min = 4, max = 20, message = "아이디는 4~20자 이내로 입력해주세요.")
        private String userId;
        @NotBlank(message = "비밀번호를 입력해주세요.")
        @Size(min = 8, max = 20, message = "비밀번호는 8~20자 이내로 입력해주세요.")
        @Pattern(
                regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
                message = "비밀번호는 최소 8자 이상이며, 영문, 숫자, 특수문자를 포함해야 합니다."
        )
        private String password;

        public LoginCmd toCommand(){
            return LoginCmd.builder()
                    .userId(userId)
                    .password(password)
                    .build();
        }
    }

    @Getter
    public static class Response{
        private String userId;
        private String token;

        public Response(LoginInfo loginInfo){
            this.userId = loginInfo.getUserId();
            this.token = loginInfo.getToken();
        }

        public CommonResponse<Object> toResponse(){
            return CommonResponse.builder()
                    .responseType(ResponseType.SUCCESS)
                    .data(this)
                    .message(MessageCode.LOGIN_SUCCESS.getMessage())
                    .build();
        }

    }
}
