
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<center>
	<f:view>
		<html>
		<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div class="navbar-container">
        <jsp:include page="navbar.jsp" />
    </div>
            
            <h:form>
                <div class="form-group">
                    <h:outputLabel for="doctorId" value="doctorId" />
                    <h:inputText id="doctorId" value="#{doctorController.doctor.doctorId}" />
                    <h:commandButton value="Search" action="#{patientController.showPatientsByDoctorId(patientController.doctor.doctorId)}" />
                </div>

                <!-- Data Table to show list of doctors -->
                <h:dataTable value="#{patientController.patientsByDoctor}" var="patient" border="3">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Doctor Name" />
                        </f:facet>
                        <h:outputText value="#{patient.patientName}" />
                    </h:column>

                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="dateOfBirth" />
                        </f:facet>
                        <h:outputText value="#{patient.dateOfBirth}" />
                    </h:column>

                    
                </h:dataTable>
                
                </h:form>
               

</body>
		</html>

	</f:view>
</center>