<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.css" />
<title>The Quote Machine</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">QuoteMachine</a>
			</div>

			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${sessionScope.user==null}">
							<li><a href="login">Login</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="/list">All Quotes</a></li>
							<li><a href="/new">Create</a></li>
							
						
							<li><a href="/logout">Logout</a></li>

						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>

	<div class="jumbotron">
		<h1>The Great Quote Machine</h1>
	</div>

	<div class="container">
		<blockquote>
			<p>${quote.text}</p>
			<footer>${quote.author}</footer>
		</blockquote>
	</div>

	<div class="container">
		<footer>
			<p>
				The quote database contains ${fn:length(quotes)} quotes as of
				<fmt:formatDate value="${now}" pattern="E h:m a" />
				. <a href="/new">Add a quote</a>
			</p>
		</footer>
	</div>


	<script src="/js/bootstrap.js"></script>
</body>
</html>


