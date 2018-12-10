
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<h1>Categories List</h1>
<spring:url value="/categories/create" var="createURL" />
<a href="${createURL }" role="button">Create</a>
<jsp:include page="../../partials/search.jsp">
	<jsp:param name="url" value="/categories" />
</jsp:include>
<br />
<br />
<div>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Parent Name</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${categories.getContent()}" var="category">
			<tr>
				<td>${category.id}</td>
				<td>${category.name}</td>
				<td>${category.description}</td>
				<td>${category.parentId.name}</td>
				<td><spring:url value="/categories/edit/${category.id}"
						var="editURL" /> <a href="${editURL }" role="button">Edit</a> <spring:url
						value="/categories/delete/${category.id}" var="deleteURL" /> <a
					href="${deleteURL }" role="button">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<ul>
		<c:if test="${param.page > 1}">
			<li><a href="/categories?page=${param.page-1}">Prev</a></li>
		</c:if>
		<c:forEach begin="1" end="${categories.getTotalPages()}" var="i">
			<c:choose>
				<c:when test="${param.page eq i || ( i==1 && param.page == null )}">
					<font color="red">${i}</font>
				</c:when>
				<c:otherwise>
					<li><a
						href="/categories?page=${i}<c:if test='${param.q != null}'>&q=${param.q}</c:if>">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${param.page < categories.getTotalPages()}">
			<li><a href="/categories?page=${param.page+1}">Next</a></li>
		</c:if>
	</ul>
</div>
