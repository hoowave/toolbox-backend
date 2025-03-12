package com.tools.toolbox.board.infrastructure.adapter.in;

import com.tools.toolbox.board.application.dto.BoardDetailsDto;
import com.tools.toolbox.board.application.dto.BoardListDto;
import com.tools.toolbox.board.application.dto.BoardPostDto;
import com.tools.toolbox.board.application.port.in.BoardPort;
import com.tools.toolbox.boardcategory.core.enums.CategoryType;
import com.tools.toolbox.common.response.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardApiController {

    private final BoardPort boardPort;

    @GetMapping()
    public CommonResponse<Object> doList(
            @RequestParam(defaultValue = "NOTICE") CategoryType category,
            @RequestParam(defaultValue = "0") int page
    ) {
        var request = new BoardListDto.Request(category, page);
        var boardListCmd = request.toCommand();
        var info = boardPort.readList(boardListCmd);
        var responseDto = new BoardListDto.Response(info);
        return responseDto.toResponse();
    }

    @GetMapping("/{id}")
    public CommonResponse<Object> doDetails(
            @PathVariable("id") long id
    ) {
        var request = new BoardDetailsDto.Request(id);
        var boardDetailsCmd = request.toCommand();
        var info = boardPort.readDetails(boardDetailsCmd);
        var responseDto = new BoardDetailsDto.Response(info);
        return responseDto.toResponse();
    }

    @PostMapping()
    public CommonResponse<Object> doPost(
            @AuthenticationPrincipal String userId,
            @Valid @RequestBody BoardPostDto.Request request
    ) {
        var boardPostCmd = request.toCommand(userId);
        var info = boardPort.create(boardPostCmd);
        var responseDto = new BoardPostDto.Response(info);
        return responseDto.toResponse();
    }

    @PutMapping()
    public CommonResponse<Object> doPut(
//            @AuthenticationPrincipal String userId,
//            @Valid @RequestBody BoardPutDto.Request request
    ) {
        return null;
    }

    @DeleteMapping()
    public CommonResponse<Object> doDelete() {
        return null;
    }

}
