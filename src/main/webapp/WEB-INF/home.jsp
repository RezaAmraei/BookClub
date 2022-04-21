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
<title>Home</title>
</head>
<body>
	<h1>Welcome <c:out value="${name}"/></h1>
	<p>TBooks from everyones's shelves:</p>
	<a href="/logout">Logout</a>
	<a href="/add/book">+ Add a book to my shelf!</a>
	
	<table>
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Posted By</th>
		</tr>
		<c:forEach var="oneBook" items="${allBooks}">
				<tr>
					<td><c:out value="${oneBook.id}"/></td>
					<td><a href="/view/book/${oneBook.id}"><c:out value="${oneBook.title}"/></a></td>					
					<td><c:out value="${oneBook.authorName}"/></td>
					<td><c:out value="${oneBook.user.name}"/></td>
				</tr>
		</c:forEach>
	</table>
</body>
</html>