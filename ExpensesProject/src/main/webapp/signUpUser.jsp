<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
</head>

<body>

    <h:form>
        <h2>Sign Up</h2>

        <h:outputLabel value="Name:" />
        <h:inputText value="#{loginController.login.name}" required="true" requiredMessage="Name is required" />
        <h:message for="name" />

        <br/>

        <h:outputLabel value="Email:" />
        <h:inputText value="#{loginController.login.email}" required="true" requiredMessage="Email is required" />
        <h:message for="email" />

        <br/>

        <h:outputLabel value="Passcode:" />
        <h:inputText value="#{loginController.login.passcode}" required="true" requiredMessage="Passcode is required" />
        <h:message for="passcode" />

        <br/><br/>

        <h:commandButton value="Sign Up" action="#{loginController.signUp}" />
        <h:messages globalOnly="true" layout="table" />
    </h:form>

</body>
</html>
</f:view>
