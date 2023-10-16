<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Sign Up Success</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
      padding: 20px;
      text-align: center;
    }

    h2 {
      color: #4CAF50;
    }

    p {
      margin-top: 10px;
      color: #555;
    }

    a {
      color: #007BFF;
      text-decoration: none;
    }
  </style>
</head>
<body>
<h2>Sign Up Successful!</h2>

<p>Congratulations, your account has been created successfully.</p>

<p>Go to <a href="${pageContext.request.contextPath}/signin">Sign In</a> page.</p>
</body>
</html>
