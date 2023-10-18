<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 10/18/2023
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to the Home Page</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <h1>Welcome to the Home Page</h1>
    <h3 style="color: #7ba7dc; display: inline-block">Credentials : </h3>
    <p>email : ${requestScope.homePageMessage}</p>
</div>
</body>
</html>
