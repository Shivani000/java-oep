<%-- 
    Document   : faculty
    Created on : 10 May, 2017, 12:33:45 AM
    Author     : mrvataliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Faculty ${uname}</h1>
   <%/*    <form:form method="POST" commandName="aspost">
        <table>
		<tr>
			<td>Assignment ID</td>
                        <td><form:input path="asid" /></td>
		</tr>
                <tr>
			<td>User name</td>
			<td><form:input path="uname" value="${uname}" /></td>
		</tr>
                <tr>
			<td>Assignment Statement</td>
                        <td><form:input path="astmt" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Post Assignment Statement" /></td>
		</tr>
	</table>
</form:form> 

*/%>
<form action="facultyquestion" method="post">
    <table>
        <tr>
            <td>Assignment ID</td>
            <td><input type="text" name="asid" /></td>
        </tr> 
        <tr>
            <td>User Name</td>
            <td><input type="text" name="uname" value="${uname}" /></td>
        </tr> 
        <tr>
            <td>Assignment Question</td>
            <td><input type="text" name="astmt" /></td>
        </tr> 
        <tr>
	<td colspan="2"><input type="submit" value="Post Assignment Statement" /></td>
	</tr>
    </table>
</form>
        <br/><br/><br/><br/>
        <h1>Submission Submitted by Student with Their Name and submission ID</h1>
        <table cellpadding="10">
            <tr>
                <th>Submission ID</th>
                <th>Assignment ID</th>
                <th>Username</th>
                <th>Assignment Submitted Contents</th>
            </tr>
            <c:forEach items="${submissions}" var="sub">
                <tr>
                    <td><c:out value="${sub.subid}"/></td>
                    <td><c:out value="${sub.asid}"/></td>
                    <td><c:out value="${sub.uname}"/></td>
                    <td><c:out value="${sub.assignment}"/></td>
                </tr>
            </c:forEach>
        </table>
        
        
    </body>
</html>
