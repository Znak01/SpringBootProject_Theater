<%@ include file="/WEB-INF/views/taglib.jsp" %>
        
    <div class="col-lg-6 col-md-5 col-sm-4">
<form:form action="/session/buy/${editSession.id}"
                       method="POST"
                       modelAttribute="editSession">
  <fieldset>
    <legend>Session Buy Form</legend>
    
		
    
    
    <button type="submit" class="btn btn-outline-success btn-lg">Buy</button>
    </fieldset>
</form:form>
</div>