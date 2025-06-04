<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<center>
<f:view>
  <h:form>
    <h1>All Assets</h1>

    <h:dataTable value="#{assetController.showAssetAll}" var="asset" border="1">
      
      <h:column>
        <f:facet name="header">
          <h:outputText value="Asset ID" />
        </f:facet>
        <h:outputText value="#{asset.id}" />
      </h:column>

      <h:column>
        <f:facet name="header">
          <h:outputText value="Name" />
        </f:facet>
        <h:outputText value="#{asset.name}" />
      </h:column>

      <h:column>
        <f:facet name="header">
          <h:outputText value="Quantity" />
        </f:facet>
        <h:outputText value="#{asset.quantity}" />
      </h:column>

    </h:dataTable>
  </h:form>
</f:view>
</center>