<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>new product</title>
</head>
<body>
	<h1>New Product</h1>
	 <a href="/">Home</a>
		<br><br>
		<form:form method="POST" action="/products/new" modelAttribute="product">
	    <form:label path="name">Name:
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label>
	    <br><br>
	    <form:label path="description">Description:
	    <form:errors path="description"/>
	    <form:textarea path="description"/></form:label>
	    <br><br>
	    <form:label path="price">Price:
	    <form:errors path="price"/>     
	    <form:input type="number" path="price"/></form:label>
	    <br><br>
	    <input type="submit" value="Create"/>
	</form:form>
	
	
</body>
</html>