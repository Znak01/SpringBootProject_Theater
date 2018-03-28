<%@ include file="/WEB-INF/views/taglib.jsp" %>
        
    <div class="col-lg-6 col-md-5 col-sm-4">
<form:form action="/session/add"
                       method="POST"
                       modelAttribute="session">
  <fieldset>
    <legend>Session Add Form</legend>
    
    <div class="form-group">
			<form:errors path="*" class="text-danger" />
		</div>
    
    <div class="form-group">
      <label class="form-control-label">Chose date:</label>
      <form:input path="date" type="date"  class="form-control" id="inputValid"/>
    </div>
    <div class="form-group">
      <label class="form-control-label">Chose time:</label>
      <form:input path="time" type="time"  class="form-control" id="inputValid"/>
    </div>
    
    <div class="form-group">
      <label class="form-control-label">Chose the play:</label>
      <form:select path="play" class="form-control">
             <c:forEach items="${playList}" var="play">
               <form:option value="${play}">${play.name}</form:option>
             </c:forEach>
             </form:select>
    </div>
    
    <button type="submit" class="btn btn-outline-success btn-lg">Add</button>
    </fieldset>
</form:form>
</div>