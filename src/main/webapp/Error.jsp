<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="Base.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="alert alert-danger">
		<h2 class="text-uppercase text-muted text-light alert-heading"><c:out value="There is an error that has occurred."></c:out></h2>
		
		<p class="text-muted text-light"><c:out value="${requestScope.exception }"></c:out></p>
	</div>
</body>
</html>