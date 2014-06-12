<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="body" fragment="true" %>

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
	<jsp:include page="/WEB-INF/navbar.jsp"></jsp:include>

    <jsp:invoke fragment="body"></jsp:invoke>

	<div class="container">
		<footer>
			<p>
			<c:choose>
			<c:when test="${quotes != null }">
				The quote database contains ${fn:length(quotes)} quotes as of
				<fmt:formatDate value="${now}" pattern="E h:m a" />.
			</c:when>
			</c:choose>
			</p>
		</footer>
	</div>


	<script src="/js/bootstrap.js"></script>
</body>
</html>



