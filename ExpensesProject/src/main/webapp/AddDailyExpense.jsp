<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Daily Expense</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen text-gray-800">
    <div class="max-w-xl mx-auto mt-10 bg-white p-6 rounded shadow">

        <!-- Form Header -->
        <h2 class="text-2xl font-bold mb-4 text-blue-700">Add Daily Expense</h2>

        <h:form prependId="false">

            <!-- Group ID -->
            <div class="mb-4">
                <h:outputLabel for="groupId" value="Group ID" styleClass="block text-sm font-medium mb-1" />
                <h:inputText id="groupId" value="#{dailyExpenses.groupId}"
                             styleClass="w-full border border-gray-300 p-2 rounded" />
            </div>

            <!-- Expense Date -->
            <div class="mb-4">
                <h:outputLabel for="expenseDate" value="Expense Date" styleClass="block text-sm font-medium mb-1" />
                <h:inputText id="expenseDate" value="#{dailyExpenses.expenseDate}"
                             styleClass="w-full border border-gray-300 p-2 rounded">
                    <f:convertDateTime pattern="yyyy-MM-dd" />
                </h:inputText>
            </div>

            <!-- Description -->
            <div class="mb-4">
                <h:outputLabel for="expenseDescription" value="Description" styleClass="block text-sm font-medium mb-1" />
                <h:inputText id="expenseDescription" value="#{dailyExpenses.expenseDescription}"
                             styleClass="w-full border border-gray-300 p-2 rounded" />
            </div>

            <!-- Paid By -->
            <div class="mb-4">
                <h:outputLabel for="paidBy" value="Paid By (User ID)" styleClass="block text-sm font-medium mb-1" />
                <h:inputText id="paidBy" value="#{dailyExpenses.paidBy}"
                             styleClass="w-full border border-gray-300 p-2 rounded" />
            </div>

            <!-- Amount -->
            <div class="mb-6">
                <h:outputLabel for="amount" value="Amount (₹)" styleClass="block text-sm font-medium mb-1" />
                <h:inputText id="amount" value="#{dailyExpenses.amount}"
                             styleClass="w-full border border-gray-300 p-2 rounded" />
            </div>

            <!-- Submit Button -->
            <h:commandButton action="#{userDao.addDailyExpenses(dailyExpenses)}"
                             value="Add Expense"
                             styleClass="bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700" />

        </h:form>
    </div>
</body>
</html>
</f:view>
