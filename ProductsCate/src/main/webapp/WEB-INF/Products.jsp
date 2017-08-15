<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>product details</title>
</head>
<body>
	<h1>${product.name }</h1>
	<h3>Categories: </h3>
	<a href="/">Home</a>
	<hr>
	<ul>
		<c:forEach var="category" items="${product.categories }">
			<li>${category.name }</li>
		</c:forEach>
	</ul>

	<c:if test="${categories.size() != product.categories.size() }">
		<form method="POST" action="/products/${product.id }/new" >
			<select name="category">
				<p>Add Category:</p>
				<c:forEach var="category" items="${categories }">
					<c:if test="${!product.categories.contains(category) }">
						<option value="${category.id }">${category.name }</option>
					</c:if>
					
				</c:forEach>
			</select>
			<input type="submit" value="add">
		</form>
	</c:if>
	
	
	
	
</body>
</html>