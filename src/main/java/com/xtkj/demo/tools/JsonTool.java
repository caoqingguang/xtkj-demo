package com.xtkj.demo.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

/**
 * Created by caoqingguang on 2017/7/2.
 */
public abstract class JsonTool {
    static ObjectMapper objectMapper = new ObjectMapper();

    public static String obj2Str(Object object){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String result = objectMapper.writeValueAsString(object);
            return result;
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public static JsonNode str2Json(String str){
        try {
            JsonNode jsonNode = objectMapper.readTree(str);
            return jsonNode;
        } catch (IOException e) {
            return objectMapper.createObjectNode();
        }
    }
}
