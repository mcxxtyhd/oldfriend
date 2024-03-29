package com.feng.oldfriend.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/8/15 22:41
 * @description：
 */
public class LoginAuthFilter implements Filter{

    @Override
    public void destroy() {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        // 设置允许多个域名请求
        String[] allowDomains = {"http://localhost:8888","http://localhost:8080"};
        Set allowOrigins = new HashSet(Arrays.asList(allowDomains));
        String originHeads = req.getHeader("Origin");
        if(allowOrigins.contains(originHeads)){
            //设置允许跨域的配置
            // 这里填写你允许进行跨域的主机ip（正式上线时可以动态配置具体允许的域名和IP）
            rep.setHeader("Access-Control-Allow-Origin", originHeads);
        }


        // 设置服务器允许浏览器发送请求都携带cookie
        rep.setHeader("Access-Control-Allow-Credentials","true");
        // 允许的访问方法
        rep.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, OPTIONS, DELETE, PATCH");
        // Access-Control-Max-Age 用于 CORS 相关配置的缓存
        rep.setHeader("Access-Control-Max-Age", "3600");
        rep.setHeader("Access-Control-Allow-Headers","token,Origin, X-Requested-With, Content-Type, Accept,mid,X-Token");
        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
