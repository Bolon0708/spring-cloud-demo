package com.softdev.system.demo.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @Description: TODO
 * @ClassName: CommonService
 * @Author: liangbl
 * @Date: 2020/7/8 10:18
 */
@WebService(name = "CommonService", // 暴露服务名称
        targetNamespace = "http://webservice.demo.system.softdev.com/"// 命名空间,一般是接口的包名倒序
)
public interface CommonService {
    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    String sayHello(@WebParam(name = "userName") String name);
}
