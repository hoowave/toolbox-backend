package com.tools.toolbox.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."),
    COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다."),

    PHONE_NUMBER_DUPLICATED("이미 등록된 전화번호입니다."),
    MEMBER_NOT_FOUND("등록되지 않은 전화번호입니다."),
    MEMBER_NEED_LOGIN("로그인이 필요합니다."),
    TOKEN_EXPIRE("토큰이 만료되었습니다. 재로그인이 필요합니다."),
    MEMBER_LOGOUT("로그아웃 되었습니다.");

    private final String errorMsg;

    public String getErrorMsg(Object... arg) {
        return String.format(errorMsg, arg);
    }
}
