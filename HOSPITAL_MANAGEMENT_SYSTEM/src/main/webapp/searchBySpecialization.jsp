<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Search Doctors by Specialization</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f8fc;
            margin: 0;
            padding: 0;
        }

        .navbar-container {
            margin-bottom: 20px;
        }

        .container {
            width: 600px;
            margin: auto;
            padding: 20px;
            background: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 8px;
        }

        .form-group {
            margin-bottom: 15px;
            text-align: left;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        select, input[type=submit] {
            padding: 8px;
            width: 100%;
            font-size: 16px;
        }

        h2 {
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ccc;
        }

        th, td {
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #e6f0ff;
        }
    </style>
</head>
<body>

    <!-- Navbar Section -->
    <div class="navbar-container">
        <jsp:include page="navbar.jsp" />
    </div>

    <!-- Main Content -->
    <div class="container">
        <h2>Search Doctors by Specialization</h2>

        <f:view>
            <h:form>
                <div class="form-group">
                    <h:outputLabel for="specialization" value="specialization" />
                    <h:selectOneMenu id="specialization" value="#{doctorController.specialization}">
                        <f:selectItem itemLabel="-- Select Specialization --" itemValue="" />
                        <f:selectItem itemLabel="HEART" itemValue="HEART" />
                        <f:selectItem itemLabel="SKIN" itemValue="SKIN" />
                        <f:selectItem itemLabel="GENERAL" itemValue="GENERAL" />
                        <f:selectItem itemLabel="KIDNEY" itemValue="KIDNEY" />
                    </h:selectOneMenu>
                </div>

                <div class="form-group">
                    <h:commandButton value="Search" action="#{doctorController.fetchDoctors}" />
                </div>

                <h:dataTable value="#{doctorController.doctorlist}" var="doctor" border="1">
                    <h:column>
                        <f:facet name="header">Doctor ID</f:facet>
                        <h:outputText value="#{doctor.doctorId}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">Name</f:facet>
                        <h:outputText value="#{doctor.doctorName}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">Specialization</f:facet>
                        <h:outputText value="#{doctor.specialization}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">Location</f:facet>
                        <h:outputText value="#{doctor.location}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">Mobile</f:facet>
                        <h:outputText value="#{doctor.mobileNo}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">Status</f:facet>
                        <h:outputText value="#{doctor.isStatus}" />
                    </h:column>
                </h:dataTable>
            </h:form>
        </f:view>
    </div>
</body>
</html>
