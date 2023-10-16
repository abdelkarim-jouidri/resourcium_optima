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
            String pwd = request.getParameter("pwd");
            User user = new User(fname, lname, pwd);
            UserDao userDao = new UserDao(Persistence.createEntityManagerFactory("resourcium_optima"));
            userDao.save(user);
            response.sendRedirect(request.getContextPath()+"/success.jsp");
        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the JSP page
        request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }


}
