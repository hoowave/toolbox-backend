package com.tools.toolbox.board.application.dto;

import com.tools.toolbox.board.core.command.BoardDetailsCmd;
import com.tools.toolbox.board.core.enums.BoardStatus;
import com.tools.toolbox.board.core.info.BoardDetailsInfo;
import com.tools.toolbox.common.response.CommonResponse;
import com.tools.toolbox.common.response.MessageCode;
import com.tools.toolbox.common.response.ResponseType;
import lombok.Getter;
import lombok.Setter;

public class BoardDetailsDto {

    @Getter
    @Setter
    public static class Request {
        private Long id;

        public Request(Long id) {
            this.id = id;
        }

        public BoardDetailsCmd toCommand() {
            return BoardDetailsCmd.builder()
                    .id(id)
                    .build();
        }

    }

    @Getter
    public static class Response {
        private Long id;
        private String author;
        private String title;
        private String content;
        private int hit;
        private BoardStatus status;
        private String createdAt;

        public Response(BoardDetailsInfo boardDetailsInfo) {
            this.id = boardDetailsInfo.getId();
            this.author = boardDetailsInfo.getAuthor();
            this.title = boardDetailsInfo.getTitle();
            this.content = boardDetailsInfo.getContent();
            this.hit = boardDetailsInfo.getHit();
            this.status = boardDetailsInfo.getStatus();
            this.createdAt = boardDetailsInfo.getCreatedAt();
        }

        public CommonResponse<Object> toResponse() {
            return CommonResponse.builder()
                    .responseType(ResponseType.SUCCESS)
                    .data(this)
                    .message(MessageCode.BOARD_DETAILS_SUCCESS.getMessage())
                    .build();
        }
    }
}
