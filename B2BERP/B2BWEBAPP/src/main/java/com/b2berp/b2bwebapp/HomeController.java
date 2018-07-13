/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b2berp.b2bwebapp;

import com.b2berp.b2bmodel.core.User;
import com.b2berp.b2brepository.dao.UserDAO;
import com.b2berp.b2brepository.dao.impl.UserDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Milap Patel
 */
@WebServlet(name = "HomeControllerServlet", value = "/home/*")
public class HomeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = UserDAOImpl.getInstance();
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        if (req.getRequestURL().toString().contains("home/login.html")) {
            User user = userDAO.findUserByUserName(req.getParameter("username"), true);
            if (user != null && user.getPassword().equals(req.getParameter("password"))) {
                HttpSession session = req.getSession(true);
                session.setAttribute("userid", user.getId());
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(6000);
                //System.out.println(companyUsersDAO.createBackUp("LOGIN_" + companyUsers.getUserName()));
                resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                resp.setDateHeader("Expires", 0); // Proxies.
                out.println("USER GOING TO LOGIN : " + user.getId());
            }
            System.gc();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        if (req.getRequestURL().toString().contains("home/logout.html")) {
            HttpSession session = req.getSession();
            session.removeAttribute("userid");
            session.removeAttribute("user");
            session.setMaxInactiveInterval(-1);
            session.invalidate();
            resp.setHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate"); // HTTP 1.1.
            resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            resp.setDateHeader("Expires", 0); // Proxies.

            resp.sendRedirect(req.getScheme() + "://"
                    + // "http" + "://
                    req.getServerName()
                    + // "myhost"
                    ":"
                    + // ":"
                    req.getServerPort()
                    + // "8080"
                    req.getContextPath());
        }

        if (req.getRequestURL().toString().contains("home/module/")) {
            System.out.println("===>" + req.getRequestURL().toString());
            String modulesId = req.getRequestURL().toString().substring(req.getRequestURL().toString().lastIndexOf("/"));
            RequestDispatcher rd = req.getRequestDispatcher("/view/layouts/modules/" + modulesId + "/" + modulesId + ".jsp");
            rd.forward(req, resp);
            // System.gc();
        }
        if (req.getRequestURL().toString().contains("home/createform/module/")) {
            System.out.println("===>" + req.getRequestURL().toString());
            String modulesId = req.getRequestURL().toString().substring(req.getRequestURL().toString().lastIndexOf("/"));
            RequestDispatcher rd = req.getRequestDispatcher("/view/layouts/modules/" + modulesId + "/createform.jsp");
            rd.forward(req, resp);
            // System.gc();
        }
    }

}
