<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello Page</title>
<link rel="stylesheet" href="/css/bootstrap.css" />

</head>
<body>
	<sql:query dataSource="jdbc/QuoteDB" sql="select * from quote"
		var="results"></sql:query>

	<div class="jumbotron">
		<h1>The Great Quote Machine</h1>
	</div>

	<div class="container">
		<c:forEach items="${results.rows}" var="quote">
			<blockquote>
				<p>${quote.text}</p>
				<footer>${quote.author}</footer>
			</blockquote>
		</c:forEach>
	</div>

	<div class="container">
		<footer>
			<p>The quote database contains ${fn:length(results.rows)} quotes.</p>
		</footer>
	</div>

	<script src="/js/bootstrap.js"></script> 
</body>
</html>
