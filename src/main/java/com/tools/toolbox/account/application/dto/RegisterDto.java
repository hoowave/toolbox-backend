package com.tools.toolbox.account.application.dto;

import com.tools.toolbox.account.core.command.RegisterCmd;
import com.tools.toolbox.account.core.info.RegisterInfo;
import com.tools.toolbox.common.response.CommonResponse;
import com.tools.toolbox.common.response.MessageCode;
import com.tools.toolbox.common.response.ResponseType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class RegisterDto {

    @Getter
    @Setter
    public static class Request{
        @NotBlank(message = "이름을 입력해주세요.")
        @Size(min = 2, max = 20, message = "이름은 2~20자 이내로 입력해주세요.")
        private String name;

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

        @NotBlank(message = "이메일을 입력해주세요.")
        @Email(message = "올바른 이메일 형식을 입력해주세요.")
        private String email;

        @NotBlank(message = "전화번호를 입력해주세요.")
        @Pattern(
                regexp = "^01[0-9]-\\d{3,4}-\\d{4}$",
                message = "전화번호는 010-XXXX-XXXX 형식이어야 합니다."
        )
        private String phone;

        public RegisterCmd toCommand(){
            return RegisterCmd.builder()
                    .name(name)
                    .userId(userId)
                    .password(password)
                    .email(email)
                    .phone(phone)
                    .build();
        }
    }

    @Getter
    public static class Response{
        private String name;
        private String userId;
        private String email;
        private String phone;

        public Response(RegisterInfo registerInfo) {
            this.name = registerInfo.getName();
            this.userId = registerInfo.getUserId();
            this.email = registerInfo.getEmail();
            this.phone = registerInfo.getPhone();
        }

        public CommonResponse<Object> toResponse(){
            return CommonResponse.builder()
                    .responseType(ResponseType.SUCCESS)
                    .data(this)
                    .message(MessageCode.REGISTER_SUCCESS.getMessage())
                    .build();
        }

    }
}
