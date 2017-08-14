<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Person</title>
</head>
<body>
	<h1>Welcome New Member!!!</h1>
	<h3><a href="/">Homepage</a></h3>
	
	<div>
		<form:form method="POST" action="/persons/new" modelAttribute="person">
			<form:hidden path="id"/>
		    <form:label path="firstName">First Name:
		    <form:errors path="firstName"/>
		    <form:input path="firstName"/></form:label>
		    <br><br>
		    <form:label path="lastName">Last Name:
		    <form:errors path="lastName"/>
		    <form:input path="lastName"/></form:label>
		    
		    
		    <input type="submit" value="Create an Account"/>
		</form:form>
	
	</div>
	
	
</body>
</html>