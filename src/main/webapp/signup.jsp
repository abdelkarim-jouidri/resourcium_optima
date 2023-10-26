<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
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
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
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
<h2>Sign Up</h2>

<form action="signup" method="post">
    <label for="fname">First Name:</label>
    <input type="text" id="fname" name="fname" required><br>

    <label for="lname">Last Name:</label>
    <input type="text" id="lname" name="lname" required><br>

    <label for="email">Last Name:</label>
    <input type="email" id="email" name="email" required><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="pwd" required><br>

    <input type="submit" value="Sign Up">
</form>

<p>Already have an account? <a href="${pageContext.request.contextPath}/login">Sign In</a></p>
</body>
</html>
