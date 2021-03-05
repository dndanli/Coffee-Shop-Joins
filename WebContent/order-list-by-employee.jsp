<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee coffee beans order Lists</title>
</head>
<body>
	<form method="post" action="listNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allLists}" var="currentlist">
				<tr>
					<td><input type="radio" name="id" value="${currentlist.orderDtId}"></td>
					<td><h2>${currentlist.orderDtName}</h2></td>
				</tr>
				
				
				<tr>
					<td colspan="3">Order Date: ${currentlist.orderDtDate}</td>
				</tr>
				
				
				<tr>
					<td colspan="3">Employee: ${currentlist.employee.employeeName}</td>
				</tr>
				
				
				<c:forEach var="listVal" items="${currentlist.listOfItems}">
				
					<tr>
						<td></td>
						<td colspan="3">${listVal.id}, ${listVal.beanName}, ${listVal.quantityToOrder}
						</td>
					</tr>
					
				</c:forEach>
				
			</c:forEach>
			
		</table>
		<input type="submit" value="delete" name="doThisToList"> 

	</form>
	<a href="addOrdersForListServlet">Create a new List of Orders</a>
	<a href="index.html">Insert a new Order</a>
</body>
</html>