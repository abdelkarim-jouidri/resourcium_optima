package com.example.resourcium_optima_ii.Servlets;

import com.example.resourcium_optima_ii.DAO.UserDao;
import com.example.resourcium_optima_ii.Model.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SignupServlet", value = "/signup")
public class SignupServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String email = request.getParameter("email");
            String pwd = request.getParameter("pwd");
            User user = new User(fname, lname,email, pwd);
            EntityManagerFactory resourciumOptima = Persistence.createEntityManagerFactory("resourcium_optima");
            UserDao userDao = new UserDao(resourciumOptima);
            userDao.save(user);
            response.sendRedirect(request.getContextPath()+"/WEB-INF/success.jsp");
        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/WEB-INF/error.jsp");

        }
        finally {
            System.out.println("this is from the finally block");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
    }


}
