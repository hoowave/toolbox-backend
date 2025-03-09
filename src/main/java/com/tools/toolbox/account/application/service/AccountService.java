package com.tools.toolbox.account.application.service;

import com.tools.toolbox.account.application.port.in.AccountPort;
import com.tools.toolbox.account.application.port.out.AccountRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountPort {
    private final AccountRepositoryPort accountRepositoryPort;

}
