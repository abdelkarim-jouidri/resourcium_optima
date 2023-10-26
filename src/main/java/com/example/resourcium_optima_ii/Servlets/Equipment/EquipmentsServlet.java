package com.example.resourcium_optima_ii.Servlets.Equipment;

import com.example.resourcium_optima_ii.DAO.EquipmentDao;
import com.example.resourcium_optima_ii.Model.Equipment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home/equipments")
public class EquipmentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("inside the do get equipments");
        EquipmentDao equipmentDao = new EquipmentDao();
        List<Equipment> equipments = equipmentDao.getAllEquipments();
        req.setAttribute("equipments", equipments);
        req.getRequestDispatcher("/Equipments.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
