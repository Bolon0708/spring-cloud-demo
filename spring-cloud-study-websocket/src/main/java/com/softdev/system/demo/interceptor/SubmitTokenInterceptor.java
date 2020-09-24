package com.softdev.system.demo.interceptor;

import com.softdev.system.demo.annotation.SubmitToken;
import com.softdev.system.demo.util.CacheUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 重复提交拦截器
 * @ClassName: Interceptor
 * @Author: liangbl
 * @Date: 2020/6/29 13:25
 */
public class SubmitTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射到方法，直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //如果类或者方法有SubmitToken注解，则进行重复提交验证
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (handlerMethod.getBeanType().isAnnotationPresent(SubmitToken.class) || handlerMethod.getMethod().isAnnotationPresent(SubmitToken.class)) {
            final String submitToken = request.getParameter("submitToken");
            if (StringUtils.isEmpty(submitToken)) {
                throw new Exception("submitToken不能为空！");
            }
            if (!CacheUtil.containKey(submitToken)) {
                throw new Exception("submitToken失效，请重新获取！");
            }
            Object value = CacheUtil.getValue(submitToken);
            if (!"false".equals(value)) {
                throw new Exception("数据正在处理，请不要重复提交");
            }
            //验证通过之后，将submitToken对应的值设置为正在处理
            CacheUtil.setValue(submitToken, "true");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 业务处理完毕之后，将submitToken从缓存中移除
        final String submitToken = request.getParameter("submitToken");
        if (StringUtils.isNotEmpty(submitToken)) {
            CacheUtil.removeCache(submitToken);
        }
    }
}
