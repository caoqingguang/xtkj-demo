package com.xtkj.demo.router;

import com.xtkj.demo.pojo.UserPojo;
import com.xtkj.demo.service.UserService;
import com.xtkj.demo.tools.JsonTool;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import javax.inject.Inject;

/**
 * Created by caoqingguang on 2017/7/2.
 */
public class UserHandler implements Handler {
    @Inject
    private UserService userService;

    @Override
    public void handle(Context ctx) throws Exception {
        UserPojo user = userService.getUserById(38);
        ctx.render(JsonTool.obj2Str(user));
    }
}
