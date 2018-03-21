<%@ include file="/WEB-INF/views/taglib.jsp" %>
        
        <div class="col-lg-6 col-md-5 col-sm-4">
<form:form action="/play/edit/${editPlay.id}"
                       method="POST"
                       modelAttribute="editPlay"
                       enctype="multipart/form-data">
  <fieldset>
    <legend>Edit Form</legend>
    
    <div class="form-group">
			<form:errors path="*" cssClass="error" />
		</div>
    <form:hidden path="id"/>
    <div class="form-group">
      <label class="form-control-label">Name</label>
      <form:input path="name" type="text" placeholder="Name" class="form-control" id="inputValid"/>
    </div>
    
    <div class="form-group">
      <label class="form-control-label">Price</label>
      <form:input path="price" type="text" placeholder="Price" class="form-control" id="inputValid"/>
    </div>
    
    <div class="form-group">
       <label>Genre:</label>
       <form:radiobuttons path="genre" items="${genres}"/>
     </div> 
     
    
    <div class="form-group">
      <label class="form-control-label">Play Image</label>
      <form:input path="playImage" type="file" class="form-control"/>
    </div>

    <button type="submit" class="btn btn-primary btn-lg">Edit</button>
    </fieldset>
</form:form>
</div>