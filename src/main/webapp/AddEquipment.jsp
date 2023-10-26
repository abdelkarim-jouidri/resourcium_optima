<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@page language="java" contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>

<%@include file="header.jsp"%>
<style>
  body {
    font-family: 'Arial', sans-serif;
    margin: 20px;
  }

  h2 {
    color: #333;
  }

  form {
    max-width: 400px;
    margin: auto;
  }

  label {
    display: block;
    margin-bottom: 8px;
    color: #555;
  }

  input, select {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
  }

  input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }

  input[type="submit"]:hover {
    background-color: #45a049;
  }
</style>
<div class="container">
  <%@include file="sideBar.jsp"%>
  <main>


    <section id="equipments" class="visible section-layout">
      <h2>Add Equipment</h2>
      <c:if test="${not empty requestScope.successMessage}">
        <div style="color: green; background: #dbe7db; text-align: center; width: 100%; padding: 10px; margin-bottom: 5px">
            ${requestScope.successMessage}
        </div>
      </c:if>
      <c:if test="${not empty requestScope.errorMessage}">
        <div style="color: red; background: #ecdada; text-align: center; width: 100%; padding: 10px; margin-bottom: 5px">
            ${requestScope.errorMessage}
        </div>
      </c:if>
      <form action="${pageContext.request.contextPath}/home/equipments/add" method="post">
      <label>Availability:</label>
      <select name="availability" required>
        <option value="AVAILABLE">AVAILABLE</option>
        <option value="IN_USE">IN USE</option>
      </select>
      <br>

      <label >Name:</label>
      <input type="text" name="name" required>
      <br>

      <label >Type:</label>
      <select name="type" required>
        <option value="JETABLE">JETABLE</option>
        <option value="NON_JETABLE">NON JETABLE</option>
      </select>
      <br>

      <input type="submit" value="Add Equipment">
    </form>
    </section>

  </main>
</div>

