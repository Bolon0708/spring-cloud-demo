package com.softdev.system.demo.strategyMode;

/**
 * @Description: TODO
 * @ClassName: AbstractCompanyCommonService
 * @Author: liangbl
 * @Date: 2020/9/24 13:58
 */
abstract class AbstractCompanyCommonService implements ICompanyCommonService {
    //模板方法
    void handlerTempPlate(String req) {
        //查询商户信息
        System.out.println("[" + req + "]查询商户信息");
        // 加签
        System.out.println("加签");
        //http 请求
        if (isRequestByProxy()) {
            System.out.println("http 请求");
        } else {
            System.out.println("http 请求2");
        }
        // 验签
        System.out.println("验签");
    }

    // Http是否走代理
    abstract boolean isRequestByProxy();
}
