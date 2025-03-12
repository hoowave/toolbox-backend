package com.tools.toolbox.board.infrastructure.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    @GetMapping("")
    public void doGet(){

    }

    @PostMapping("")
    public void doPost(){

    }

}
