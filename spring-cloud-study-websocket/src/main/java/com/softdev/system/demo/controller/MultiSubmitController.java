package com.softdev.system.demo.controller;

import cn.hutool.json.JSONObject;
import com.softdev.system.demo.annotation.SubmitToken;
import com.softdev.system.demo.util.CacheUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Description: 重复提交demo
 * @ClassName: multiSubmitController
 * @Author: liangbl
 * @Date: 2020/6/29 13:21
 */
@RestController
public class MultiSubmitController {
    @PostMapping("/getSubmitToken")
    public Object getSubmitToken() {
        String submitToken = UUID.randomUUID().toString();
        //将事务请求唯一ID放入缓存池
        CacheUtil.addCache(submitToken, "false");
        //将ID返回给前端
        JSONObject result = new JSONObject();
        result.put("submitToken", submitToken);
        return result;
    }

    /**
     * 将SubmitToken用于增、删、改的方法或者类上
     */
    @SubmitToken
    @PostMapping(value = "/register")
    public boolean register(@RequestBody String userDto) {
        return true;
    }
}
