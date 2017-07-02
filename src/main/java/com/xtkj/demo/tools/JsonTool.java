package com.xtkj.demo.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by caoqingguang on 2017/7/2.
 */
public abstract class JsonTool {


    public static String obj2Str(Object object){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String result = objectMapper.writeValueAsString(object);
            return result;
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}
