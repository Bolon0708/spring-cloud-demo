package com.softdev.system.demo.webservice;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @Description: TODO
 * @ClassName: CxfConfig
 * @Author: liangbl
 * @Date: 2020/7/8 10:22
 * 配置cxf服务发布,默认服务在Host:port/services/***路径下
 */
@Configuration
public class CxfConfig {
    @Autowired
    private Bus bus;

    @Autowired
    CommonService commonService;

    /** JAX-WS
     * 这里相当于把Commonservice接口发布在了路径/services/CommonService下,wsdl文档路径为 http://localhost:8080/services/CommonService?wsdl
     **/
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, commonService);
        endpoint.publish("/CommonService");
        return endpoint;
    }
}
