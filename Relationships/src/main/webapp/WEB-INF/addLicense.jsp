<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NewLicense</title>
</head>
<body>
	<h1>New License</h1>
	<h3><a href="/">Homepage</a></h3>
	
	<div>
		<form:form method="POST" action="/licenses/new" modelAttribute="license">
		<form:hidden path="id"/>
	    <form:label path="person">Person:
	    <form:errors path="person"/>
			<form:select path="person" >
				<c:forEach items="${people}" var="person">
					<form:option value="${person.id}" label="${person.firstName}  ${person.lastName}" />
				</c:forEach>
			</form:select></form:label>
	    <br><br>
	    <form:label path="state">State:
	    <form:errors path="state"/>
	    <form:input path="state"/></form:label>
	    <br><br>
	    <form:label path="expiration_date">Expiration Date:
	    <form:errors path="expiration_date"/>     
	    <form:input type="date" path="expiration_date"/></form:label>
    
	    <input type="submit" value="Create a License"/>
		</form:form>
		
		
	
	</div>
	
	
	
	
</body>
</html>