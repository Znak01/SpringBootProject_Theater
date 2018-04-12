<%@ include file="taglib.jsp"%>

<sec:authorize access="isAuthenticated()"><h2>You are already logged in</h2></sec:authorize>
<sec:authorize access="!isAuthenticated()">
<div class="col-lg-6 col-md-5 col-sm-4">
<form:form action="/login" modelAttribute="loginModel" method="POST">
  <fieldset>
    <legend>Login Form</legend>
    
    <div class="form-group">
			<form:errors path="*" class="text-danger" />
		</div>
    
    <div class="form-group">
      <label for="exampleInputEmail1">Email address</label>
      <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email"><form:errors path="email" class="text-danger"/>
      <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Password</label>
      <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password"><form:errors path="password" class="text-danger"/>
    </div>
    <div class="checkbox">
			<label><input type="checkbox" name="rememberme" class="">
				Remember me</label>
		</div>
    <button type="submit" class="btn btn-outline-success btn-lg">Login</button>
    </fieldset>
</form:form>
</div>
</sec:authorize>