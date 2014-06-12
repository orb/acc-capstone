<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>

<my:layout>
<jsp:attribute name="body">

	<div class="container">
		<div class="well">
			<h2>Login</h2>
			<form action="/login" method="POST">
				<div class="form-group">
					<label for="username">Username</label> 
					<input type="text" class="form-control" name="username" />
				</div>
				<div class="form-group">
					<label for="password">Password</label> 
					<input type="password" class="form-control" name="password" />
				</div>
				
				<button class="btn btn-primary">Login</button>
			</form>
		</div>
	</div>

</jsp:attribute>
</my:layout>
