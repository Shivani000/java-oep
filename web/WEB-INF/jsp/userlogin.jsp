<%-- 
    Document   : userlogin
    Created on : 9 May, 2017, 6:56:41 PM
    Author     : mrvataliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login to System</h1>
        
<form:form method="POST" commandName="useroep">
    <table style="align-content: center;margin-left: 200px">
		<tr>
			<td>User Name :</td>
			<td><form:input path="uname" /></td>
                        
		</tr>
                <tr>
			<td>Password :</td>
			<td><form:password path="password" /></td>
		</tr>
                <tr>
			<td>Faculty :</td>
			<td><form:radiobutton path="faculty" value="true" label="Faculty" /> 
                            <form:radiobutton path="faculty" value="false" label="Student" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Login" /></td>
		</tr>
	</table>
</form:form>
    </body>
</html>
