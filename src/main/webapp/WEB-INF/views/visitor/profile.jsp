<%@ include file="/WEB-INF/views/taglib.jsp" %>
 <div id="app">
<div class="row">
<div class="col-lg-4 col-md-3 col-sm-2">

  <ul class="list-group">
    <li class="list-group-item list-group-item-action">Login: ${visitor.login }</li>
    <li class="list-group-item list-group-item-action">Email: ${visitor.email }</li>
    <li class="list-group-item list-group-item-action">First Name: ${visitor.firstName }</li>
    <li class="list-group-item list-group-item-action">Last Name: ${visitor.lastName }</li>
    <li class="list-group-item list-group-item-action">Mobile: ${visitor.mobile }</li>
    <li class="list-group-item list-group-item-action">Gender: ${visitor.gender }</li>
    <li class="list-group-item list-group-item-action">Balance: ${visitor.balance } $</li>
    
  </ul>
  
       <a href="/visitor/edit/${visitor.id}" class="btn btn-outline-warning btn-lg">Edit</a>
       <a href="/visitor/recharge/${visitor.id}" class="btn btn-outline-success btn-lg">Rechage the Balance</a>



			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a href="/visitor/block/${visitor.id}"
					class="btn btn-outline-danger btn-lg" style="margin-top: 10px">Block</a>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a href="/visitor/unblock/${visitor.id}"
					class="btn btn-outline-secondary btn-lg" style="margin-top: 10px">Unblock</a>
			</sec:authorize>

		</div>
 
 <div class="col-lg-4 col-md-3 col-sm-2">
<div class="list-group">
<button class="btn btn-outline-info btn-lg" @click="see = !see">My tickets</button>
 <ul class="list-group" v-if="see">
 <c:forEach items="${ticketList }" var="ticket">
    <li class="list-group-item list-group-item-action">Play: ${ticket.session.play.name } | Row: ${ticket.numberOfRow } | Seat: ${ticket.numberOfSeat }
                                                       <a href="/visitor/delete/ticket/${ticket.id}" class="btn btn-outline-danger">Cancel</a></li>
      </c:forEach>
<%--  <li class="list-group-item list-group-item-action">Actor's Plays: ${actor.plays }</li> --%>
  </ul>
</div>
</div>
 
 <div class="col-lg-4 col-md-3 col-sm-2">
 <div class="list-group">
<img alt="Profile" class="list-group-item rounded" src="data:img/png; base64, ${imageSrc }" width="300px">
</div>
</div>
</div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/actor.js"></script>