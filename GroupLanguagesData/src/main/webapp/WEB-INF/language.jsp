<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/languages">Dashboard</a>
	<h2>${language.name }</h2>
	<h2>${language.creator }</h2>
	<h2>${language.currentVersion }</h2>
	<a href="/languages/delete/${id}">delete</a>
	<a href="/languages/edit/${id}">edit</a>
</body>
</html>