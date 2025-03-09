package com.tools.toolbox.account.infrastructure.adapter.in;

import com.tools.toolbox.account.application.port.in.AccountPort;
import com.tools.toolbox.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountApiController {
    private final AccountPort accountPort;

    @PostMapping("/register")
    public CommonResponse<Object> doRegister() {
        return null;
    }

    @PostMapping("/login")
    public CommonResponse<Object> doLogin() {
        return null;
    }

}
