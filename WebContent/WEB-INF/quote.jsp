<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.css" />
<title>The Quote Machine</title>
</head>
<body>
	<div class="jumbotron">
		<h1>The Great Quote Machine</h1>
	</div>

	<div class="container">
		<blockquote>
			<p>${quote.text}</p>
			<footer>${quote.author}</footer>
		</blockquote>
	</div>


	<script src="/js/bootstrap.js"></script>
</body>
</html>






