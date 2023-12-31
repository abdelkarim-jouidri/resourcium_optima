package com.example.resourcium_optima_ii.Servlets.Reservation;

import com.example.resourcium_optima_ii.DAO.ReservationDao;
import com.example.resourcium_optima_ii.Model.Reservation;
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
        ReservationDao reservationDao = new ReservationDao();
        List<Reservation> reservations = reservationDao.getAllReservations();
        req.setAttribute("reservations", reservations);
        req.getRequestDispatcher("/Reservations.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
