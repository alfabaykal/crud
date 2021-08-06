<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Users</title>
</head>
<body>
<h2>All Users</h2>

<br>

<table>
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>E-Mail</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="user" items="${allUsers}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="userId" value="${user.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteUser">
            <c:param name="userId" value="${user.id}"/>
        </c:url>
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.age}</td>
            <td>${user.email}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href='${updateButton}'"/>
                <input type="button" value="Delete"
                       onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>

<br>

<input type="button" value="Add" onclick="window.location.href = 'addNewUser'"/>

</body>
</html>
