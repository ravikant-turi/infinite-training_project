<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Search Patient by ID</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef3f7;
            margin: 0;
            padding: 0;
        }

        .navbar-container {
            margin-bottom: 20px;
        }

        .container {
            width: 500px;
            margin: auto;
            background: #fff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"],
        input[type="submit"] {
            width: 100%;
            padding: 8px;
            font-size: 16px;
            margin-top: 5px;
        }

        .result {
            margin-top: 20px;
            background-color: #f1f8ff;
            padding: 15px;
            border-radius: 6px;
        }
    </style>
</head>
<body>

    <!-- Include navbar -->
    <div class="navbar-container">
        <jsp:include page="navbar.jsp" />
    </div>

    <div class="container">
        <h2>Search Patient by ID</h2>

        <f:view>
            <h:form>
                <div class="form-group">
                    <h:outputLabel for="patientId" value="Enter Patient ID:" />
                    <h:inputText id="patientId" value="#{patientController.patient.patientId}" />
               <h:messages globalOnly="true" layout="table" style="color: red;" />
               
                </div>

                <div class="form-group">
                    <h:commandButton value="Search" action="#{patientController.getPatientById(patientController.patient.patientId)}" />
                </div>

                <h:panelGroup rendered="#{not empty patientController.patient.patientName}">
                    <div class="result">
                        <p><strong>Name:</strong> <h:outputText value="#{patientController.patient.patientName}" /></p>
                        <p><strong>Doctor:</strong> <h:outputText value="#{patientController.patient.doctor.doctorName}" /></p>
                        <p><strong>Date of Birth:</strong> 
                            <h:outputText value="#{patientController.patient.dateOfBirth}">
                                <f:convertDateTime pattern="dd-MM-yyyy" />
                            </h:outputText>
                        </p>
                    </div>
                </h:panelGroup>
            </h:form>
        </f:view>
    </div>
</body>
</html>
