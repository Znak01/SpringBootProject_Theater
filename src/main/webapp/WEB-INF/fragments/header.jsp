<%@ include file="../views/taglib.jsp"%>

<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-primary">
	<div class="container">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor01" aria-controls="navbarColor01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/play/list/pages">Plays</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/actor/list/pages">Actors</a></li>
				<li class="nav-item"><a class="nav-link" href="/session/list">Schedule</a></li>
				<li class="nav-item"><a class="nav-link" href="#">About</a></li>
			</ul>
			<ul class="nav navbar-nav ml-auto">
				<sec:authorize access="!isAuthenticated()">
					<li class="nav-item"><a class="nav-link"
						href="/login">Login</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/register">Register</a></li>
				</sec:authorize>
				

				<sec:authorize access="isAuthenticated()">
				<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li class="nav-item"><a class="nav-link"
						href="/admin">Admin Page</a></li>
				</sec:authorize>
					<c:url var="logoutUrl" value="/logout" />
					<form:form class="form-inline" action="${logoutUrl }" method="POST">
						<sec:authentication property="principal.username" var="username" />
						<li class="nav-item"><a class="nav-link"
							href="/visitor">${username}</a>
						</li>
						<li class="nav-item"><input class="btn btn-secondary my-2 my-sm-0"
							type="submit" value="Logout"></li>
					</form:form>
				</sec:authorize>
			</ul>

		</div>
	</div>
</nav>