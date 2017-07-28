package com.xtkj.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Created by caoqingguang on 2017/7/2.
 */
@Data
public class UserPojo {
    private Integer id;
    private String name;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String token;
    private String phone;
}
