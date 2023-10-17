<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 10/17/2023
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Sign In</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
      padding: 20px;
      text-align: center;
    }

    h2 {
      color: #333;
    }

    form {
      margin: 0 auto; /* Center the form */
      max-width: 400px; /* Limit the width for better readability */
      text-align: left; /* Align form elements to the left within the centered form */
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }

    label {
      display: block;
      margin-bottom: 5px;
      color: #333;
    }

    input {
      width: 100%;
      padding: 8px;
      margin-bottom: 10px;
      box-sizing: border-box; /* Ensure padding and border are included in the width */
    }

    input[type="submit"] {
      background-color: #007BFF;
      color: white;
      cursor: pointer;
    }

    p {
      margin-top: 10px;
      color: #555;
    }

    a {
      color: #4CAF50;
      text-decoration: none;
    }
  </style>
</head>
<body>
<h2>Sign In</h2>

<form action="signin" method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required><br>

  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br>

  <input type="submit" value="Sign In">
</form>

<p>Don't have an account? <a href="${pageContext.request.contextPath}/signup">Sign Up</a></p>
</body>
</html>
