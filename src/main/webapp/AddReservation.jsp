<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<style>
  body {
    font-family: 'Arial', sans-serif;
    margin: 20px;
  }

  h2 {
    color: #333;
  }

  .options-container {
    display: flex;
    justify-content: space-around;
    margin-top: 20px;
  }

  .option-button {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
    text-decoration: none; /* Remove default anchor underline */
    display: inline-block; /* Ensures the button styles are applied */
  }

  .option-button:hover {
    background-color: #45a049;
  }
</style>

<div class="container">
  <%@ include file="sideBar.jsp" %>
  <main>
    <section id="reservations" class="visible section-layout">
      <h2>Select an Option</h2>
      <div class="options-container">
        <a href="${pageContext.request.contextPath}/home/allocations/add" class="option-button">
          Make an Allocation
        </a>
        <a href="${pageContext.request.contextPath}/assignTask" class="option-button">
          Assign a Task
        </a>
      </div>
    </section>
  </main>
</div>
