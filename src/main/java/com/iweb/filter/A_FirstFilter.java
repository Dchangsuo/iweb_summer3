package com.iweb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 测试使用的过滤器
 * @author DuanChangSuo
 * @date 2022/8/12 15:47
 * @description 类的描述和介绍
 **/
@WebFilter(urlPatterns = {"/*"})
public class A_FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("可以通过重写init方法来定义我们需要在过滤器启动的时候要做什么" +
                "Filter一定会随着Tomcat的启动而自启动，如果Filter启动失败或者本身有编译错误，不仅" +
                "Filter不能使用，Tomcat也无法启动");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //为了保证方法正常的调用，需要对参数进行类型转换
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;
        //尝试在过滤器中获取数据
        String ip=req.getRemoteAddr();
        String url=req.getRequestURL().toString();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date d=new Date();
        String date=sdf.format(d);
        //打印
        System.out.printf("%s %s 访问了%s%n",date,ip,url);
        //过滤器对请求进行放行，如果没有过滤器，则执行下一个过滤器
        //如果已经是最后一个过滤器，则开始访问对应的Servlet
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("在过滤器被销毁的时候所执行的方法，一般没什么用");

    }
}
