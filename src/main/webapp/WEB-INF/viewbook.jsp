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
<title>View Book</title>
</head>
<body>
<h1><c:out value = "${book.title}"/></h1>
<a href="/home">Back to the shelves</a>
<h2><c:out value="${book.user.name}"/> read <c:out value = "${book.title}"/> by <c:out value = "${book.authorName }"/></h2>
<h2>Here are <c:out value="${book.user.name}"/>'s thoughts: </h2>
<p><c:out value = "${book.thoughts}"/></p>
<c:choose>
	<c:when test="${book.user.id.equals(userId)}">
	<a href="/edit/${book.id}"><button>Edit</button></a>
	
	</c:when>
	
	<c:otherwise>
	</c:otherwise>
</c:choose>
</body>
</html>