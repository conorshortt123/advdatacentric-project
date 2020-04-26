<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new product</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
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
	<h4>Indexes</h4>
	<div>
		<a href="/index.html">Home</a> <a href="/logout">Logout</a>
	</div>
	<table>
		<tr>
			<td><a href="/addProduct.html">Add Product</a></td>
			<td><a href="/newOrder.html">Add Order</a></td>
			<td><a href="/addCustomer.html">Add Customer</a></td>
		</tr>
		<tr>
			<td><a href="/ListProducts.html">List Products</a></td>
			<td><a href="/ListOrders.html">List Orders</a></td>
			<td><a href="/ListCustomers.html">List Customers</a></td>
		</tr>
	</table>
</body>
</html>