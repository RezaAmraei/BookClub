<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        		<%@ page isErrorPage="true" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
		<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>
	<h1>Add a Book to Your Shelf</h1>
	<a href="/home">back to the shelves</a>
	
	<form:form action="/create/book" method = "post" modelAttribute = "newBook">
	<p>
		<label>Title: </label>
		<form:errors path="title"/>
		<form:input path="title"/>
	</p>
	
	<p>
		<label>Author: </label>
		<form:errors path="authorName"/>
		<form:input path="authorName"/>
	</p>
	
	<p>
		<label>My Thoughts: </label>
		<form:errors path="thoughts"/>
		<form:input path="thoughts"/>
	</p>
	
	<p>
	<form:errors path= "user"/>
	<form:input type="hidden" path="user" value="${userId}"/>
	</p>
	
	<input type="submit" />
	</form:form>
</body>
</html>