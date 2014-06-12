<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/bootstrap.css" />
<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="well">
			<h2>Login</h2>
			<form action="/login" method="POST">
				<div class="form-group">
					<label for="username">Username</label> 
					<input type="text" class="form-control" name="username" />
				</div>
				<div class="form-group">
					<label for="password">Password</label> 
					<input type="password" class="form-control" name="password" />
				</div>
				
				<button class="btn btn-primary">Login</button>
			</form>
		</div>
	</div>

</body>
</html>