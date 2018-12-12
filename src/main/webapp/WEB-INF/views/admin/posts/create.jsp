
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:url value="/posts/store" var="saveURL" />
<h2>Post</h2>
<form:form modelAttribute="postForm" method="post" action="${saveURL }"
	cssClass="form" enctype="multipart/form-data">
	<div class="form-group">
		<label>Title</label>
		<form:input path="title" cssClass="form-control" id="title" />
		<font color="red"><form:errors path="title" /></font>
	</div>
	<div class="form-group">
		<label>Body</label>
		<form:input path="body" cssClass="form-control" id="body" />
		<font color="red"><form:errors path="body" /></font>
	</div>
	<div class="form-group">
		<label>Category</label>
		<form:select path="categoryId">
			<form:option value="" label="---SELECT---" />
			<c:forEach items="${parents}" var="parent">
				<form:option value="${parent.id}" label="${parent.name}" />
			</c:forEach>
		</form:select>
	</div>
	<div class="form-group">
		<label>Select a file to upload</label> <input type="file" name="file" />
	</div>
	<div class="form-group">
		<label>Status</label>
		<form:select path="status">
			<form:option value="1" label="1" />
			<form:option value="0" label="0" />
		</form:select>
	</div>
	<button type="submit" class="btn btn-primary">Save</button>
</form:form>
