<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	
	<form action="/process" method="post">
		<p>
			<label>You Name:</label>
			<input type="text" name="name"></input>
		</p>
		<p>
			<label>Dojo Location:</label>
			<select name="location">
			  <option value="san jose">San Jose</option>
			  <option value="washington">Washington DC</option>
			  <option value="sealtle">Sealtle</option>
			  <option value="burbank">Burbank</option>
			</select>			
		</p>
		<p>
			<label>Favorite Language:</label>
			<select name="language">
			  <option value="python">Python</option>
			  <option value="java">Java</option>
			  <option value="javascript">Javascript</option>
			  <option value="html">Html</option>
			</select>
		</p>
		
		<p>
			 <label>Comment(optional):</label>
			 <textarea name="comment" rows="4" cols="50"></textarea>			 
		</p>
		<button type="submit">Submit</button>
	
	</form>
	
</body>
</html>