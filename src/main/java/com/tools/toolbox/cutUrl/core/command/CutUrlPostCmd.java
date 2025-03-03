package com.tools.toolbox.cutUrl.core.command;

import com.tools.toolbox.cutUrl.core.CutUrl;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CutUrlPostCmd {
    private String originalUrl;

    public CutUrl toEntity(String uuid) {
        return CutUrl.builder()
                .originalUrl(originalUrl)
                .uuid(uuid)
                .build();
    }
}
