package com.tools.toolbox.account.core.info;

import com.tools.toolbox.account.core.Account;
import com.tools.toolbox.account.core.enums.AccountRole;
import lombok.Getter;

@Getter
public class LoginInfo {
    private String token;
    private String userId;
    private AccountRole role;


    public LoginInfo(Account account, String token) {
        this.userId = account.getUserId();
        this.role = AccountRole.valueOf(account.getRole().name());
        this.token = token;
    }
}
