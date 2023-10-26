<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
<div class="container">
    <%@include file="sideBar.jsp"%>
    <main>
        <section id="reservations" class="visible section-layout">
            <h2>Employees</h2>
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
            <div class="table-container">
                <table class="entity-table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Department</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="employee" items="${employees}">
                        <tr>
                            <td>${employee.getId()}</td>
                            <td>${employee.getName()}</td>
                            <td>${employee.getDepartment().getName()}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/home/employees/add" method="post" style="display: inline;">
                                    <input type="hidden" value="update" name="action">
                                    <input type="hidden" name="employeeId" value="${employee.getId()}">
                                    <button type="submit">Update</button>
                                </form>

                                <form action="${pageContext.request.contextPath}/home/employees/delete" method="post" style="display: inline;">
                                    <input type="hidden" name="employeeId" value="${employee.getId()}">
                                    <input type="hidden" value="delete" name="action">
                                    <button type="submit">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>
    </main>
</div>
