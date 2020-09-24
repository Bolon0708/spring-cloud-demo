package com.softdev.system.demo.controller;

import com.softdev.system.demo.config.WebSocketServer;
import com.softdev.system.demo.strategyMode.CompanyServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * WebSocketController
 *
 * @author zhengkai.blog.csdn.net
 */
@RestController
public class DemoController {
    @Autowired
    private CompanyServiceFactory companyServiceFactory;

    @GetMapping("index")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("请求成功");
    }

    @GetMapping("page")
    public ModelAndView page() {
        return new ModelAndView("websocket");
    }

    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        WebSocketServer.sendInfo(message, toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }

    @GetMapping("test")
    public String test() {
        // companyServiceFactory.handler("A");
        companyServiceFactory.handler("B");
        return "";
    }
}
