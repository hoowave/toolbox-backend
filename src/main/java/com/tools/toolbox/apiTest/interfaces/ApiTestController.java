package com.tools.toolbox.apiTest.interfaces;

import com.tools.toolbox.apiTest.ApiTestFacade;
import com.tools.toolbox.apiTest.interfaces.dto.ApiTestPostDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiTestController {

    private final ApiTestFacade apiTestFacade;

    @GetMapping("/test")
    public void onGet() {

    }

    @PostMapping("/test")
    public void onPost(@RequestBody ApiTestPostDto.ApiTestRequest request, HttpServletRequest httpServletRequest) {
        System.out.println(request.getRequestData().toString());
        System.out.println(request.getResponseData().toString());
    }

    @PutMapping("/test")
    public void onPut() {

    }

    @DeleteMapping("/test/{id}")
    public void onDelete(@PathVariable Long id) {

    }

}