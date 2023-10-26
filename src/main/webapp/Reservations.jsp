<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@page language="java" contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>

<%@include file="header.jsp"%>
<div class="container">
  <%@include file="sideBar.jsp"%>
  <main>


    <section id="reservations" class="visible section-layout">
      <h2>Reservations</h2>
      <div class="table-container">

        <table class="entity-table">
          <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Reservation Date</th>
            <th>Reservation Type</th>
            <th>Equipment</th>
            <th>Made By</th>
            <th>Actions</th>
          </tr>
          </thead>
          <tbody>
          <!-- Sample data, replace with actual data from your database -->
          <c:forEach var="reservation" items="${reservations}">
            <tr>
              <td>${reservation.getId()}</td>
              <td>${reservation.getName()}</td>
              <td>${reservation.getReservationDate()}</td>
              <td>${reservation.getReservationType()}</td>
              <td>${reservation.getEquipment().getName()}</td>
              <td>${reservation.getUser().getFirstName()}</td>
              <td>
                <form action="${pageContext.request.contextPath}/home/reservations/update" method="post" style="display: inline;">
                  <input type="hidden" value="update" name="action">
                  <input type="hidden" name="employeeId" value="${reservation.getId()}">
                  <button type="submit">Update</button>
                </form>

                <form action="${pageContext.request.contextPath}/home/reservations/delete" method="post" style="display: inline;">
                  <input type="hidden" name="employeeId" value="${reservation.getId()}">
                  <input type="hidden" value="delete" name="action">
                  <button type="submit">Delete</button>
                </form>
              </td>
            </tr>
          </c:forEach>
          <!-- Add more rows as needed -->
          </tbody>
        </table>
      </div>
    </section>

  </main>
</div>

