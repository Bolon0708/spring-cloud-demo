package com.softdev.system.demo.strategyMode;

import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @ClassName: CompanyAServiceImpl
 * @Author: liangbl
 * @Date: 2020/9/24 13:27
 */
@Service
public class CompanyAServiceImpl extends AbstractCompanyCommonService implements ICompanyCommonService {
    @Override
    public void say() {
        handlerTempPlate("A");
        System.out.println(">>>>>>>>>>>A");
    }

    @Override
    public String getCompanyName() {
        return "A";
    }

    @Override
    boolean isRequestByProxy() {
        return true;
    }
}
