<%@ include file="taglib.jsp"%>

<div class="col-lg-6 col-md-5 col-sm-4">
<form:form action="/login" modelAttribute="loginModel" method="POST">
  <fieldset>
    <legend>Login Form</legend>
    
    <div class="form-group">
			<form:errors path="*" cssClass="error" />
		</div>
    
    <div class="form-group">
      <label for="exampleInputEmail1">Email address</label>
      <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email">
      <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Password</label>
      <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
    </div>
    <div class="checkbox">
			<label><input type="checkbox" name="rememberme" class="">
				Remember me</label>
		</div>
    <button type="submit" class="btn btn-primary btn-lg">Login</button>
    </fieldset>
</form:form>
</div>