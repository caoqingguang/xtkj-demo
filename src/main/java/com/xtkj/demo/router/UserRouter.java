package com.xtkj.demo.router;

import com.xtkj.demo.annotation.BgUrl;
import com.xtkj.demo.annotation.RegBean;
import com.xtkj.demo.pojo.UserPojo;
import com.xtkj.demo.service.UserService;
import com.xtkj.demo.tools.JsonTool;
import com.xtkj.demo.vo.LoginVo;
import io.netty.handler.codec.http.cookie.Cookie;
import io.netty.handler.codec.http.cookie.DefaultCookie;
import ratpack.form.Form;
import ratpack.handling.Context;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by caoqingguang on 2017/7/28.
 */
@RegBean
public class UserRouter {

    @Inject
    private UserService userService;

    @BgUrl("/usr/login")
    public void login(Context ctx){
        String user = ctx.getRequest().getQueryParams().get("user");
        String password = ctx.getRequest().getQueryParams().get("password");
        UserPojo userByName = userService.getUserByName(user);
        LoginVo result;
        if(userByName!=null&&userByName.getPassword().equals(password)){
            setCookie(ctx,userByName);
            result=LoginVo.success("/");
        }else {
            result=LoginVo.error("用户名密码错误");
        }
        ctx.render(JsonTool.obj2Str(result));
    }

    @BgUrl("/usr/check")
    public void loginCheck(Context ctx){
        UserPojo user = getUser(ctx);
        if(user==null){
            ctx.redirect(302,"/login.html");
        }else{
            ctx.redirect(302,"/index.html");
        }
    }

    @BgUrl("/usr/logout")
    public void logout(Context ctx){
        cleanCookie(ctx);
        ctx.redirect(302,"/login.html");
    }

    void setCookie(Context ctx,UserPojo user){
        Cookie token = new DefaultCookie(UserService.cookieFlag, user.getToken());
        token.setMaxAge(60000);
        token.setPath("/");
        ctx.getResponse().getCookies().add(token);

    }
    void cleanCookie(Context ctx){
        Cookie access_token = ctx.getResponse().expireCookie(UserService.cookieFlag);
        access_token.setPath("/");
        access_token.setMaxAge(0);
    }

    UserPojo getUser(Context ctx){
        String token = ctx.getRequest().oneCookie(UserService.cookieFlag);
        return userService.getUserByToken(token);
    }

}
