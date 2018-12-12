
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/categories/update" var="saveURL" />
<h2>Article</h2>
<form:form modelAttribute="categoryForm" method="post"
	action="${saveURL }" cssClass="form">
	<form:hidden path="id" id="id"/>
	<div class="form-group">
		<label>Name</label>
		<form:input path="name" cssClass="form-control" id="name" />
	</div>
	<div class="form-group">
		<label>Description</label>
		<form:input path="description" cssClass="form-control"
			id="description" />
	</div>
	<div class="form-group">
		<label>Position</label>
		<form:input path="position" cssClass="form-control" id="position" />
	</div>
	<div class="form-group">
		<label>Parent</label>
		<form:select path="parentId.id">
			<form:option value="" label="---SELECT---" />
			<c:forEach items="${parents}" var="parent">
				<form:option value="${parent.id}" label="${parent.name}" />
			</c:forEach>
		</form:select>
	</div>
	<div class="form-group">
		<label>Status</label>
		<form:select path="status">
			<form:option value="0" label="0" />
			<form:option value="1" label="1" />
		</form:select>
	</div>
	<button type="submit" class="btn btn-primary">Save</button>
</form:form>
