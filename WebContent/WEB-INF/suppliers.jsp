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


		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Email</th>
					<th scope="col">Name</th>
					<th scope="col">Mobile</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="supplier" items="${requestScope.suppliers}">
					<tr>
						<th scope="row">${supplier.mobile}</th>
						<td>${supplier.name}</td>
						<td>${supplier.email}</td>
						<td><a href="view?email=${supplier.email}" class="btn btn-info">View</a>/<a href="delete?email=${supplier.email}"
							class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>



	</div>
</body>
</html>