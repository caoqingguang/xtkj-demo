package com.xtkj.demo.service;

import com.xtkj.demo.annotation.RegBean;
import com.xtkj.demo.pojo.UserPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoqingguang on 2017/7/2.
 */
@RegBean
public class UserService {

    private List<UserPojo> userPojoList=new ArrayList<>();
    public static final String cookieFlag="access_token";
    {
        UserPojo userPojo = new UserPojo();
        userPojo.setId(1);
        userPojo.setName("admin");
        userPojo.setPhone("18644448888");
        userPojo.setPassword("admin");
        userPojo.setToken("acdeffg");
        userPojoList.add(userPojo);

    }
    public UserPojo getUserByName(String name){
        for (UserPojo userPojo : userPojoList) {
            if(userPojo.getName().equals(name)){
                return userPojo;
            }
        }
        return null;
    }


    public UserPojo getUserByToken(String token){
        for (UserPojo userPojo : userPojoList) {
            if(userPojo.getToken().equals(token)){
                return userPojo;
            }
        }
        return null;
    }
}
