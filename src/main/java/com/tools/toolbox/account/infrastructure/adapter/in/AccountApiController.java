package com.tools.toolbox.account.infrastructure.adapter.in;

import com.tools.toolbox.account.application.dto.LoginDto;
import com.tools.toolbox.account.application.dto.RegisterDto;
import com.tools.toolbox.account.application.port.in.AccountPort;
import com.tools.toolbox.common.response.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountApiController {
    private final AccountPort accountPort;

    @PostMapping("/register")
    public CommonResponse<Object> doRegister(@Valid @RequestBody RegisterDto.Request request) {
        var registerCmd = request.toCommand();
        var info = accountPort.register(registerCmd);
        var responseDto = new RegisterDto.Response(info);
        return responseDto.toResponse();
    }

    @PostMapping("/login")
    public CommonResponse<Object> doLogin(@Valid @RequestBody LoginDto.Request request) {
        var loginCmd = request.toCommand();
        var info = accountPort.login(loginCmd);
        var responseDto = new LoginDto.Response(info);
        return responseDto.toResponse();
    }

}
