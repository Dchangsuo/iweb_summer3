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
 * @author DuanChangSuo
 * @date 2022/8/11 22:30
 * @description 类的描述和介绍
 **/

@WebServlet("/updateCategoryServlet")
public class UpdateCategoryServlet extends HttpServlet {
    CategoryDAO categoryDAO = new CategoryDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
        //参数接收
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        Category category = new Category();
        category.setId(Integer.parseInt(id));
        category.setName(name);
        //调用DAO更新方法
        categoryDAO.update(category);
        resp.sendRedirect("/listCategory");
//        List<Category> categories = categoryDAO.list();
//        req.setAttribute("categories", categories);
//        req.getRequestDispatcher("page/category/listCategory.jsp").forward(req,resp);

    }
}

