package com.softdev.system.demo.webservice;

import com.softdev.system.demo.webservice.CommonService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @Description: TODO
 * @ClassName: CommonServiceImpl
 * @Author: liangbl
 * @Date: 2020/7/8 10:19
 */

@WebService(serviceName = "CommonService", // 与接口中指定的name一致
        targetNamespace = "http://webservice.demo.system.softdev.com/", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.softdev.system.demo.webservice.CommonService"// 接口地址
)
@Component
public class CommonServiceImpl implements CommonService {
    @Override
    public String sayHello(String name) {
        return "Hello ," + name;
    }
}
