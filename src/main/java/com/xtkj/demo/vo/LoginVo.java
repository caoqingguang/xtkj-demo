package com.xtkj.demo.vo;

import lombok.Data;

/**
 * Created by caoqingguang on 2017/7/29.
 */
@Data
public class LoginVo {
    private boolean login;
    private String redirectUrl;
    private String errMsg;

    public static LoginVo success(String redirectUrl){
        LoginVo result = new LoginVo();
        result.setLogin(true);
        result.setRedirectUrl(redirectUrl);
        return result;
    }
    public static LoginVo error(String errMsg){
        LoginVo result = new LoginVo();
        result.setErrMsg(errMsg);
        return result;
    }
}
