<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        .navbar-container {
    margin-bottom: 110px; /* Increased from 20px to 40px */
}
        

        .navbar {
            background-color: #007bff;
            overflow: hidden;
            display: flex;
            justify-content: center;
            padding: 12px 0;
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            width: 100%;
            z-index: 1000;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .navbar a {
            color: white;
            padding: 12px 24px;
            text-decoration: none;
            font-weight: bold;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .navbar a:hover {
            background-color: #0056b3;
            border-radius: 6px;
        }
    </style>

    <div class="navbar">
        <a href="MainMenu.jsf">🏠 Home</a>
        <a href="DoctorMenu.jsf">👨‍⚕️ Doctor Menu</a>
        <a href="PatientMenu.jsf">🧑‍🤝‍🧑 Patient Menu</a>
        <a href="MedicalHistoryMenu.jsf">📋 Medical History Menu</a>
    </div>
</f:view>
