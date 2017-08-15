<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Ninja</title>
</head>
<body>
	<h1>New Ninja!!!</h1>
	<a href="/">Home</a>
	<br><br>  
	<div>
		<form:form method="POST" action="/ninjas/new" modelAttribute="ninja">		
			<form:select path="dojo" name="Dojo:">
		  	  <form:options items="${dojos}" itemValue="id" itemLabel="name" />
			</form:select>
	       	<br><br>
	      	<form:label path="firstName">First Name:
		    <form:errors path="firstName"/>
		    <form:input path="firstName"/></form:label>
		    <br><br>
		    <form:label path="lastName">Last Name:
		    <form:errors path="lastName"/>
		    <form:input path="lastName"/></form:label>
		    <br><br>
		    <form:label path="age">Age:
		    <form:errors path="age"/>
		    <form:input path="age"/></form:label>
	        <br><br>
	           
	    <input type="submit" value="Create"/>
    		</form:form>
	</div>
</body>
</html>