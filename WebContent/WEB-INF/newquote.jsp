<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>

<my:layout>
<jsp:attribute name="body">
	<div class="container">
		<div class="well">
			<h2>Add a Quote</h2>
			<c:if test="${error!=null}">
			    <div class="alert alert-danger">${error}</div>
			</c:if>
			<form method="POST" action="/new">
				<div class="form-group">
					<label for="text">Quote</label> 
					<input type="text" class="form-control" name="text" placeholder="quote..." 
					       value="${param.text}"/>
				</div>

				<div class="form-group">
					<label for="author">Author</label> 
					<input type="text" class="form-control" name="author" placeholder="quote author..." 
					       value="${param.author}"/>
				</div>

				<button class="btn btn-primary">Add</button>
			</form>
		</div>
	</div>
</jsp:attribute>
</my:layout>
