<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Sign In</title>
</head>
<body>

<h:form>
    <h2>Admin Sign In</h2>

    <h:outputLabel value="Name:" />
    <h:inputText value="#{adminController.admin.name}" required="true" requiredMessage="Name is required" />
    <h:message for="name" />

    <br/>

    <h:outputLabel value="Passcode:" />
    <h:inputSecret value="#{adminController.admin.passcode}" required="true" requiredMessage="Passcode is required" />
    <h:message for="passcode" />

    <br/><br/>

    <h:commandButton value="Sign In" action="#{adminController.signIn}" />
    <h:messages globalOnly="true" layout="table" />
</h:form>

</body>
</html>
</f:view>
