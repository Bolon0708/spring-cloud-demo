package com.softdev.system.demo.strategyMode;

import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @ClassName: CompanyBServiceImpl
 * @Author: liangbl
 * @Date: 2020/9/24 13:28
 */
@Service
public class CompanyBServiceImpl extends AbstractCompanyCommonService implements ICompanyCommonService{
    @Override
    public void say() {
        handlerTempPlate("B");
        System.out.println(">>>>>>>>>>>B");
    }

    @Override
    public String getCompanyName() {
        return "B";
    }

    @Override
    boolean isRequestByProxy() {
        return false;
    }
}
