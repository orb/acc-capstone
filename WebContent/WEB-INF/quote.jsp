<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>

<my:layout>
<jsp:attribute name="body">
	<div class="jumbotron">
		<h1>The Great Quote Machine</h1>
	</div>

	<div class="container">
		<c:forEach var="quote" items="${quotes}">

			<blockquote>

				<p>
					<a href="/edit?id=${quote.ID}"><span class="glyphicon glyphicon-edit"></span></a>
										
					<c:out value="${quote.text}" />
			    </p>
				<footer><c:out value="${quote.author}" /></footer>
			</blockquote>
		</c:forEach>
	</div>
</jsp:attribute>
</my:layout>








