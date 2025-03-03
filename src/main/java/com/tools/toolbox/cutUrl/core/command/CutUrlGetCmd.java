package com.tools.toolbox.cutUrl.core.command;

import com.tools.toolbox.cutUrl.core.CutUrl;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CutUrlGetCmd {
    private String uuid;

    public CutUrl toEntity() {
        return CutUrl.builder()
                .uuid(uuid)
                .build();
    }
}
