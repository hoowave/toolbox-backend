package com.tools.toolbox.account.core.info;

import lombok.Getter;

@Getter
public class LoginInfo {
    private String userId;
    private String token;

    public LoginInfo(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }
}
