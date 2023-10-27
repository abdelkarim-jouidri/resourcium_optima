package com.example.resourcium_optima_ii.Servlets.Reservation;

import com.example.resourcium_optima_ii.DAO.EquipmentDao;
import com.example.resourcium_optima_ii.DAO.ReservationDao;
import com.example.resourcium_optima_ii.Model.Equipment;
import com.example.resourcium_optima_ii.Model.Reservation;
import com.example.resourcium_optima_ii.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/home/allocations/add")
public class AddAllocationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EquipmentDao equipmentDao = new EquipmentDao();
        List<Equipment> equipments = equipmentDao.getAllEquipments();
        req.setAttribute("equipments", equipments);
        req.getRequestDispatcher("/MakeAllocation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ReservationDao reservationDao = new ReservationDao();
        int equipmentId = Integer.parseInt(req.getParameter("equipmentId"));
        String returnDate = req.getParameter("returnDate");
        String name = req.getParameter("name");
        User currentUser = (User) session.getAttribute("loggedInUser");

        EquipmentDao equipmentDao = new EquipmentDao();
        Equipment equipment = equipmentDao.getEquipmentById(equipmentId);
        System.out.println("date : "+ returnDate+" \ncurrent user : "+ currentUser);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localReturnDate = LocalDate.parse(returnDate, formatter1);
        Reservation reservation = new Reservation();
        reservation.setReturnDate(localReturnDate);
        reservation.setName(name);
        reservation.setEquipment(equipment);
        reservation.setReservationType();
        reservation.setReservationDate(LocalDate.now());
        reservation.setUser(currentUser);
        reservationDao.save(reservation);
        req.setAttribute("reservations", reservationDao.getAllReservations());
        req.getRequestDispatcher("/Reservations.jsp").forward(req,resp);
    }
}
