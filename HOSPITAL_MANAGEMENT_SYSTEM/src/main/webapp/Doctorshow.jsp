<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Show Doctors</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            background-color: #f4f8fc;
        }

        .content-wrapper {
            margin-top: 100px; /* Space for fixed navbar */
            padding: 20px 50px;
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: auto;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        td {
            background-color: #fff;
        }
    </style>
</head>
<body>
    <jsp:include page="navbar.jsp" />

    <div class="content-wrapper">
        <h:form>
            <h2><h:outputText value="Doctor Records" /></h2>

            <h:dataTable value="#{doctorController.showDoctorcontroler()}" var="doc"
                         border="1" cellpadding="5" cellspacing="0">

                <h:column>
                    <f:facet name="header"><h:outputLabel value="Doctor ID" /></f:facet>
                    <h:outputText value="#{doc.doctorId}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputLabel value="Doctor Name" /></f:facet>
                    <h:outputText value="#{doc.doctorName}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputLabel value="Specialization" /></f:facet>
                    <h:outputText value="#{doc.specialization}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputLabel value="Location" /></f:facet>
                    <h:outputText value="#{doc.location}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputLabel value="Mobile No" /></f:facet>
                    <h:outputText value="#{doc.mobileNo}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputLabel value="Status" /></f:facet>
                    <h:outputText value="#{doc.isStatus}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputLabel value="Actions" /></f:facet>
                    <h:commandButton value="Search Doctor"
                                     action="#{doctorController.searchDoctor(doc.doctorId)}" />
                </h:column>

            </h:dataTable>
        </h:form>
    </div>
</body>
</html>
</f:view>
