<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hospital Management - Main Menu</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #c9d6ff, #e2e2e2);
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .menu-box {
            background-color: #ffffff;
            padding: 60px 50px;
            border-radius: 16px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 500px;
        }

        h1 {
            color: #2c3e50;
            margin-bottom: 30px;
        }

        .menu a {
            display: block;
            margin: 15px auto;
            padding: 15px;
            width: 85%;
            text-decoration: none;
            color: white;
            background-color: #3498db;
            border-radius: 10px;
            font-size: 17px;
            font-weight: bold;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        .menu a:hover {
            background-color: #2c80b4;
            transform: scale(1.05);
        }
    </style>
</head>
<body>

    <div class="menu-box">
        <h1>Welcome to Hospital Management System</h1>

        <div class="menu">
            <a href="DoctorMenu.jsf">👨‍⚕️ Doctor Menu</a>
            <a href="PatientMenu.jsf">🧑‍🤝‍🧑 Patient Menu</a>
            <a href="MedicalHistoryMenu.jsf">📋 Medical History Menu</a>
        </div>
    </div>

</body>
</html>
</f:view>
