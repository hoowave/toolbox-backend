package com.tools.toolbox.account.core.command;

import com.tools.toolbox.account.core.Account;
import com.tools.toolbox.account.core.enums.AccountRole;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisterCmd {
    private String name;
    private String userId;
    private String password;
    private String email;
    private String phone;

    public Account toEntity(String encryptedPassword) {
        return Account.builder()
                .name(name)
                .userId(userId)
                .password(encryptedPassword)
                .email(email)
                .phone(phone)
                .role(AccountRole.USER)
                .build();
    }
}
