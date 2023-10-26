
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
  <style>
    body {
      font-family: Arial, sans-serif;
    }

    .active {
      background: #f2f2f2;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }

    th, td {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
    }

    th {
      background-color: #f2f2f2;
    }



    .entity-table th, .entity-table td {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
    }

    .entity-table th {
      background-color: #f2f2f2;
    }

    body {
      max-width: 100%;
      overflow-x: hidden; /* This hides horizontal scroll */
      font-family: 'Arial', sans-serif;
      background-color: #fefefe;
      margin: 0;
      padding: 0;
      display: flex;
      flex-direction: column;
    }

    header {
      background-color: #ffffff;
      color: white;
      text-align: center;
      padding: 10px;
      width: 100%;
      border-bottom: solid 1px #e2e2e2;
      display: flex;
      justify-content: space-between;
      align-items: center;

    }

    .container {
      display: flex;
    }

    nav {
      background-color: #ffffff;
      color: #797979;
      padding: 10px;
      text-align: center;
      border-right: solid 1px #e2e2e2;
      width: 200px; /* Set the width of the sidebar */
      min-height: 100vh; /* Make the sidebar full height */
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      gap: 10px;
    }

    nav ul {
      list-style: none;
      padding: 0;
      margin: 0;
    }

    nav ul li {
      margin-bottom: 15px;
    }

    nav ul li a {
      color: white;
      text-decoration: none;
      cursor: pointer;
    }

    nav ul li a:hover {
      text-decoration: underline;
    }

    main {
      margin: 20px;
      width: 100%;
    }

    .section-layout {
      margin-bottom: 20px;
      width: calc(100% - 200px); /* Adjust the width of the content area */
      display: flex;
      justify-content: center;
    }

    .visible {
      display: block;
    }

    .hidden {
      display: none;
    }

    .logout-btn {
      margin-top: 10px;
    }
  </style>

</head>
<body>

<header>
  <img style="width: 200px ; margin-left: 20px" src="utils/pictures/Logo.png" alt="">
  <h2 style="color: #797979; margin: 0">Dashboard</h2>
  <button style="color: black ; width: 80px; border-radius: 10%; border: 0px ; margin-right: 10px ; height: 30px; cursor: pointer " class="logout-btn" onclick="logout()">Logout</button>

</header>