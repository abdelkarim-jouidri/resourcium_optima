package com.example.resourcium_optima_ii.Servlets.Employee;

import com.example.resourcium_optima_ii.DAO.DepartmentDao;
import com.example.resourcium_optima_ii.DAO.EmployeeDao;
import com.example.resourcium_optima_ii.Model.Department;
import com.example.resourcium_optima_ii.Model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home/employees/add")
public class AddEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentDao departmentDao = new DepartmentDao();
        List<Department> departments = departmentDao.getAllDepartments();
        req.setAttribute("departments", departments);
        req.getRequestDispatcher("/AddEmployee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentDao departmentDao = new DepartmentDao();
        EmployeeDao employeeDao = new EmployeeDao();
        //constructing the Department object
        int depart_ID = Integer.parseInt(req.getParameter("department"));
        Department department = departmentDao.getDepartmentByID(depart_ID);
        //constructing the Employee object
        String name = req.getParameter("name");
        Employee employee = new Employee();
        employee.setName(name);
        employee.setDepartment(department);
        if(employeeDao.save(employee) == true){
            System.out.println("successfully added");
            req.setAttribute("successMessage", "The new employee has been added successfully");
        }
        else {
            System.out.println("Error while trying to add the employee");
            req.getSession().setAttribute("errorMessage", "something went wrong !!");
        }
        req.getRequestDispatcher("/AddEmployee.jsp").forward(req, resp);

    }
}
