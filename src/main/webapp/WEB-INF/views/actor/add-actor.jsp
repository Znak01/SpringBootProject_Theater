<%@ include file="/WEB-INF/views/taglib.jsp" %>
        
    <div class="col-lg-6 col-md-5 col-sm-4">
<form:form action="/actor/add"
                       method="POST"
                       modelAttribute="actor"
                       enctype="multipart/form-data">
  <fieldset>
    <legend>Actor Add Form</legend>
    
    <div class="form-group">
			<form:errors path="*" cssClass="error" />
		</div>
    
    <div class="form-group">
      <label class="form-control-label">First Name</label>
      <form:input path="firstName" type="text" placeholder="First Name" class="form-control" id="inputValid"/>
    </div>
    
    <div class="form-group">
      <label class="form-control-label">Last Name</label>
      <form:input path="lastName" type="text" placeholder="Last Name" class="form-control" id="inputValid"/>
    </div>
    
    <div class="form-group">
      <label class="form-control-label">Age</label>
      <form:input path="age" type="text" placeholder="Age" class="form-control" id="inputValid"/>
    </div>
    
    <div class="form-group">
       <label>Gender:</label>
       <form:radiobuttons path="gender" items="${gender}"/>
     </div> 
    
    <div class="form-group">
      <label class="form-control-label">Profile Image</label>
      <form:input path="actorImage" type="file" class="form-control"/>
    </div>

    <button type="submit" class="btn btn-primary btn-lg">Add</button>
    </fieldset>
</form:form>
</div>