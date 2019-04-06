<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
</head>
<body>
${message}
<br />
<table>
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.uname}"/></td>
                    <td><c:out value="${user.password}"/></td>
                    <td><c:out value="${user.faculty}"/></td>       
                </tr>
    </c:forEach>
    
</table>



</body>
</html>