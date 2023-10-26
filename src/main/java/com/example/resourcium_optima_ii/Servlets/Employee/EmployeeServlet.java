package com.example.resourcium_optima_ii.Servlets.Employee;

import com.example.resourcium_optima_ii.DAO.EmployeeDao;
import com.example.resourcium_optima_ii.DAO.UserDao;
import com.example.resourcium_optima_ii.Model.Employee;
import com.example.resourcium_optima_ii.Model.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home/employees")
public class EmployeeServlet extends HttpServlet {
    private EmployeeDao employeeDao;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.getAllEmployees();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/Employees.jsp").forward(req, resp);
    }
}