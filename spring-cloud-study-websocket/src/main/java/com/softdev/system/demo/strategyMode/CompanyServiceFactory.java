package com.softdev.system.demo.strategyMode;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @ClassName: CompanyServiceFactory
 * @Author: liangbl
 * @Date: 2020/9/24 13:29
 */
@Component
@Slf4j
public class CompanyServiceFactory implements ApplicationContextAware {
    Map<String, ICompanyCommonService> map = Maps.newHashMap();
    Map<String, ICompanyCommonService> map2 = Maps.newHashMap();

    @Autowired
    List<ICompanyCommonService> iCompanyCommonServices;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // Map<String, ICompanyCommonService> tempMap = applicationContext.getBeansOfType(ICompanyCommonService.class);
        // tempMap.values().forEach(iCompanyCommonService -> {
        //     map.put(iCompanyCommonService.getCompanyName(),iCompanyCommonService);
        //     iCompanyCommonService.say();
        // });
        // System.out.println(map);

        iCompanyCommonServices.forEach(iCompanyCommonService -> map2.put(iCompanyCommonService.getCompanyName(),iCompanyCommonService));
        System.out.println(map2);
    }

    public void handler(String req) {
        map2.get(req).say();
    }
}
