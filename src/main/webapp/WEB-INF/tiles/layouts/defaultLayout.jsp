<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
</head>
<body>
<body>
	<div class="flex-container">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="menu" />
		<article class="article">
			<tiles:insertAttribute name="body" />
		</article>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</body>

</html>