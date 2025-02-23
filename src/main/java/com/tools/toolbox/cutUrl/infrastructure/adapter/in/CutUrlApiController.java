package com.tools.toolbox.cutUrl.infrastructure.adapter.in;

import com.tools.toolbox.cutUrl.application.dto.CutUrlDto;
import com.tools.toolbox.cutUrl.application.port.in.CutUrlPort;
import com.tools.toolbox.cutUrl.application.service.CutUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CutUrlApiController {

    private final CutUrlPort cutUrlPort;

    @PostMapping("/cut-url")
    public void doPost(@RequestBody CutUrlDto.Request request) {
        System.out.println(request.getOriginalUrl());
        cutUrlPort.save();
    }

}
