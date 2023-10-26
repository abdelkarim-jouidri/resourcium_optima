<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@page language="java" contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>

<%@include file="header.jsp"%>
<div class="container">
    <%@include file="sideBar.jsp"%>
    <main>


        <section id="reservations" class="visible section-layout">
            <h2>Employees</h2>
            <div class="table-container">

                <table class="entity-table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Department</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- Sample data, replace with actual data from your database -->
                    <c:forEach var="employee" items="${employees}">
                        <tr>
                            <td>${employee.getId()}</td>
                            <td>${employee.getName()}</td>
                            <td>${employee.getDepartment().getName()}</td>
                        </tr>
                    </c:forEach>
                    <!-- Add more rows as needed -->
                    </tbody>
                </table>
            </div>
        </section>

    </main>
</div>

