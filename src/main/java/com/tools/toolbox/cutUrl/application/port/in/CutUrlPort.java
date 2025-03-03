package com.tools.toolbox.cutUrl.application.port.in;

import com.tools.toolbox.cutUrl.core.command.CutUrlGetCmd;
import com.tools.toolbox.cutUrl.core.command.CutUrlPostCmd;
import com.tools.toolbox.cutUrl.core.info.CutUrlInfo;

public interface CutUrlPort {
    CutUrlInfo process(CutUrlGetCmd cutUrlGetCmd);
    CutUrlInfo translate(CutUrlPostCmd cutUrlPostCmd);

}