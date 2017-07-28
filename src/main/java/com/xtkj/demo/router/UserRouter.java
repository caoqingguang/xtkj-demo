package com.xtkj.demo.router;

import com.xtkj.demo.annotation.BgUrl;
import com.xtkj.demo.annotation.RegBean;
import com.xtkj.demo.pojo.UserPojo;
import ratpack.handling.Context;

/**
 * Created by caoqingguang on 2017/7/28.
 */
@RegBean
public class UserRouter {

    @BgUrl("/usr/login")
    public void login(Context ctx){
        ctx.render("123");
    }

    @BgUrl("/usr/logout")
    public void logout(Context ctx){
        ctx.redirect(302,"/");
        return;
    }
}
