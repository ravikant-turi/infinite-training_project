<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 

<f:view>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add User</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center">

    <div class="bg-white p-8 rounded shadow-md w-full max-w-md">
        <h2 class="text-2xl font-bold mb-6 text-blue-700 text-center">Add New User</h2>

        <h:form prependId="false">

            <!-- User Name -->
            <div class="mb-4">
                <h:outputLabel for="userName" value="User Name" styleClass="block text-sm font-medium mb-1" />
                <h:inputText id="userName" value="#{users.userName}" 
                             styleClass="w-full border border-gray-300 p-2 rounded" />
            </div>

            <!-- User Email -->
            <div class="mb-4">
                <h:outputLabel for="email" value="User Email" styleClass="block text-sm font-medium mb-1" />
                <h:inputText id="email" value="#{users.email}" 
                             styleClass="w-full border border-gray-300 p-2 rounded" />
                <h:message for="email" styleClass="text-red-500 text-sm mt-1 block" />
            </div>

            <!-- Submit Button -->
            <div class="text-center mt-6">
                <h:commandButton action="#{userDao.addUserDao(users)}" value="Add User"
                                 styleClass="bg-green-600 text-white px-6 py-2 rounded hover:bg-green-700" />
            </div>

        </h:form>
    </div>

</body>
</html>
</f:view>
