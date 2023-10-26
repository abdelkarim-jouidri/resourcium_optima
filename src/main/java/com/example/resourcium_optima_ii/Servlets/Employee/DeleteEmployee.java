package com.example.resourcium_optima_ii.Servlets.Employee;

import com.example.resourcium_optima_ii.DAO.EmployeeDao;
import com.example.resourcium_optima_ii.Model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home/employees/delete")
public class DeleteEmployee extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("inside the dopost of the delete servlet");
        int ID = Integer.parseInt(req.getParameter("employeeId"));
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.getEmployeeById(ID);
        if(employee!=null){
            System.out.println("employee : " + "does exist : "+ employee.getName());
            employeeDao.delete(employee);
        }
        else {
            System.out.println("there is no employee");
        }

        List<Employee> employees = employeeDao.getAllEmployees();
        req.setAttribute("employees", employees);

        req.getRequestDispatcher("/Employees.jsp").forward(req, resp);
    }
}
