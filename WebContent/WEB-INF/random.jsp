<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>


<my:layout>
<jsp:attribute name="body">

	<div class="jumbotron">
		<h1>The Great Quote Machine</h1>
	</div>

	<div class="container">
		<blockquote>
			<p>${quote.text}</p>
			<footer>${quote.author}</footer>
		</blockquote>
	</div>
	
	</jsp:attribute>
</my:layout>