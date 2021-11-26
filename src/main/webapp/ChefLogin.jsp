<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<%@ include file="Base.html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xl-5 col-lg-6 col-m d-8 col-sm-10 mx-auto form pt-4">
				<form action="cheflogin" method="post">
					<fieldset class="form-group">
						<legend class="text-uppercase text-muted mb-4">Chef Sign In</legend>
						<c:if test="${requestScope.message }">
							<p class="text-danger"> <c:out value="${requestScope.message }"></c:out> </p>
						</c:if>
						<input autocomplete="off" class="form-control form-control-lg mb-4" type="text" name="employeeId" placeholder="Enter Employee ID" />
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