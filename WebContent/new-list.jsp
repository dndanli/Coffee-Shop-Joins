<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new List</title> 
</head>
<body>
	<form action="createNewListServlet" method="post">
		List Name: <input type="text" name="listName"><br />
		 
		Order date: <input type="text" name="month" placeholder="mm" size="4">
		
		<input type="text" name="day" placeholder="dd" size="4">, 
		<input type="text" name="year" placeholder="yyyy" size="4">
		 
 		Employee Name: <input type="text" name="employeeName"><br />
 		 
 		Available Items:<br /> <select name="allOrdersToAdd" multiple size="6">
 		
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<option value="${currentitem.id}"> ${currentitem.beanName} |
					${currentitem.quantityToOrder} | ${currentitem.packagesInStock}
					${currentitem.supplier}
					
					</option>
			</c:forEach>
			
		</select> <br /> <input type="submit" value="Create List and Add Items">
	</form>
	<a href="index.html">Go add new orders instead.</a>
</body>
</html>