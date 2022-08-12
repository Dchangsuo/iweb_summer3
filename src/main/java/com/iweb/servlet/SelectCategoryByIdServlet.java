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

/**
 * @author DuanChangSuo
 * @date 2022/8/11 22:16
 * @description 类的描述和介绍
 **/

@WebServlet("/editCategory")
public class SelectCategoryByIdServlet extends HttpServlet {
    CategoryDAO categoryDAO  = new CategoryDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Category category = categoryDAO.get(Integer.parseInt(id));
        //将查询到的javaBean请求存到request域中并转发 以便于数据回显
        req.setAttribute("category",category);
        req.getRequestDispatcher("/page/category/updateCategory.jsp").forward(req,resp);
    }
}
