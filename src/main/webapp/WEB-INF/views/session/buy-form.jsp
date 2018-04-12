<%@ include file="/WEB-INF/views/taglib.jsp" %>
        
    <div class="col-lg-12 col-md-8 col-sm-6">
<form:form action="/visitor/buy/${ticketModel.session.id}"
                       method="POST"
                       modelAttribute="ticketModel"
                       >
  <fieldset>
    <legend>Session Buy Form</legend>
    <div class="form-group">
			<form:errors path="*" class="text-danger" />
	</div>
    
    <div class="row">
    <div class="col-lg-4 col-md-4 col-sm-4">
    <h4>Cost: ${ticketModel.session.play.price } $</h4>
    <label class="form-control-label">Your balance: ${ticketModel.visitor.balance } $</label>
     <h3>Chose your place </h3>
     
     <div class="form-group">
       <label>Chose Row:</label>
       <form:radiobuttons path="numberOfRow" items="${rowList}" style="margin: 0 7px"  /><form:errors path="numberOfRow" class="text-danger"/>
     </div> 
     
     <div class="form-group">
     <label class="form-control-label">Chose Seats:</label>
     <form:select  path="numberOfSeat" class="form-control" items="${seatsList }"></form:select><form:errors path="numberOfSeat" class="text-danger"/>
     </div> 
     
     </div> 
     
     <div class="col-lg-6 col-md-4 col-sm-4" style="margin-left:50px">
     <h3>Booked places: </h3>
     <ul class="list-group">
     <c:forEach items="${ticketsList }" var="ticket">
     <li class="list-group-item list-group-item-action">Row: ${ticket.numberOfRow } Seat: ${ticket.numberOfSeat }</li>
      </c:forEach>
       </ul>
     </div> 
     </div>
    
    <button type="submit" class="btn btn-outline-success btn-lg">Buy</button>
    </fieldset>
</form:form>
</div>