
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form method="get"
		action="${param.url}" cssClass="form">
	<input type="text" name="q" />
	<button type="submit" class="btn btn-primary">Search</button>
</form:form>