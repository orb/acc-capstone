<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>

<my:layout>
<jsp:attribute name="body">

	<div class="container">
		<div class="well">
			<h2>Edit Quote:</h2>
			

			
			<form method="POST" action="/edit">
			    <input type="hidden" name="id" value="${quote.ID}" />
			    
				<div class="form-group">
					<label for="text">Quote</label> 
					<input type="text" class="form-control" name="text" 
					           value="${quote.text}"/>
				</div>

				<div class="form-group">
					<label for="author">Author</label> 
					<input type="text" class="form-control"  name="author" 
                            value="${quote.author}"/>
				</div>

				<button class="btn btn-primary">Edit</button>
			</form>
		</div>
	</div>
	
</jsp:attribute>
</my:layout>



