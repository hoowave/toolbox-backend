package com.tools.toolbox.review.application.port.in;

import com.tools.toolbox.review.core.command.ReviewGetCmd;
import com.tools.toolbox.review.core.command.ReviewPostCmd;
import com.tools.toolbox.review.core.info.ReviewIdInfo;
import com.tools.toolbox.review.core.info.ReviewListInfo;

public interface ReviewPort {
    ReviewIdInfo create(ReviewPostCmd reviewPostCmd);

    ReviewListInfo readList(ReviewGetCmd reviewGetCmd);
}
