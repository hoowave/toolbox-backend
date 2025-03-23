package com.tools.toolbox.review.application.dto;

import com.tools.toolbox.common.response.CommonResponse;
import com.tools.toolbox.common.response.MessageCode;
import com.tools.toolbox.common.response.ResponseType;
import com.tools.toolbox.review.core.command.ReviewPostCmd;
import com.tools.toolbox.review.core.enums.ReviewStatus;
import com.tools.toolbox.review.core.info.ReviewIdInfo;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

public class ReviewPostDto {

    @Getter
    @Setter
    public static class Request {

        @Size(max = 20, message = "이름은 20자 이내로 입력해주세요.")
        private String author;

        @NotEmpty
        @Size(min = 3, max = 100)
        private String content;

        @Min(value = 0, message = "별점은 최소 0 이상이어야 합니다.")
        @Max(value = 5, message = "별점은 최대 5 이하이어야 합니다.")
        private int star;

        public ReviewPostCmd toCommand() {
            if (author == null || author.isEmpty()) {
                this.author = "익명";
            }
            return ReviewPostCmd.builder()
                    .author(this.author)
                    .content(this.content)
                    .star(this.star)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private Long id;

        public Response(ReviewIdInfo reviewIdInfo) {
            this.id = reviewIdInfo.getId();
        }

        public CommonResponse<Object> toResponse() {
            return CommonResponse.builder()
                    .responseType(ResponseType.SUCCESS)
                    .data(this)
                    .message(MessageCode.REVIEW_WRITE_SUCCESS.getMessage())
                    .build();
        }
    }
}
