<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new customer</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1>Add New Customer</h1>
	<form:form modelAttribute="customer">
		<table>
			<tr>
				<td>Customer Name:</td>
				<td><form:input path="cName"></form:input></td>
				<td><form:errors path="cName"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>
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