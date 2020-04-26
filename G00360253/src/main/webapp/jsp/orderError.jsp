<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error with order</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1 style="color: red">Error Processing Order</h1>

	<h2 style="color: red">Quantity too large: Product stock =
		${product.qtyInStock}</h2>
	<table>
		<tr>
			<td><b>Product ID</b></td>
			<td><b>Customer ID</b></td>
			<td><b>Quantity</b></td>
		</tr>
		<tr>
			<td>${product.pId}</td>
			<td>${customer.cId}</td>
			<td>${order.qty}</td>
		</tr>
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