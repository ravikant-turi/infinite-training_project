
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<center>
<f:view>
  <h:form>
    <h2>Add New Asset</h2>

    <h:panelGrid columns="2" cellpadding="6" style="margin-top: 15px;">


      <!-- Asset Name -->
      <h:outputLabel value="Asset Name:" for="name" />
      <h:inputText id="name" value="#{assetController.asset.name}" required="true" />

      <!-- Asset Quantity -->
      <h:outputLabel value="Quantity:" for="qty" />
      <h:inputText id="qty" value="#{assetController.asset.quantity}" required="true">
        <f:validateLongRange minimum="1" />
      </h:inputText>

      <!-- Submit Button -->
      <h:outputText />
      <h:commandButton value="Add Asset" action="#{assetController.addAllAsset}" />

    </h:panelGrid>
  </h:form>
</f:view>
</center>
