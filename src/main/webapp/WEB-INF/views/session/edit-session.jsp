<%@ include file="/WEB-INF/views/taglib.jsp" %>
        
    <div class="col-lg-6 col-md-5 col-sm-4">
<form:form action="/session/edit/${editSession.id}"
                       method="POST"
                       modelAttribute="editSession">
  <fieldset>
    <legend>Session Edit Form</legend>
    
    <div class="form-group">
			<form:errors path="*" class="text-danger" />
		</div>
    <form:hidden path="id"/>
    <div class="form-group">
      <label class="form-control-label">Chose date:</label>
      <form:input path="date" type="date"  class="form-control" id="inputValid"/><form:errors path="date" class="text-danger"/>
    </div>
    <div class="form-group">
      <label class="form-control-label">Chose time:</label>
      <form:input path="time" type="time"  class="form-control" id="inputValid"/><form:errors path="time" class="text-danger"/>
    </div>
    
    <div class="form-group">
      <label class="form-control-label">Chose the play:</label>
      <form:select path="play" class="form-control">
             <c:forEach items="${playList}" var="play">
               <form:option value="${play}">${play.name}</form:option>
             </c:forEach>
             </form:select><form:errors path="play" class="text-danger"/>
    </div>
    
    <button type="submit" class="btn btn-outline-warning btn-lg">Edit</button>
    </fieldset>
</form:form>
</div>