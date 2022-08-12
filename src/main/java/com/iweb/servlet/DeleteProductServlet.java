package com.iweb.servlet;

import com.iweb.dao.ProductDAO;
import com.iweb.dao.impl.ProductDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author DuanChangSuo
 * @date 2022/8/12 13:51
 * @description 类的描述和介绍
 **/
@WebServlet(urlPatterns = {"/deleteProduct"})
public class DeleteProductServlet extends HttpServlet {
    private static ProductDAO productDAO=new ProductDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从请求中获取参数id
        int pid=Integer.parseInt(req.getParameter("id"));
        //先根据pid获取该商品的cid
        int cid=productDAO.get(pid).getCid();
        productDAO.delete(pid);
        //重定向到/listProduct,并且在发送请求的时候携带参数id
        //这样在listProduct运行的时候，才知道访问哪个分类的商品列表
        resp.sendRedirect("/listProduct?id="+cid);
    }
}
