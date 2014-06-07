<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Quote</title>
<link rel="stylesheet" href="/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<div class="well">
			<h2>Add a Quote</h2>
			<form method="POST" action="/new">
				<div class="form-group">
					<label for="text">Quote</label> 
					<input type="text" class="form-control" name="text" placeholder="quote..." />
				</div>

				<div class="form-group">
					<label for="author">Author</label> 
					<input type="text" class="form-control"  name="author" placeholder="quote author..." />
				</div>

				<button class="btn btn-primary">Add</button>
			</form>
		</div>
	</div>
</body>
</html>