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
     <label class="form-control-label">Genre:</label>
     <form:select path="genres" class="form-control">
     <c:forEach items="${genres }" var="genre">
      <form:option value="${genre }">${genre }</form:option>
     </c:forEach>
     </form:select>
     </div> 
     
     <div class="form-group">
     <label class="form-control-label">Actors:</label>
     <form:select path="actors" class="form-control">
     <c:forEach items="${actorList }" var="actor">
      <form:option value="${actor }">${actor.firstName } ${actor.lastName }</form:option>
     </c:forEach>
     </form:select>
     </div> 
    
    <div class="form-group">
      <label class="form-control-label">Play Image</label>
      <form:input path="playImage" type="file" class="form-control"/>
    </div>

    <button type="submit" class="btn btn-outline-warning btn-lg">Edit</button>
    </fieldset>
</form:form>
</div>