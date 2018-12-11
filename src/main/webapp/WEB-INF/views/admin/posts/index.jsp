
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<h1>Post List</h1>
<spring:url value="/posts/create" var="createURL" />
<a href="${createURL }" role="button">Create</a>
<jsp:include page="../../partials/search.jsp">
	<jsp:param name="url" value="/posts" />
</jsp:include>
<br />
<br />
<div>
	${message.message}
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Slug</th>
			<th>Category</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${posts}" var="post">
			<tr>
				<td>${post.id}</td>
				<td>${post.title}</td>
				<td>${post.slug}</td>
				<td>${post.categoryId.name}</td>
				<td><spring:url value="/posts/edit/${post.id}"
						var="editURL" /> <a href="${editURL }" role="button">Edit</a> <spring:url
						value="/posts/delete/${post.id}" var="deleteURL" /> <a
					href="${deleteURL}" role="button">Delete</a></td>
			</tr>
		</c:forEach>	
	</table>
	
</div>
