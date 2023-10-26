<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<style>
  body {
    font-family: 'Arial', sans-serif;
    margin: 20px;
  }

  .container {
    display: flex;
    justify-content: space-between;
    margin-top: 20px;
  }

  main {
    flex: 1;
    padding: 20px;
  }

  h2 {
    color: #333;
  }

  form {
    max-width: 400px;
    margin: auto;
    background-color: #f4f4f4;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }

  label {
    display: block;
    margin-bottom: 8px;
    color: #555;
  }

  select,
  input {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
  }

  input[type="date"] {
    /* Adjust styles for date input if needed */
  }

  input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
  }

  input[type="submit"]:hover {
    background-color: #45a049;
  }
</style>

<div class="container">
  <%@ include file="sideBar.jsp" %>
  <main>
    <section id="reservations" class="visible section-layout">
      <h2>Add Reservation</h2>
      <c:if test="${not empty requestScope.successMessage}">
        <div class="success-message">
            ${requestScope.successMessage}
        </div>
      </c:if>
      <c:if test="${not empty requestScope.errorMessage}">
        <div class="error-message">
            ${requestScope.errorMessage}
        </div>
      </c:if>
      <form action="${pageContext.request.contextPath}/home/reservations/add" method="post">

        <label for="equipmentId">Equipment:</label>
        <select id="equipmentId" name="equipmentId" required>
          <c:forEach var="employee" items="${employees}">
            <option value="${employee.id}">${employee.name}</option>
          </c:forEach>
        </select>

        <label for="returnDate">Due Date:</label>
        <input type="date" id="returnDate" name="returnDate">

        <label for="name">Description:</label>
        <input type="text" id="name" name="name" required>

        <input type="submit" value="Assign Task">
      </form>
    </section>
  </main>
</div>
