<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Medical History</title>
    <style>
        body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
        }

        .form-container {
            background-color: #ffffff;
            padding: 20px;
            margin: 40px auto;
            width: 400px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .form-container label,
        .form-container input {
            display: block;
            margin-bottom: 15px;
        }

        .form-container input {
            width: 100%;
            padding: 6px;
        }

        .form-container h\\:commandButton {
            margin-top: 10px;
        }

        .navbar-space {
            margin-bottom: 120px;
            text-align: center;
        }
    </style>
</head>
<body>

    <div class="navbar-space">
        <jsp:include page="navbar.jsp" />
    </div>

    <div class="form-container">
        <h:form>

            <h:outputLabel for="tests" value="Tests:" />
            <h:inputText id="tests" value="#{medicationHistoryController.medicationHistory.tests}" />

            <h:outputLabel for="medicines" value="Medicines:" />
            <h:inputText id="medicines" value="#{medicationHistoryController.medicationHistory.medicines}" />

            <h:outputLabel for="medId" value="Med ID:" />
            <h:inputText id="medId" value="#{medicationHistoryController.medicationHistory.medId}" />

            <h:commandButton value="Add Medical History"
                             action="#{medicationHistoryController.addMedicalHistoryController}" />

        </h:form>
    </div>

</body>
</html>
</f:view>
