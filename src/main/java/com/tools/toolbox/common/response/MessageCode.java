package com.tools.toolbox.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageCode {
    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."),
    COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다."),
    COMMON_UNAUTHORIZED("토큰이 만료되었습니다."),
    COMMON_FORBIDDEN("권한이 없습니다."),

    CUTURL_SUCCESS("URL 변환이 완료되었습니다."),
    CUTURL_PROCESS_ERROR("존재하지 않는 URL입니다."),

    API_GET_SUCCESS("GET 요청이 완료되었습니다."),
    API_POST_SUCCESS("POST 요청이 완료되었습니다."),

    USER_NOT_FOUND("존재하지 않는 회원입니다."),
    REGISTER_SUCCESS("회원가입이 완료되었습니다."),
    REGISTER_EXIST_ID("이미 존재하는 아이디입니다."),
    LOGIN_FAIL("아이디 또는 비밀번호를 확인해주세요."),
    LOGIN_SUCCESS("로그인이 완료되었습니다."),

    CATEGORY_NOT_FOUND("존재하지 않는 카테고리입니다."),
    BOARD_WRITE_SUCCESS("게시글 작성이 완료되었습니다."),
    BOARD_LIST_SUCCESS("게시글 목록을 불러왔습니다."),
    BOARD_DETAILS_SUCCESS("게시글을 불러왔습니다."),
    BOARD_DETAILS_ERROR("존재하지 않는 게시글입니다."),
    BOARD_MODIFY_SUCCESS("게시글 수정이 완료되었습니다."),
    BOARD_DELETE_SUCCESS("게시글이 삭제되었습니다."),

    ;

    private final String message;

    public String getMessage(Object... arg) {
        return String.format(message, arg);
    }
}
