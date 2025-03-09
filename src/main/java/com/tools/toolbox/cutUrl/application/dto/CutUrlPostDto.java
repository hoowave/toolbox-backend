package com.tools.toolbox.cutUrl.application.dto;

import com.tools.toolbox.common.exception.BaseException;
import com.tools.toolbox.common.response.CommonResponse;
import com.tools.toolbox.common.response.MessageCode;
import com.tools.toolbox.common.response.ResponseType;
import com.tools.toolbox.cutUrl.core.command.CutUrlPostCmd;
import com.tools.toolbox.cutUrl.core.info.CutUrlInfo;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.validator.routines.UrlValidator;

public class CutUrlPostDto {

    @Getter
    @Setter
    public static class Request {
        private String originalUrl;

        public CutUrlPostCmd toCommand() {
            if (!originalUrl.startsWith("http://") && !originalUrl.startsWith("https://")) {
                originalUrl = "http://" + originalUrl;
            }

            if (!UrlValidator.getInstance().isValid(originalUrl))
                throw new BaseException(MessageCode.COMMON_INVALID_PARAMETER.getMessage());

            return CutUrlPostCmd.builder()
                    .originalUrl(originalUrl)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private String originalUrl;
        private String transUrl;

        public Response(CutUrlInfo cutUrlInfo) {
            this.originalUrl = cutUrlInfo.getOriginalUrl();
            this.transUrl = cutUrlInfo.getTransUrl();
        }

        public CommonResponse<Object> toResponse() {
            return CommonResponse.builder()
                    .responseType(ResponseType.SUCCESS)
                    .data(this)
                    .message(MessageCode.CUTURL_SUCCESS.getMessage())
                    .build();
        }
    }
}
