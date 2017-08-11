<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>languages</title>

<style type="text/css">
	table {
		border: 1px solid black;
	    border-collapse: collapse;
	    border-spacing: 5px;
	
	}
    
    th, td {
	    padding: 15px;
	    text-align: left;
	}
</style>

</head>
<body>
<table>
		<tr>
			<th>Name</th>
			<th>Creator</th>
			<th>Version</th>
			<th>action</th>
		</tr>
		<c:forEach var="language" items="${languages}" varStatus="status">
			<tr>
				<th><a href="/languages/${status.index }"><c:out value="${language.name }"></c:out></a></th>
				<th><c:out value="${language.creator }"></c:out></th>
				<th><c:out value="${language.currentVersion }"></c:out></th>
				<th>
					<a href="/languages/delete/${status.index }">delete</a>
					<a href="/languages/edit/${status.index }">edit</a>
				</th>
			</tr>
		</c:forEach>
	</table>
	
	<form:form method="POST" action="/language/new" modelAttribute="language">
		<br><br>
	    <form:label path="name">Name
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label>
	    <br><br>
	    <form:label path="creator">Creator
	    <form:errors path="creator"/>
	    <form:input path="creator"/></form:label>
	    <br><br>
	    <form:label path="currentVersion">Version
	    <form:errors path="currentVersion"/>
	    <form:input path="currentVersion" value="1.0"/></form:label>
	    
	    <input type="submit" value="Submit"/>
	</form:form>


</body>
</html>