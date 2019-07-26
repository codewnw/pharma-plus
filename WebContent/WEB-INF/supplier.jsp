<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Admin - PharmaPlus</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
				<table class="table">
					<tbody>
						<tr>
							<th scope="row">Email</th>
							<td>${requestScope.supplier.email}</td>
						</tr>
						<tr>
							<th scope="row">Name</th>
							<td>${requestScope.supplier.name}</td>
						</tr>
						
						<tr>
							<th scope="row">Mobile</th>
							<td>${requestScope.supplier.mobile}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-2"></div>
		</div>
	</div>
</body>
</html>