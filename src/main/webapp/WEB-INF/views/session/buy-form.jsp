<%@ include file="/WEB-INF/views/taglib.jsp" %>
        
    <div class="col-lg-6 col-md-5 col-sm-4">
<form:form action="/visitor/buy/${editSession.id}"
                       method="POST"
                       modelAttribute="editModel"
                       >
  <fieldset>
    <legend>Session Buy Form</legend>
    <label class="form-control-label">Your balance: ${editModel.balance } $</label>
    
     <div class="form-group">
     <label class="form-control-label">Chose seats:</label>
     <small  class="form-text text-muted">Between: 1-30</small>
     <form:select path="seats" class="form-control">
     <c:forEach items="${seatsList }" var="seat">
      <form:option value="${seat }"> </form:option>
     </c:forEach>
     </form:select>
     </div>  
    
    
    <button type="submit" class="btn btn-outline-success btn-lg">Buy</button>
    </fieldset>
</form:form>
</div>