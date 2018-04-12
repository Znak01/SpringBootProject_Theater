<%@ include file="taglib.jsp"%>

<sec:authorize access="isAuthenticated()"><h2>Please logout first</h2></sec:authorize>
<sec:authorize access="!isAuthenticated()">
<div class="col-lg-6 col-md-5 col-sm-4">
<form:form action="/register" method="POST"
		modelAttribute="registerModel">
  <fieldset>
    <legend>Register Form</legend>
		
		 <div class="form-group">
			<form:errors path="*" class="text-danger" />
		</div>
		
    <div class="form-group">
      <label class="form-control-label">Login</label>
      <form:input path="login" type="text" placeholder="Login" class="form-control" id="inputValid"/><form:errors path="login" class="text-danger"/>
    </div>
    
    <div class="form-group">
      <label for="exampleInputEmail1">Email address</label>
      <form:input path="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"/><form:errors path="email" class="text-danger"/>
      <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Password</label>
      <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/><form:errors path="password" class="text-danger"/>
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Confirm Password</label>
      <form:input path="passwordConfirm" type="password" class="form-control" id="exampleInputPassword1" placeholder="Confirm Password"/><form:errors path="passwordConfirm" class="text-danger"/>
    </div>
    
    <button type="submit" class="btn btn-outline-success btn-lg">Register</button>
    </fieldset>
</form:form>
</div>
</sec:authorize>