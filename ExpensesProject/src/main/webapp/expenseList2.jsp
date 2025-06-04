<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Expense Tracker - Group Wise</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-white text-gray-800 font-sans min-h-screen p-4">

    <div class="max-w-5xl mx-auto">
        <!-- Page Header -->
        <div class="bg-blue-700 text-white p-6 rounded shadow mb-6">
            <h1 class="text-4xl font-bold">Group Expense Tracker</h1>
            <p class="text-sm mt-2">View all daily expenses of your selected group</p>
        </div>

        <!-- Group ID Input Card -->
        <div class="bg-gray-50 border border-gray-200 rounded p-6 shadow mb-6">
            <h:form>
                <h3 class="text-xl font-semibold mb-4 text-gray-700">Step 1: Select Group</h3>
                <div class="mb-4">
                    <label for="groupId" class="block mb-1 text-sm font-medium text-gray-600">Group ID</label>
                    <h:inputText id="groupId" value="#{expenseController.groupId}" required="true"
                        styleClass="w-full border border-gray-300 rounded p-2" />
                </div>
                <h:commandButton value="Fetch Expenses"
                    action="#{expenseController.dailyExpensesListMethod}"
                    styleClass="bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700" />
            </h:form>
        </div>

        <!-- Expenses Table -->
        <div class="bg-white border border-gray-200 rounded p-6 shadow">
            <h3 class="text-xl font-semibold mb-4 text-gray-700">Step 2: Group Expenses</h3>

            <h:form>
                <h:dataTable
                    value="#{expenseController.dailyExpensesList}"
                    var="expense"
                    styleClass="w-full border-collapse"
                    headerClass="bg-gray-200 text-left p-2"
                    rowClasses="border-b border-gray-100 text-sm text-gray-700">

                    <h:column>
                        <f:facet name="header">ID</f:facet>
                        <h:outputText value="#{expense.expId}" />
                    </h:column>

                    <h:column>
                        <f:facet name="header">Description</f:facet>
                        <h:outputText value="#{expense.expenseDescription}" />
                    </h:column>

                    <h:column>
                        <f:facet name="header">₹ Amount</f:facet>
                        <h:outputText value="#{expense.amount}" />
                    </h:column>

                    <h:column>
                        <f:facet name="header">Date</f:facet>
                        <h:outputText value="#{expense.expenseDate}">
                            <f:convertDateTime pattern="yyyy-MM-dd" />
                        </h:outputText>
                    </h:column>

                    <h:column>
                        <f:facet name="header">Paid By (User ID)</f:facet>
                        <h:outputText value="#{expense.paidBy}" />
                    </h:column>
                </h:dataTable>
            </h:form>
        </div>
    </div>
</body>
</html>
</f:view>
