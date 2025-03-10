package com.tools.toolbox.account.infrastructure.adapter.out;

import com.tools.toolbox.account.application.port.out.AccountRepositoryPort;
import com.tools.toolbox.account.core.Account;
import com.tools.toolbox.account.infrastructure.repository.jpa.AccountJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryAdapter implements AccountRepositoryPort {

    private final AccountJpaRepository accountJpaRepository;

    @Override
    public Optional<Account> findByUserId(String userId) {
        Optional<Account> existAccount = accountJpaRepository.findByUserId(userId);
        return existAccount;
    }

    @Override
    public void save(Account account) {
        accountJpaRepository.save(account);
    }
}
