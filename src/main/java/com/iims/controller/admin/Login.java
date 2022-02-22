package com.iims.controller.admin;

import com.iims.dao.AdminDao;
import com.iims.dao.impl.AdminDaoImpl;
import com.iims.model.Admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "admin", urlPatterns = "/admin")
public class Login extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("user") == null) {
            req.setAttribute("action", "save");
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.forward(req, resp);
        } else {
            resp.sendRedirect("./");
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password= req.getParameter("password");

        if(username.length() > 0 && password.length() > 0){
            session.removeAttribute("user");
            session.setAttribute("username", username);

            AdminDao adminDao = new AdminDaoImpl();
            try {
                Admin admin = adminDao.findOne(username, password);
                if(admin != null){
                    session.setAttribute("user", admin);
                    resp.sendRedirect("profile");

                    session.removeAttribute("username");
                }
                else {
                    resp.sendRedirect("admin");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            resp.sendRedirect("admin");
        }
    }
}

