package com.tools.toolbox.review.infrastructure.adapter.in;

import com.tools.toolbox.common.response.CommonResponse;
import com.tools.toolbox.review.application.dto.ReviewGetDto;
import com.tools.toolbox.review.application.dto.ReviewPostDto;
import com.tools.toolbox.review.application.port.in.ReviewPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewApiController {
    private final ReviewPort reviewPort;

    @GetMapping()
    public CommonResponse<Object> doGet(
            @RequestParam(defaultValue = "0") int page
    ) {
        var request = new ReviewGetDto.Request(page);
        var reviewGetCmd = request.toCommand();
        var info = reviewPort.readList(reviewGetCmd);
        var responseDto = new ReviewGetDto.Response(info);
        return responseDto.toResponse();
    }

    @PostMapping()
    public CommonResponse<Object> doPost(
            @Valid @RequestBody ReviewPostDto.Request request
            ) {
        var reviewPostCmd = request.toCommand();
        var info = reviewPort.create(reviewPostCmd);
        var responseDto = new ReviewPostDto.Response(info);
        return responseDto.toResponse();
    }
}
