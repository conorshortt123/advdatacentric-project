<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show customers</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1>List of Customers:</h1>
	<c:forEach items="${customers}" var="customer">
		<hr>
		<h1>${customer.cId} ${customer.cName}</h1>

		<h2>${customer.cName}'s Orders</h2>
		<table>
			<tr id="tableHeader">
				<td><b>Order ID</b></td>
				<td><b>Quantity</b></td>
				<td><b>Product ID</b></td>
				<td><b>Description</b></td>
			</tr>
			<c:forEach items="${customer.orders}" var="order">
				<tr>
					<td>${order.oId}</td>
					<td>${order.qty}</td>
					<td>${order.prod.pId}</td>
					<td>${order.prod.pDesc}</td>
				</tr>
			</c:forEach>
		</table>
	</c:forEach>
	<hr>
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