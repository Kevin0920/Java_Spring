<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>new category</title>
</head>
<body>
	<h1>${category.name }</h1>
	<h3>Products: </h3>
	<a href="/">Home</a>
	<hr>
	<ul>
		<c:forEach var="product" items="${category.products }">
			<li>${product.name }</li>
		</c:forEach>
	</ul>
	
	<c:if test="${products.size() != category.products.size() }">
		<form method="POST" action="/categories/${category.id }/new" >
			<select name="product">
				<p>Add Product:</p>
				<c:forEach var="product" items="${products }">
					<c:if test="${!category.products.contains(product) }">
						<option value="${product.id }">${product.name }</option>
					</c:if>
					
				</c:forEach>
			</select>
			<input type="submit" value="add">
		</form>
	</c:if>
	
	
</body>
</html>