package com.iweb.servlet;

import com.iweb.dao.ProductDAO;
import com.iweb.dao.impl.ProductDAOImpl;
import com.iweb.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author DuanChangSuo
 * @date 2022/8/12 10:47
 * @description 类的描述和介绍
 **/
@WebServlet(urlPatterns = {"/addProduct"})
public class AddProductServlet extends HttpServlet {
    private static ProductDAO productDAO=new ProductDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置中文处理
//        req.setCharacterEncoding("utf-8");
        //从请求携带的表单中获取对应的数据
        String name=req.getParameter("name");
        Float price=Float.parseFloat(req.getParameter("price"));
        int stock=Integer.parseInt(req.getParameter("stock"));
        int cid=Integer.parseInt(req.getParameter("cid"));
        //将数据封装在对象中
        Product p=new Product();
        p.setCid(cid);
        p.setName(name);
        p.setStock(stock);
        p.setPrice(price);
        //数据入库
        productDAO.add(p);
        //重新访问listProduct 并且携带参数cid 告诉servlet回到哪一个分类的页面下
        resp.sendRedirect("listProduct?id="+cid);
    }
}
