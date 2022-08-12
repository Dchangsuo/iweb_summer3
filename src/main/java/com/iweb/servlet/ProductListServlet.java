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
 * @date 2022/8/12 10:08
 * @description 类的描述和介绍
 **/
@WebServlet(urlPatterns = {"/listProduct"})
public class ProductListServlet extends HttpServlet {
    private static ProductDAO productDAO=new ProductDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cid = Integer.parseInt(req.getParameter("id"));
        List<Product> products=productDAO.list(cid);
        req.setAttribute("products",products);
        req.setAttribute("cid",cid);
        System.out.println(products);
        req.getRequestDispatcher("page/product/listProduct.jsp").forward(req,resp);
    }
}
