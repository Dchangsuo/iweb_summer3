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
 * @date 2022/8/11 19:35
 * @description 类的描述和介绍
 **/
@WebServlet(urlPatterns = {"/deleteCategory"})
public class DeleteCategoryServlet extends HttpServlet {
    private static CategoryDAO categoryDAO = new CategoryDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        categoryDAO.delete(id);
        resp.sendRedirect("/listCategory");
//        List<Category> categories = categoryDAO.list();
//        req.setAttribute("categories", categories);
//        req.getRequestDispatcher("page/category/listCategory.jsp").forward(req, resp);
    }
}
