<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>
<h2>User Info</h2>

<form:form action="saveUser" method="post" modelAttribute="user">

    <form:hidden path="id"/>

    Id: ${user.id}
    <br><br>
    First Name <form:input path="firstName"/>
    <br><br>
    Last Name <form:input path="lastName"/>
    <br><br>
    Age <form:input path="age"/>
    <br><br>
    E-Mail <form:input path="email"/>
    <br><br>
    <input type="submit" value="Ok">

</form:form>
</body>
</html>
