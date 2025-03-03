package com.tools.toolbox.cutUrl.core.info;

import com.tools.toolbox.cutUrl.core.CutUrl;
import lombok.Getter;

@Getter
public class CutUrlInfo {
    private String originalUrl;
    private String transUrl;

    public CutUrlInfo(CutUrl cutUrl, String transUrl) {
        this.originalUrl = cutUrl.getOriginalUrl();
        this.transUrl = transUrl;
    }
}
