<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lookify Dashboard</title>
</head>
<body>

	<h1>Dashboard Page!!!</h1>
	<h3>
		<a href = "/songs/new">Add New</a>
		<a href = "#">Top Songs</a>
	</h3>
	
	<%-- <form:form method="POST" action="/search/{artist}" modelAttribute="artistsearch">
    
	    <form:label path="name">Name
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label>
	    
	    <form:label path="creator">Creator
	    <form:errors path="creator"/>
	    <form:input path="creator"/></form:label>
	    
	    <form:label path="version">Version
	    <form:errors path="version"/>
	    <form:input path="version"/></form:label>
	    
	    <input type="submit" value="Submit"/>
	</form:form> --%>
	
	<table class="table">
    	<tr>
    		<td>Name</td>
    		<td>Rating</td>
    		<td>Action</td>
    	</tr>
    <c:forEach items="${songs}" var="song" varStatus="loop">
        <tr>        
		    <td><a href = "/songs/${song.id}"><c:out value="${song.name}"/></a></td>
		    <td><c:out value="${song.rating}"/></td>
		    <td>
		    	<a href="/songs/delete/${song.id}">Delete</a>
		    </td>
        </tr>
    </c:forEach>
    </table>

</body>
</html>