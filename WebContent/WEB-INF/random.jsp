<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:layout>
<jsp:attribute name="body">

	<div class="jumbotron">
		<h1>The Great Quote Machine</h1>
	</div>

	<div class="container">
		<blockquote>
			<p><c:out value="${quote.text}" /></p>
			<footer><c:out value="${quote.author}" /></footer>
		</blockquote>
	</div>

	</jsp:attribute>
</my:layout>