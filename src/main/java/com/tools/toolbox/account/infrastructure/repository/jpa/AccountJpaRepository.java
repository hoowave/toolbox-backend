package com.tools.toolbox.account.infrastructure.repository.jpa;

import com.tools.toolbox.account.core.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUserId(String userId);
}
