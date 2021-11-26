<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<%@ include file="Base.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xl-5 col-lg-6 col-m d-8 col-sm-10 mx-auto form pt-4">
				<form action="registerChef" method="post">
					<fieldset class="form-group">
						<legend class="text-uppercase text-muted mb-4">Chef Sign UP</legend>
						<input autocomplete="off" class="form-control form-control-lg mb-4" type="text" name="fullname" placeholder="&#xf007 Enter FullName" />
						<input autocomplete="off" class="form-control form-control-lg mb-4" type="email" name="email" placeholder="Enter Email" />
						<input autocomplete="off" class="form-control form-control-lg mb-4" type="text" name="employeeId" placeholder="Enter Employee ID" />
						<input autocomplete="off" class="form-control form-control-lg mb-4" type="text" name="nationalId" placeholder="Enter National ID" />
						<input autocomplete="off" class="form-control form-control-lg mb-4" type="text" name="phoneNumber" placeholder="Enter Phone Number" />
						<input autocomplete="off" class="form-control form-control-lg mb-4" type="password" name="password" placeholder="Enter Password" />
					</fieldset>
					<div class="d-flex justify-content-center">
						<input class="btn btn-outline-info" type="submit" value="create customer account" />
					</div>
				</form>
			
			</div>
		</div>
	</div>
</body>
</html>