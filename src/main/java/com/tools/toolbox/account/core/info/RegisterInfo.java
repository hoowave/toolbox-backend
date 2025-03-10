package com.tools.toolbox.account.core.info;

import com.tools.toolbox.account.core.Account;
import lombok.Getter;

@Getter
public class RegisterInfo {
    private String name;
    private String userId;
    private String email;
    private String phone;

    public RegisterInfo(Account account){
        this.name = account.getName();
        this.userId = account.getUserId();
        this.email = account.getEmail();
        this.phone = account.getPhone();
    }
}
