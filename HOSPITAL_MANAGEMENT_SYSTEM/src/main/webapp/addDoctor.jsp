<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Doctor</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 0;
        }

        .content-wrapper {
            margin-top: 100px; /* space below fixed navbar */
            padding: 40px;
            display: flex;
            justify-content: center;
        }

        .form-container {
            background: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
            width: 500px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 6px;
        }

        input, select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }

        .submit-button {
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>

    <jsp:include page="navbar.jsp" />

    <div class="content-wrapper">
        <div class="form-container">
            <h2>Add Doctor</h2>

            <h:form>
                <div class="form-group">
                    <h:outputLabel for="doctorName" value="Doctor Name" />
                    <h:inputText id="doctorName" value="#{doctor.doctorName}" />
                </div>

                <div class="form-group">
                    <h:outputLabel for="specialization" value="Specialization" />
                    <h:selectOneMenu id="specialization" value="#{doctor.specialization}">
                        <f:selectItem itemLabel="--Select--" itemValue="" />
                        <f:selectItem itemLabel="HEART" itemValue="HEART" />
                        <f:selectItem itemLabel="SKIN" itemValue="SKIN" />
                        <f:selectItem itemLabel="GENERAL" itemValue="GENERAL" />
                        <f:selectItem itemLabel="KIDNEY" itemValue="KIDNEY" />
                    </h:selectOneMenu>
                </div>

                <div class="form-group">
                    <h:outputLabel for="location" value="Location" />
                    <h:inputText id="location" value="#{doctor.location}" />
                </div>

                <div class="form-group">
                    <h:outputLabel for="mobileNo" value="Mobile No" />
                    <h:inputText id="mobileNo" value="#{doctor.mobileNo}" />
                </div>

                <div class="form-group">
                    <h:outputLabel for="isStatus" value="Status" />
                    <h:selectOneMenu id="isStatus" value="#{doctor.isStatus}">
                        <f:selectItem itemLabel="--Select--" itemValue="" />
                        <f:selectItem itemLabel="ACTIVE" itemValue="ACTIVE" />
                        <f:selectItem itemLabel="INACTIVE" itemValue="INACTIVE" />
                    </h:selectOneMenu>
                </div>

                <div class="submit-button">
                    <h:commandButton value="Add Doctor" action="#{doctorController.addDoctors(doctor)}" />
                </div>
            </h:form>
        </div>
    </div>

</body>
</html>
</f:view>
