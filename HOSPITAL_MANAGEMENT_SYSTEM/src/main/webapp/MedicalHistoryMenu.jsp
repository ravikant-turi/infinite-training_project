<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Medical History Menu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            margin-top: 100px;
        }

        h1 {
            color: #333;
            margin-bottom: 40px;
        }

        .menu a {
            display: inline-block;
            margin: 0 15px;
            padding: 12px 20px;
            text-decoration: none;
            color: white;
            background-color: #007bff;
            border-radius: 6px;
            transition: background-color 0.3s;
        }

        .menu a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <h1>Medical History Menu</h1>

    <div class="menu">
        <a href="medicalHistoryByPatientId.jsf">Show Patient Medical History</a>
        <a href="medicalHistoryByPatientId.jsf">Show Medication History</a>
        <a href="addMedicalHistory.jsf">Add Medication History</a>
    </div>

</body>
</html>
</f:view>
