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
				<c:forEach var="foodItem" items="${requestScope.data }" >
						<li class="list-group-item">
							<div class="row" >
								<div class="col">
									<p class="text-uppercase" id="${foodItem.getItemCode() }"><c:out value="${foodItem.getItemName()}"></c:out></p>
								</div>
								<div class="col">
									<c:out value="${ foodItem.getStaffCafeteriaPrice() }"></c:out>
								</div>
								<div class="col">
									<c:out value="${ foodItem.getStudentCafeteriaPrice() }"></c:out>
								</div>
							</div>
						</li>
				</c:forEach>
			</div>
		</div>
	</div>		
</body>
</html>