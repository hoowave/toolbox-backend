package com.tools.toolbox.apiTest.interfaces;

import com.tools.toolbox.apiTest.ApiTestFacade;
import com.tools.toolbox.apiTest.domain.info.ApiTestGetInfo;
import com.tools.toolbox.apiTest.interfaces.dto.ApiTestGetDto;
import com.tools.toolbox.apiTest.interfaces.dto.ApiTestPostDto;
import com.tools.toolbox.common.response.CommonResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api-test")
public class ApiTestController {

    private final ApiTestFacade apiTestFacade;

    @GetMapping("/{id}")
    public CommonResponse<Object> doGet(@PathVariable("id") @Min(1) @Max(10) int id) {
        var request = new ApiTestGetDto.Request(id);
        var apiTestGetCmd = request.toCommand();
        var info = apiTestFacade.getAction(apiTestGetCmd);
        var responseDto = new ApiTestGetDto.Response(info);
        return responseDto.toResponse();
    }

    @PostMapping("")
    public CommonResponse<Object> doPost(@RequestBody ApiTestPostDto.Request request) {
        var apiTestPostCmd = request.toCommand();
        var info = apiTestFacade.postAction(apiTestPostCmd);
        var responseDto = new ApiTestPostDto.Response(info);
        return responseDto.toResponse();
    }

}