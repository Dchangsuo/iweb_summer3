package com.iweb.servlet;

import com.iweb.dao.CategoryDAO;
import com.iweb.dao.impl.CategoryDAOImpl;
import com.iweb.pojo.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author syl
 * @date 2022/8/11 16:24
 * @description 类的描述和介绍
 */

/**
 * 默认查询所有分类数据，并且显示到listCategory页面上
 */
@WebServlet(urlPatterns = {"/listCategory"})
public class CategoryListServlet extends HttpServlet {
    private static CategoryDAO dao=new CategoryDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取对应分类集合
        List<Category> categories=dao.list();
        //存入请求中
        req.setAttribute("categories",categories);
        //利用转发进行页面跳转,通过请求的作用域
        req.getRequestDispatcher("page/category/listCategory.jsp").forward(req,resp);
    }
}
