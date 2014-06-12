<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
							<li>
								<p class="navbar-text">
									[<b>${sessionScope.user.username}</b>] <a href="/logout">Logout</a>
								</p>
							</li>

						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>