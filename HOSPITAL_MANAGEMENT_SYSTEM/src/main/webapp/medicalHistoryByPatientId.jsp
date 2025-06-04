<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Medical History</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        .navbar-space {
            background-color: #004080;
            padding: 10px;
            color: white;
        }

        h2 {
            color: #004080;
            margin-top: 20px;
        }

        .form-group {
            margin: 20px auto;
            width: 300px;
            text-align: left;
        }

        label, input {
            display: block;
            width: 100%;
            margin-bottom: 10px;
        }

        input[type="text"] {
            padding: 8px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-group h\\:commandButton {
            margin-top: 10px;
        }

        table {
            margin: 20px auto;
            border-collapse: collapse;
            width: 80%;
            background-color: white;
        }

        th, td {
            border: 1px solid #999;
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #0073e6;
            color: white;
        }
    </style>
</head>
<body>

    <div class="navbar-space">
        <jsp:include page="navbar.jsp" />
    </div>

    <f:view>
        <h2>Search Patient Medical History by ID</h2>

        <h:form>
            <div class="form-group">
                <h:outputLabel for="patientId" value="Patient ID" />
                <h:inputText id="patientId" value="#{medicationHistoryController.patientId}" />
                <h:commandButton value="Search"
                    action="#{medicationHistoryController.getPatientMedicalHistoryByPatientIdController}" />
            </div>

            <h:dataTable value="#{medicationHistoryController.medicationHistoryList}" var="medical" border="1">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Medication ID" />
                    </f:facet>
                    <h:outputText value="#{medical.medId}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Medicines" />
                    </f:facet>
                    <h:outputText value="#{medical.medicines}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Tests" />
                    </f:facet>
                    <h:outputText value="#{medical.tests}" />
                </h:column>
            </h:dataTable>
        </h:form>
    </f:view>
</body>
</html>
