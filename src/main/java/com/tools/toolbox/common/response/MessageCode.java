package com.tools.toolbox.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageCode {
    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."),
    COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다."),

    CUTURL_SUCCESS("URL 변환이 완료되었습니다."),
    CUTURL_PROCESS_ERROR("존재하지 않는 URL입니다."),

    API_GET_SUCCESS("GET 요청이 완료되었습니다."),
    API_POST_SUCCESS("POST 요청이 완료되었습니다.");

    private final String message;

    public String getMessage(Object... arg) {
        return String.format(message, arg);
    }
}
