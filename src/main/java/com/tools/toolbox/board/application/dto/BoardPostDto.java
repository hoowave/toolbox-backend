package com.tools.toolbox.board.application.dto;

import com.tools.toolbox.board.core.command.BoardPostCmd;
import com.tools.toolbox.board.core.info.BoardPostInfo;
import com.tools.toolbox.boardcategory.core.enums.CategoryType;
import com.tools.toolbox.common.response.CommonResponse;
import com.tools.toolbox.common.response.MessageCode;
import com.tools.toolbox.common.response.ResponseType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class BoardPostDto {

    @Getter
    @Setter
    public static class Request{

        private CategoryType category;

        @NotEmpty
        @Size(min = 3, max = 100)
        private String title;

        @NotEmpty
        @Size(min = 10)
        private String content;

        public BoardPostCmd toCommand(String userId){
            return BoardPostCmd.builder()
                    .userId(userId)
                    .category(category)
                    .title(title)
                    .content(content)
                    .build();
        }
    }

    @Getter
    public static class Response{
        private Long id;

        public Response(BoardPostInfo boardPostInfo){
            this.id = boardPostInfo.getId();
        }

        public CommonResponse<Object> toResponse() {
            return CommonResponse.builder()
                    .responseType(ResponseType.SUCCESS)
                    .data(this)
                    .message(MessageCode.BOARD_WRITE_SUCCESS.getMessage())
                    .build();
        }

    }

}
