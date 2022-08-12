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
 * @date 2022/8/11 18:21
 * @description 类的描述和介绍
 **/
@WebServlet(urlPatterns = {"/addCategory"})
public class AddCategoryServlet extends HttpServlet {
    private static CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
        Category category = new Category();
        category.setName(req.getParameter("name"));
        categoryDAO.add(category);
        resp.sendRedirect("/listCategory");
//        List<Category> categories = categoryDAO.list();
//        req.setAttribute("categories", categories);
//        req.getRequestDispatcher("page/category/listCategory.jsp").forward(req, resp);
    }
}

