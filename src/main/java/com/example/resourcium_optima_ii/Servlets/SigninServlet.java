package com.example.resourcium_optima_ii.Servlets;

import com.example.resourcium_optima_ii.DAO.UserDao;
import com.example.resourcium_optima_ii.Model.User;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class SigninServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pwd = req.getParameter("password");
        UserDao userDao = new UserDao(Persistence.createEntityManagerFactory("resourcium_optima"));
        User userByEmail = userDao.getUserByEmail(email);
        if (userByEmail != null){
            if(userByEmail.verifyPassword(pwd)){
                req.setAttribute("homePageMessage", userByEmail.getEmail());
                req.getRequestDispatcher("home.jsp").forward(req, resp);
            }
            else {
                req.setAttribute("invalidPasswordMessage", "invalid password");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }
        if (userByEmail == null){
            System.out.println("No such user with these credentials");
//            req.setAttribute("message", "No such user with these credentials");
//            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
