<%@ include file="/WEB-INF/views/taglib.jsp" %>

        <div class="col-lg-6 col-md-5 col-sm-4">
<form:form action="/visitor/edit/${editModel.id}"
                       method="POST"
                       modelAttribute="editModel"
                       enctype="multipart/form-data">
  <fieldset>
    <legend>Edit Form</legend>
    
    <div class="form-group">
			<form:errors path="*" cssClass="error" />
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
      <label class="form-control-label">First Name</label>
      <form:input path="firstName" type="text" placeholder="First Name" class="form-control" id="inputValid"/><form:errors path="firstName" class="text-danger"/>
    </div>
    
    <div class="form-group">
      <label class="form-control-label">Last Name</label>
      <form:input path="lastName" type="text" placeholder="Last Name" class="form-control" id="inputValid"/><form:errors path="lastName" class="text-danger"/>
    </div>
    
    <div class="form-group">
      <label class="form-control-label">Age</label>
      <form:input path="age" type="text" placeholder="Age" class="form-control" id="inputValid"/><form:errors path="age" class="text-danger"/>
    </div>
    
    <div class="form-group">
      <label class="form-control-label">Balance</label>
      <form:input path="balance" type="text" placeholder="Balance" class="form-control" id="inputValid"/><form:errors path="balance" class="text-danger"/>
    </div>
    
    <div class="form-group">
      <label class="form-control-label">Mobile</label>
      <form:input path="mobile" type="text" placeholder="Mobile" class="form-control" id="inputValid"/><form:errors path="mobile" class="text-danger"/>
    </div>
    
    <div class="form-group">
       <label>Gender:</label>
       <form:radiobuttons path="gender" items="${gender}"/>
     </div> 
    
    <div class="form-group">
      <label class="form-control-label">Profile Image</label>
      <form:input path="file" type="file" class="form-control"/>
    </div>

    <button type="submit" class="btn btn-outline-warning btn-lg">Edit</button>
    </fieldset>
</form:form>
</div>
        