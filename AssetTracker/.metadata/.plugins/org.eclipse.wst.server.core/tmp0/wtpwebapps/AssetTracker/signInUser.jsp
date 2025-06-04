
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>suceess messag</title>
</head>

<body>

    <h:form>
        <h2>Login</h2>

        <h:outputLabel value="Name:" />
        <h:inputText value="#{userController.user.name}" required="true" requiredMessage="Name is required" />
        <h:message for="name" />

        <br/>

        <h:outputLabel value="Passcode:" />
        <h:inputText value="#{userController.user.passcode}" required="true" requiredMessage="Passcode is required" />
        <h:message for="passcode" />

        <br/><br/>

        <h:commandButton value="Sign In" action="#{userController.signIn}" />
        <h:messages globalOnly="true" layout="table"/>
    </h:form>


</body>
</html>
</f:view>
