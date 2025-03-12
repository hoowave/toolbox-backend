package com.tools.toolbox.board.application.dto;

import com.tools.toolbox.board.core.Board;
import com.tools.toolbox.board.core.command.BoardListCmd;
import com.tools.toolbox.board.core.info.BoardListInfo;
import com.tools.toolbox.boardcategory.core.enums.CategoryType;
import com.tools.toolbox.common.response.CommonResponse;
import com.tools.toolbox.common.response.MessageCode;
import com.tools.toolbox.common.response.ResponseType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BoardListDto {

    @Getter
    @Setter
    public static class Request {
        private CategoryType categoryType;
        private int page;

        public Request(CategoryType categoryType, int page) {
            this.categoryType = categoryType;
            this.page = page;
        }

        public BoardListCmd toCommand() {
            return BoardListCmd.builder()
                    .categoryType(categoryType)
                    .page(page)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private List<BoardListInfo.BoardInfo> content;
        private int pageNumber;
        private int totalPageNumber;
        private boolean isFirst;
        private boolean isLast;
        private boolean isEmpty;

        public Response(BoardListInfo boardListInfo) {
            this.content = boardListInfo.getContents();
            this.pageNumber = boardListInfo.getPageNumber();
            this.totalPageNumber = boardListInfo.getTotalPageNumber();
            this.isFirst = boardListInfo.isFirst();
            this.isLast = boardListInfo.isLast();
            this.isEmpty = boardListInfo.isEmpty();
        }

        public CommonResponse<Object> toResponse() {
            return CommonResponse.builder()
                    .responseType(ResponseType.SUCCESS)
                    .data(this)
                    .message(MessageCode.BOARD_LIST_SUCCESS.getMessage())
                    .build();
        }
    }

}
