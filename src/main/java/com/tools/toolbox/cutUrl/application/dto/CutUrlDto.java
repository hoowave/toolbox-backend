package com.tools.toolbox.cutUrl.application.dto;

import lombok.Getter;
import lombok.Setter;

public class CutUrlDto {

    @Getter
    @Setter
    public static class Request{
        private String originalUrl;
    }

    @Getter
    @Setter
    public static class Response{
        private String transUrl;
    }
}
