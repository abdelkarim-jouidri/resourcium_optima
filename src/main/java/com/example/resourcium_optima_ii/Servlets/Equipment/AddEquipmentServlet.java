package com.example.resourcium_optima_ii.Servlets.Equipment;

import com.example.resourcium_optima_ii.DAO.DepartmentDao;
import com.example.resourcium_optima_ii.DAO.EmployeeDao;
import com.example.resourcium_optima_ii.DAO.EquipmentDao;
import com.example.resourcium_optima_ii.Model.Department;
import com.example.resourcium_optima_ii.Model.Employee;
import com.example.resourcium_optima_ii.Model.Equipment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/home/equipments/add")
public class AddEquipmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/AddEquipment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String availability = req.getParameter("availability");
        String type = req.getParameter("type");
        //constructing the equipment object
        EquipmentDao equipmentDao = new EquipmentDao();
        Equipment equipment = new Equipment();
        equipment.setAvailability(availability);
        equipment.setName(name);
        equipment.setType(type);

        if(equipmentDao.save(equipment) == true){
            System.out.println("successfully added");
            req.setAttribute("successMessage", "The new equipment has been added successfully");
        }
        else {
            System.out.println("Error while trying to add the equipment");
            req.getSession().setAttribute("errorMessage", "something went wrong !!");
        }
        req.getRequestDispatcher("/AddEquipment.jsp").forward(req, resp);
    }
}
