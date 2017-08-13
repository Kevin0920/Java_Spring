<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
</head>
<body>
	<h1>A Song Detail</h1>
	<h3><a href = "/dashboard">Dashboard</a></h3>
	<h2>
		<p>Name: <c:out value="${song.name}"/></p>
		<p>Artist: <c:out value="${song.artist}"/></p>
		<p>Rating: <c:out value="${song.rating}"/></p>
	</h2>
   	<a href="/songs/delete/${song.id}">Delete</a>
</body>
</body>
</html>