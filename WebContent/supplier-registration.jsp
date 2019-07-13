<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supplier Registration</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<form action="${pageContext.request.contextPath}/users/save"
			method="post">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Name</label> <input type="text"
						name="name" class="form-control" id="inputEmail4"
						placeholder="Full Name">
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">Mobile</label> <input type="number"
						name="mobile" class="form-control" id="inputPassword4"
						placeholder="Mobile Number">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Email</label> <input type="email"
						name="email" class="form-control" id="inputEmail4"
						placeholder="Email">
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">Password</label> <input type="password"
						name="password" class="form-control" id="inputPassword4"
						placeholder="Password">
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Age</label> <input type="number"
						name="age" value="0" class="form-control" id="inputEmail4"
						placeholder="Age">
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">Gender</label> <input type="radio"
						name="gender" value="Male" /> &nbsp; Male &nbsp;&nbsp; <input
						type="radio" name="gender" value="Female" /> &nbsp; Female
				</div>
			</div>

			<div class="form-group">
				<label for="inputAddress">Address</label> <input type="text"
					name="address1" class="form-control" id="inputAddress"
					placeholder="1234 Main St">
			</div>
			<div class="form-group">
				<label for="inputAddress2">Address 2</label> <input type="text"
					name="address2" class="form-control" id="inputAddress2"
					placeholder="Apartment, studio, or floor">
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputCity">City</label> <input type="text" name="city"
						class="form-control" id="inputCity">
				</div>
				<div class="form-group col-md-4">
					<label for="inputState">State</label> <select id="inputState"
						name="state" class="form-control">
						<option selected>Choose...</option>
						<option>...</option>
					</select>
				</div>
				<div class="form-group col-md-2">
					<label for="inputZip">Zip</label> <input type="text" name="zip"
						class="form-control" id="inputZip">
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4"><button type="submit"
							class="btn btn-block btn-warning">Reset</button></label>
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4"><button type="submit"
							class="btn btn-primary">Sign Up</button></label>
				</div>
			</div>

		</form>

	</div>
</body>
</html>