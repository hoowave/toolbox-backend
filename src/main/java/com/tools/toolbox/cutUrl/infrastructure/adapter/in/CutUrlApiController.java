package com.tools.toolbox.cutUrl.infrastructure.adapter.in;

import com.tools.toolbox.common.response.CommonResponse;
import com.tools.toolbox.cutUrl.application.dto.CutUrlGetDto;
import com.tools.toolbox.cutUrl.application.dto.CutUrlPostDto;
import com.tools.toolbox.cutUrl.application.port.in.CutUrlPort;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class CutUrlApiController {

    private final CutUrlPort cutUrlPort;

    @GetMapping("/{uuid}")
    public void doGet(@Valid CutUrlGetDto.Request request, HttpServletResponse servlet) throws IOException {
        var cutUrlGetCmd = request.toCommand();
        var info = cutUrlPort.process(cutUrlGetCmd);
        var responseDto = new CutUrlGetDto.Response(info);
        servlet.sendRedirect(responseDto.getOriginalUrl());
    }

    @PostMapping("/cut-url")
    public CommonResponse<Object> doPost(@Valid @RequestBody CutUrlPostDto.Request request) {
        var cutUrlPostCmd = request.toCommand();
        var info = cutUrlPort.translate(cutUrlPostCmd);
        var responseDto = new CutUrlPostDto.Response(info);
        return responseDto.toResponse();
    }

}
