package com.example.resourcium_optima_ii.Servlets;

import com.example.resourcium_optima_ii.DAO.EmployeeDao;
import com.example.resourcium_optima_ii.Model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home/reservations")
public class ReservationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.getAllEmployees();

        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/Reservations.jsp").forward(req, resp);
    }
}
