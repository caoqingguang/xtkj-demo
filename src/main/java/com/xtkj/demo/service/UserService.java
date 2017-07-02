package com.xtkj.demo.service;

import com.xtkj.demo.pojo.UserPojo;

/**
 * Created by caoqingguang on 2017/7/2.
 */
public class UserService {

    public UserPojo getUserById(Integer userId){
        UserPojo userPojo = new UserPojo();
        userPojo.setId(userId);
        userPojo.setName("张三丰");
        userPojo.setPhone("18644448888");
        return userPojo;
    }
}
