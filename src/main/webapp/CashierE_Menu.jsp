<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<%@ include file="Base.html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>	
	<div class="container">
		<div class="row">
			<div class="list-group mt-4">
				<div class="list-group-item">
					<div class="row">
						<div class="col">
							<h1 class="text-uppercase fs-3 fw-bold">Food Item Name</h1>
						</div>
						<div class="col">
							<h1 class="text-uppercase fs-3 fw-bold">Amount ordered</h1>
						</div>
						<div class="col">
							<h1 class="text-uppercase fs-3 fw-bold">Staff Price</h1>
						</div>
						<div class="col">
							<h1 class="text-uppercase fs-3 fw-bold">Student Price</h1>
						</div>
						<div class="col">
							<h1 class="text-uppercase fs-3 fw-bold"></h1>
						</div>
					</div>
				</div>
				<c:forEach var="foodItem" items="${requestScope.data }" >
						<li class="list-group-item">
							<form action="cashierE_Menu" method="post">
								<div class="row" >
									<div class="col">
										<c:out value="${foodItem.getItemName()}"></c:out><input name="foodItem"  type="checkbox" class="ms-4 form-check-input" value="${ foodItem.getItemName()}" id="${ foodItem.getItemName()}" />
									</div>
									<div class="col">
										<input type="text" placeholder="Specify Amount ordered" class="form-control" name="amountOrdered" />
									</div>
									<div class="col">
										<c:out value="${ foodItem.getStaffCafeteriaPrice() }"></c:out><input name="staffPrice"  type="checkbox" class="ms-4 form-check-input" value="${ foodItem.getStaffCafeteriaPrice()}"  />
									</div>
									<div class="col">
										<c:out value="${ foodItem.getStudentCafeteriaPrice() }"></c:out><input name="studentPrice"  type="checkbox" class="ms-4 form-check-input" value="${ foodItem.getStudentCafeteriaPrice()}"  />
									</div>
									<div class="col">
										<input type="submit" id="${foodItem.getItemName()}" class="btn btn-secondary" value="Add To Cart"/>
									</div>
								</div>
							</form>
						</li>
				</c:forEach>
			</div>
		</div>
	</div>		
</body>
</html>