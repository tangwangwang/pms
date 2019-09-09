package com.fyj.pms.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.t2w.utils.captcha.VaptchaUtils;
import com.t2w.utils.captcha.configuration.Vaptcha;
import com.t2w.utils.captcha.domain.CaptchaStatus;
import com.t2w.utils.common.HttpUtils;
import com.t2w.utils.common.domain.HttpMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author T2W
 * @version V1.0.0
 * @email tang.wangwang@qq.com
 * @date 2019-09-09 12:30
 * @name com.fyj.pms.interceptor.CaptchaInterceptor.java
 * @see describing 验证码拦截器
 */
@Slf4j
public class CaptchaInterceptor implements HandlerInterceptor {

    @Autowired
    private Vaptcha vaptcha;

    /** Ajax请求的请求头参数(Ajax请求一定会有这个请求头参数) */
    private static final String AJAX_REQUEST_HEADER_KEY = "x-requested-with";
    /** Ajax请求的请求头参数值 */
    private static final String AJAX_REQUEST_HEADER_VALUE = "XMLHttpRequest";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        // 只拦截 POST 方法
        String method = request.getMethod();
        log.debug("进入验证码拦截器, 拦截方法为: {}", method);
        if (method.equalsIgnoreCase(HttpMethod.POST.getName())) {
            // 必须是Ajax请求方式提交的方法
            String value = request.getHeader(AJAX_REQUEST_HEADER_KEY);
            log.debug("请求头信息为:{}", value);
            if (AJAX_REQUEST_HEADER_VALUE.equals(value)) {
                // 取出 token 进行验证码验证，没有则拦截
                String token = request.getParameter("token");
                CaptchaStatus status = VaptchaUtils.captcha(vaptcha.setToken(token));
                log.debug("验证状态:{}", status);
                JSONObject json = new JSONObject();
                switch (status) {
                    // 验证成功不进行拦截
                    case SUCCESS:
                        return true;
                    case DELAY:
                        json.put("status", "delay");
                        json.put("msg", "网络连接失败");
                        break;
                    case EXPIRED:
                        json.put("status", "expired");
                        json.put("msg", "验证码过期");
                        break;
                    case EXCEPTION:
                        json.put("status", "exception");
                        json.put("msg", "服务器故障");
                        break;
                    case FAIL:
                    default:
                        json.put("status", "fail");
                        json.put("msg", "验证失败");
                }
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json");
                response.getWriter().write(json.toString());
            }
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {

    }
}
