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
			<div class="list group mt-4">
				<c:forEach var="data" items="${requestScope.foodItems }" >
					<form action="food-items" method="post">
						<div class="list-group-item">
							<div class="row">
								<div class="col">
									<c:out value="${ data.getItemName()}" /> <input name="foodItem"  type="checkbox" class="ms-4 form-check-input" value="${ data.getItemName()}" id="${ data.getItemName()}" />
								</div>
								<div class="col">
									<input class="form-control" type="text" name="amountPrepared" placeholder="Enter Estimated preapred amount" />
								</div>
								<div class="col">
									<input class="ms-4 btn btn-outline-info" type="submit" value="Add" />
								</div>
							</div>
						</div>
					</form>
				</c:forEach>
			</div>
		</div>
</body>
</html>