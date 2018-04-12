<%@ include file="/WEB-INF/views/taglib.jsp" %>

        <div class="col-lg-6 col-md-5 col-sm-4">
<form:form action="/visitor/recharge/${editModel.id}"
                       method="POST"
                       modelAttribute="editModel"
                       enctype="multipart/form-data">
  <fieldset>
    <legend>Balance Form</legend>
    
    <div class="form-group">
			<form:errors path="*" cssClass="error" />
		</div>
		
    <div class="form-group">
      <label class="form-control-label">Balance</label>
      <form:input path="balance" type="text" placeholder="Balance" class="form-control" id="inputValid"/><form:errors path="balance" class="text-danger"/>
    </div>
    
    <button type="submit" class="btn btn-outline-success btn-lg">Charge</button>
    
    </fieldset>
</form:form>
</div>
        