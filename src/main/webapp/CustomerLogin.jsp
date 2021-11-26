<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<%@ include file="Base.html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xl-5 col-lg-6 col-m d-8 col-sm-10 mx-auto form pt-4">
				<c:if test="${message}">
					<c:out value="${message}"></c:out>
				</c:if>
				<form action="customerlogin" method="post">
					<fieldset class="form-group">
						<legend class="text-uppercase text-muted mb-4">Customer Sign In</legend>
						<input autocomplete="off" class="form-control form-control-lg mb-4" type="text" name="regNo" placeholder="Enter Registration Number" />
						<input autocomplete="off" class="form-control form-control-lg mb-4" type="password" name="password" placeholder="Enter Password" />
					</fieldset>
					<div class="d-flex justify-content-center">
						<input class="btn btn-outline-info" type="submit" value="login" />
					</div>
				</form>
			
			</div>
		</div>
	</div>
</body>
</html>