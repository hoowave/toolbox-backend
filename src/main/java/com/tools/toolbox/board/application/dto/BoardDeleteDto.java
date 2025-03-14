package com.tools.toolbox.board.application.dto;

import com.tools.toolbox.board.core.command.BoardDeleteCmd;
import com.tools.toolbox.board.core.info.BoardIdInfo;
import com.tools.toolbox.common.response.CommonResponse;
import com.tools.toolbox.common.response.MessageCode;
import com.tools.toolbox.common.response.ResponseType;
import lombok.Getter;
import lombok.Setter;

public class BoardDeleteDto {

    @Getter
    @Setter
    public static class Request {
        private Long id;

        public BoardDeleteCmd toCommand(String userId) {
            return BoardDeleteCmd.builder()
                    .id(id)
                    .userId(userId)
                    .build();
        }

    }

    @Getter
    public static class Response {
        private Long id;

        public Response(BoardIdInfo boardIdInfo) {
            this.id = boardIdInfo.getId();
        }

        public CommonResponse<Object> toResponse() {
            return CommonResponse.builder()
                    .responseType(ResponseType.SUCCESS)
                    .data(this)
                    .message(MessageCode.BOARD_DELETE_SUCCESS.getMessage())
                    .build();
        }
    }
}
