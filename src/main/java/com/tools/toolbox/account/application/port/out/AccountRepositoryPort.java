package com.tools.toolbox.account.application.port.out;

import com.tools.toolbox.account.core.Account;

import java.util.Optional;

public interface AccountRepositoryPort {
    Optional<Account> findByUserId(String userId);

    void save(Account account);
}
