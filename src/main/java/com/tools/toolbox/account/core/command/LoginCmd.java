package com.tools.toolbox.account.core.command;

import com.tools.toolbox.account.core.Account;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginCmd {
    private String userId;
    private String password;
}
