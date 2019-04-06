<%-- 
    Document   : student
    Created on : 10 May, 2017, 12:39:02 AM
    Author     : mrvataliya
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Student your Name is ${uname}</h1>
      <%/*  <form:form method="POST" commandName="asubmit">
        <table>
		<tr>
			<td>Submission ID</td>
			<td><form:input path="subid" /></td>
		</tr>
                <tr>
			<td>Assignment ID</td>
			<td><form:input path="asid" /></td>
                        
		</tr>
                <tr>
			<td>User Name</td>
			<td><form:input path="uname" /></td>
                        
		</tr>
                <tr>
			<td>Assignment Solution</td>
                        <td><form:textarea path="assignment" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit Assignment" /></td>
		</tr>
	</table>
                </form:form>

*/%>
    <form action="stsubmission" method="post">
    <table>
        <tr>
            <td>Submission ID</td>
            <td><input type="text" name="subid" /></td>
        </tr> 
        <tr>
            <td>Assignment ID</td>
            <td><input type="text" name="asid" /></td>
        </tr> 
        <tr>
            <td>User Name</td>
            <td><input type="text" name="uname" value="${uname}" /></td>
        </tr> 
        <tr>
            <td>Assignment Solution Answer</td>
            <td><textarea name="assignment" cols="25" rows="10" ></textarea></td>
        </tr> 
        <tr>
	<td colspan="2"><input type="submit" value="Post Assignment Statement" /></td>
	</tr>
    </table>
</form>
        <br/><br/><br/>
        <h1>Assignment Questions By Faculty</h1>
        <table cellpadding="10">
            <tr>
                <th>Assignment ID</th>
                <th>Username</th>
                <th>Assignment Statement</th>
            </tr>
            <c:forEach items="${assignments}" var="sub">
                <tr>
                    <td><c:out value="${sub.asid}"/></td>
                    <td><c:out value="${sub.uname}"/></td>
                    <td><c:out value="${sub.astmt}"/></td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
