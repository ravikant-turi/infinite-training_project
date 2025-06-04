<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Doctor</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 0;
        }

        .navbar-space {
            background-color: #004080;
            color: white;
            padding: 70px;
        }

        .content-with-navbar {
            padding: 30px 40px;
        }

        h2 {
            color: #2c3e50;
            text-align: center;
        }

        .form-container {
            width: 400px;
            margin: 0 auto;
            text-align: center;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        .form-group {
            margin-bottom: 20px;
            text-align: left;
        }

        label, input {
            display: block;
            width: 100%;
            margin-top: 10px;
        }

        input[type="text"] {
            padding: 8px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .button-center {
            text-align: center;
            margin-top: 20px;
        }

        .styled-button {
            background-color: #007bff;
            color: white;
            padding: 10px 30px;
            font-size: 16px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }

        .styled-button:hover {
            background-color: #0056b3;
        }

        table {
            margin-top: 30px;
            width: 90%;
            margin-left: auto;
            margin-right: auto;
            border-collapse: collapse;
            background-color: white;
        }

        th, td {
            padding: 10px;
            border: 1px solid #999;
            text-align: center;
        }

        th {
            background-color: #0073e6;
            color: white;
        }
    </style>
</head>
<body>

    <!-- Include navbar -->
    <div class="navbar-space">
        <jsp:include page="navbar.jsp" />
    </div>

    <div class="content-with-navbar">
        <h2>Search Doctor by ID</h2>

        <h:form>
            <div class="form-container">
                <div class="form-group">
                    <h:outputLabel for="doctorId" value="Doctor ID:" />
                    <h:inputText id="doctorId" value="#{doctorController.doctorId}" />
                </div>

                <div class="button-center">
                    <h:commandButton value="Search"
                                     action="#{doctorController.getDoctorById}"
                                     styleClass="styled-button" />
                </div>

                <h:messages globalOnly="true" layout="table" style="color: red; margin-top: 15px;" />
            </div>

            <!-- Table only shows if doctor found -->
            <h:dataTable value="#{doctorController.doctor}" var="doctor"
                         border="1" cellpadding="5" cellspacing="0"
                         rendered="#{doctorController.doctor != null}">

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Doctor ID" />
                    </f:facet>
                    <h:outputText value="#{doctor.doctorId}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Doctor Name" />
                    </f:facet>
                    <h:outputText value="#{doctor.doctorName}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Specialization" />
                    </f:facet>
                    <h:outputText value="#{doctor.specialization}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Location" />
                    </f:facet>
                    <h:outputText value="#{doctor.location}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Mobile No" />
                    </f:facet>
                    <h:outputText value="#{doctor.mobileNo}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Status" />
                    </f:facet>
                    <h:outputText value="#{doctor.isStatus}" />
                </h:column>
            </h:dataTable>
        </h:form>
    </div>

</body>
</html>
</f:view>
