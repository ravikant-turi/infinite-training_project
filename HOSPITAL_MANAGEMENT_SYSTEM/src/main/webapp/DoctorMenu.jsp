<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor Menu</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #eef2f7;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .menu-container {
            background-color: #ffffff;
            padding: 40px 60px;
            border-radius: 12px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.1);
            text-align: center;
        }

        h1 {
            color: #333;
            margin-bottom: 30px;
        }

        .menu a {
            display: inline-block;
            margin: 10px 20px;
            padding: 12px 24px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            font-weight: bold;
            border-radius: 8px;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        .menu a:hover {
            background-color: #218838;
            transform: translateY(-2px);
        }
    </style>
</head>
<body>



    <div class="menu-container">
        <h1>Doctor Menu</h1>
        <div class="menu">
            <a href="addDoctor.jsf">Add Doctor</a>
            <a href="doctorSearchById.jsf">Search Doctor</a>
             <a href="Doctorshow.jsf">Show Doctor</a>
             <a href="searchBySpecialization.jsf">Search Doctor By Category</a>
            
        </div>
    </div>

</body>
</html>
</f:view>
