package com.iweb.filter;

import com.iweb.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author DuanChangSuo
 * @date 2022/8/12 16:14
 * @description 类的描述和介绍
 **/
@WebFilter(urlPatterns = {"/*"})
public class C_AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //session验证
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;
        //获取URL，只有根据URL才能判断用户访问的是啥
        String uri=req.getRequestURI();
        //判断访问的请求是否是登录界面本身，或者是访问登录提交路径
        //我们的登录页面是login.html，表单提交的路径是/login
        //这两个路径过滤器是不可以拦截的，否则永远无法访问任何路径
        if(uri.endsWith("login.html")||uri.endsWith("login")){
            filterChain.doFilter(req,resp);
            return;
        }
        User user=(User) req.getSession().getAttribute("user");
        if(user.getName()==null){
            resp.sendRedirect("login.html");
            return;
        }
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
