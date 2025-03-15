package com.tools.toolbox.account.core.command;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginCmd {
    private String userId;
    private String password;
}
