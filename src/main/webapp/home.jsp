<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Dashboard</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        header {
            background-color: #1a1a1a;
            color: white;
            text-align: center;
            padding: 10px;
            width: 100%;
        }

        nav {
            background-color: #222;
            color: white;
            padding: 10px;
            text-align: center;
            width: 100%;
        }

        nav ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        nav ul li {
            display: inline;
            margin-right: 15px;
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
            width: 100%;
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
    <h1>Your Dashboard</h1>
</header>

<nav>
    <ul>
        <li><a onclick="showContent('reservations')">Reservations</a></li>
        <li><a onclick="showContent('reservationList')">List of Reservations</a></li>
        <li><a onclick="showContent('employeeList')">List of Employees</a></li>
    </ul>
    <!-- Logout button in the header -->
    <button class="logout-btn" onclick="logout()">Logout</button>
</nav>

<main>
    <section id="reservations" class="visible section-layout">
        <h2>Reservations</h2>
        <!-- Add content related to reservations here -->
    </section>

    <section id="reservationList" class="hidden section-layout">
        <h2>List of Reservations</h2>
        <!-- Add content related to the list of reservations here -->
    </section>

    <section id="employeeList" class="hidden section-layout">
        <h2>List of Employees</h2>
        <!-- Add content related to the list of employees here -->
    </section>
</main>

<script>
    function showContent(contentId) {
        var sections = document.querySelectorAll('main section');
        sections.forEach(function(section) {
            section.classList.add('hidden');
        });

        var selectedSection = document.getElementById(contentId);
        if (selectedSection) {
            selectedSection.classList.add('visible');
            selectedSection.classList.remove('hidden');
        }
    }

    function logout() {
        // Replace this with your actual logout logic (e.g., redirect to a logout servlet)
        alert('Logout clicked. Add your logout logic here.');
    }
</script>

</body>
</html>
