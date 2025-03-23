package com.tools.toolbox.account.application.service;

import com.tools.toolbox.account.application.port.in.AccountPort;
import com.tools.toolbox.account.application.port.out.AccountRepositoryPort;
import com.tools.toolbox.account.core.Account;
import com.tools.toolbox.account.core.command.LoginCmd;
import com.tools.toolbox.account.core.command.RegisterCmd;
import com.tools.toolbox.account.core.info.LoginInfo;
import com.tools.toolbox.account.core.info.RegisterInfo;
import com.tools.toolbox.common.exception.BaseException;
import com.tools.toolbox.common.response.MessageCode;
import com.tools.toolbox.utils.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountPort {

    private final AccountRepositoryPort accountRepositoryPort;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    @Transactional
    public RegisterInfo register(RegisterCmd registerCmd) {
        Optional<Account> existUserId = accountRepositoryPort.findByUserId(registerCmd.getUserId());
        if (existUserId.isPresent()) {
            throw new BaseException(MessageCode.REGISTER_EXIST_ID.getMessage());
        }
        var initCmd = registerCmd.toEntity(passwordEncoder.encode(registerCmd.getPassword()));
        accountRepositoryPort.save(initCmd);
        var registerInfo = new RegisterInfo(initCmd);
        return registerInfo;
    }

    @Override
    @Transactional
    public LoginInfo login(LoginCmd loginCmd) {
        Optional<Account> existUserId = accountRepositoryPort.findByUserId(loginCmd.getUserId());
        if (existUserId.isEmpty()) throw new BaseException(MessageCode.LOGIN_FAIL.getMessage());
        if (!passwordEncoder.matches(loginCmd.getPassword(), existUserId.get().getPassword()))
            throw new BaseException(MessageCode.LOGIN_FAIL.getMessage());
        String token = jwtUtil.generateToken(existUserId.get().getUserId(), existUserId.get().getRole().name());
        var loginInfo = new LoginInfo(existUserId.get() ,token);
        return loginInfo;
    }
}
