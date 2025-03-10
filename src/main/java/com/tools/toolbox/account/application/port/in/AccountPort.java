package com.tools.toolbox.account.application.port.in;

import com.tools.toolbox.account.core.command.LoginCmd;
import com.tools.toolbox.account.core.command.RegisterCmd;
import com.tools.toolbox.account.core.info.LoginInfo;
import com.tools.toolbox.account.core.info.RegisterInfo;

public interface AccountPort {
    RegisterInfo register(RegisterCmd registerCmd);
    LoginInfo login(LoginCmd loginCmd);

}
