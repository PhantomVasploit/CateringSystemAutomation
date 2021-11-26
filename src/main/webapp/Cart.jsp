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
							<h4 class="text-uppercase">Confirm Food Item Name</h4>
						</div>
						<div class="col">
							<h4 class="text-uppercase">Confirm Amount ordered</h4>
						</div>
						<div class="col">
							<h4 class="text-uppercase">Confirm Cost</h4>
						</div>
						<div class="col">
							<h4 class="text-uppercase"></h4>
						</div>
					</div>
					<c:forEach var="order" items="${requestScope.orders }">
					<form action="cart" method="post">
						<div class="row">
							<div class="col">
								<p class="text-muted"><c:out value="${order.getFoodItem()}"></c:out></p><input name="orderName" type="checkbox" class="ms-4 form-check-input" value="${order.getFoodItem()}">
							</div>
							<div class="col">
								<p class="text-muted"><c:out value="${order.getAmountOrdered()}"></c:out></p><input name="orderAmount" type="checkbox" class="ms-4 form-check-input" value="${order.getFoodItem()}">
							</div>
							<div class="col">
								<p class="text-muted"><c:out value="${order.getCost()}"></c:out></p><input name="orderCost" type="checkbox" class="ms-4 form-check-input" value="${order.getFoodItem()}">
							</div>
							<div class="col">
								<input type="submit" class="btn btn-secondary" value="Check Out"/>
							</div>
						</div>
					</form>
					</c:forEach>
				</div>
			
			</div>
		</div>
	</div>		
</body>
</html>