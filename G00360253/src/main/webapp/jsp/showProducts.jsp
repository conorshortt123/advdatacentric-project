<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new product</title>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h1>List of Products:</h1>
<table>
<tr>
<td><b>Product ID</b></td>
<td><b>Description</b></td>
<td><b>Quantity in Stock</b></td>
</tr>
	<c:forEach items="${products}" var="product">
		<tr>
			<td>${product.pId}</td>
			<td>${product.pDesc}</td>
			<td>${product.qtyInStock}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>