<%@ include file="/WEB-INF/views/taglib.jsp" %>
        
    <div class="col-lg-6 col-md-5 col-sm-4">
<form:form action="/play/add"
                       method="POST"
                       modelAttribute="play"
                       enctype="multipart/form-data">
  <fieldset>
    <legend>Play Add Form</legend>
    
    <div class="form-group">
			<form:errors path="*" cssClass="error" />
		</div>
    
    <div class="form-group">
      <label class="form-control-label">Name</label>
      <form:input path="name" type="text" placeholder="Name" class="form-control" id="inputValid"/>
    </div>
    
    <div class="form-group">
      <label class="form-control-label">Price</label>
      <form:input path="price" type="text" placeholder="Price" class="form-control" id="inputValid"/>
    </div>
    
    <div class="form-group">
     <label class="form-control-label">Genre:</label>
     <form:select path="genres" class="form-control">
     <c:forEach items="${genres }" var="genre">
      <form:option value="${genre }">${genre }</form:option>
     </c:forEach>
     </form:select>
     </div> 
    

    <button type="submit" class="btn btn-outline-success btn-lg">Add</button>
    </fieldset>
</form:form>
</div>