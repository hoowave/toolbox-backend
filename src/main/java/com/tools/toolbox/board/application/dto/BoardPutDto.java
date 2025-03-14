package com.tools.toolbox.board.application.dto;

import com.tools.toolbox.board.core.command.BoardPutCmd;
import com.tools.toolbox.board.core.info.BoardIdInfo;
import com.tools.toolbox.common.response.CommonResponse;
import com.tools.toolbox.common.response.MessageCode;
import com.tools.toolbox.common.response.ResponseType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class BoardPutDto {

    @Getter
    @Setter
    public static class Request {
        private Long id;

        @NotEmpty
        @Size(min = 3, max = 100)
        private String title;

        @NotEmpty
        @Size(min = 10)
        private String content;

        public BoardPutCmd toCommand(String userId) {
            return BoardPutCmd.builder()
                    .userId(userId)
                    .id(id)
                    .title(title)
                    .content(content)
                    .build();
        }
    }

    @Getter
    public static class Response{
        private Long id;

        public Response(BoardIdInfo boardIdInfo){
            this.id = boardIdInfo.getId();
        }

        public CommonResponse<Object> toResponse() {
            return CommonResponse.builder()
                    .responseType(ResponseType.SUCCESS)
                    .data(this)
                    .message(MessageCode.BOARD_MODIFY_SUCCESS.getMessage())
                    .build();
        }

    }

}
