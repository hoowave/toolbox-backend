package com.tools.toolbox.review.core.command;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewGetCmd {
    private int page;
}
