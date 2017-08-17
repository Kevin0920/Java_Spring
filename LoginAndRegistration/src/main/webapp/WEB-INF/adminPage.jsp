<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
</head>
<body>
	 <h1>Welcome to the Admin Page <c:out value="${currentUser.firstName}"></c:out></h1>
    
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
        
        <table>
        		<tr>
        			<th>Name</th>
        			<th>Email</th>
        			<th>Role Status</th>
        			<th>Action</th>
        		</tr>
        		<c:forEach var="user" items="${users }">
        		<tr>
        			<td>${user.firstName }</td>
        			<td>${user.username }</td>
        			<td>${user.roles.get(0).name }</td>
        			<td></td>
        			
        		<tr> 
        		</c:forEach>
        		     
        </table>
        
    </form>
</body>
</html>