package com.example.resourcium_optima_ii.Servlets.Reservation;

import com.example.resourcium_optima_ii.DAO.EmployeeDao;
import com.example.resourcium_optima_ii.DAO.EquipmentDao;
import com.example.resourcium_optima_ii.Model.Equipment;
import com.example.resourcium_optima_ii.Model.User;
import jakarta.jms.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/home/reservations/add")
public class AddReservationServelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/AddReservation.jsp").forward(req, resp);
    }


}
