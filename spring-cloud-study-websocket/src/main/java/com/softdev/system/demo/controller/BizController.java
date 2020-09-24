package com.softdev.system.demo.controller;

import com.softdev.system.demo.service.BizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @ClassName: BizController
 * @Author: liangbl
 * @Date: 2020/6/24 13:29
 */
@RestController
public class BizController {
    @Autowired
    BizService bizService;

    @PostMapping("biz1")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok(bizService.getCheckResultSuper("校验2"));
    }
}
