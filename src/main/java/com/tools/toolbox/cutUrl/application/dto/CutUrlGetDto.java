package com.tools.toolbox.cutUrl.application.dto;

import com.tools.toolbox.common.response.CommonResponse;
import com.tools.toolbox.common.response.MessageCode;
import com.tools.toolbox.common.response.ResponseType;
import com.tools.toolbox.cutUrl.core.command.CutUrlGetCmd;
import com.tools.toolbox.cutUrl.core.info.CutUrlInfo;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class CutUrlGetDto {

    @Getter
    @Setter
    public static class Request {
        @Pattern(regexp = "^[a-fA-F0-9]{8}$")
        private String uuid;

        public CutUrlGetCmd toCommand() {
            return CutUrlGetCmd.builder().uuid(uuid).build();
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
    }
}
