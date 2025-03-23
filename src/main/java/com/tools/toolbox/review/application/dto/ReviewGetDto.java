package com.tools.toolbox.review.application.dto;

import com.tools.toolbox.common.response.CommonResponse;
import com.tools.toolbox.common.response.MessageCode;
import com.tools.toolbox.common.response.ResponseType;
import com.tools.toolbox.review.core.command.ReviewGetCmd;
import com.tools.toolbox.review.core.info.ReviewListInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ReviewGetDto {

    @Getter
    @Setter
    public static class Request {
        private int page;

        public Request(int page) {
            this.page = page - 1;
        }

        public ReviewGetCmd toCommand() {
            return ReviewGetCmd.builder()
                    .page(page)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private List<ReviewListInfo.ReviewInfo> content;
        private int pageNumber;
        private int totalPageNumber;
        private Long totalNumber;
        private boolean isFirst;
        private boolean isLast;
        private boolean isEmpty;

        public Response(ReviewListInfo reviewListInfo) {
            this.content = reviewListInfo.getContents();
            this.pageNumber = reviewListInfo.getPageNumber();
            this.totalPageNumber = reviewListInfo.getTotalPageNumber();
            this.totalNumber = reviewListInfo.getTotalNumber();
            this.isFirst = reviewListInfo.isFirst();
            this.isLast = reviewListInfo.isLast();
            this.isEmpty = reviewListInfo.isEmpty();
        }

        public CommonResponse<Object> toResponse() {
            return CommonResponse.builder()
                    .responseType(ResponseType.SUCCESS)
                    .data(this)
                    .message(MessageCode.REVIEW_LIST_SUCCESS.getMessage())
                    .build();
        }
    }
}
