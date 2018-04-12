<%@ include file="/WEB-INF/views/taglib.jsp"%>

<div id="app">
	<div class="row">
		<div class="col-lg-4 col-md-3 col-sm-2 ">
			<div class="list-group">
				<img alt="Profile" class="list-group-item rounded"
					src="data:img/png; base64, ${playImageSrc }" height="400px"
					width="300px">

			</div>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a href="/session/edit/${session.id}"
					class="btn btn-outline-warning btn-lg">Edit</a>
			</sec:authorize>
		</div>

		<div class="col-lg-3 col-md-3 col-sm-2">

			<ul class="list-group">
				<li class="list-group-item list-group-item-action">Date:
					${session.date }</li>
				<li class="list-group-item list-group-item-action">Time:
					${session.time }</li>
				<li class="list-group-item list-group-item-action">Play:
					${session.play.name }</li>
			</ul>

		</div>

		<div class="col-lg-4 col-md-4 col-sm-4" style="margin-left: 50px">

		</div>
	</div>

	<div class="row">
		<div class="col-lg-12 col-md-8 col-sm-6">
			<div class="list-group">
				<button class="btn btn-outline-info btn-lg" @click="see = !see">Booked
					places</button>

				<table class="table table-hover" v-if="see">
					<thead>
						<tr>
							<sec:authorize access="hasRole('ROLE_ADMIN')"><th scope="col">Id</th>
							<th scope="col">Visitor</th></sec:authorize>
							<th scope="col">Row</th>
							<th scope="col">Seat</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ticketsList}" var="ticket">
							<tr>
								<sec:authorize access="hasRole('ROLE_ADMIN')"><th scope="row">${ticket.id}</th>
								<td>${ticket.visitor.firstName }</td></sec:authorize>
								<td>${ticket.numberOfRow }</td>
								<td>${ticket.numberOfSeat }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>

</div>


<script src="${pageContext.request.contextPath}/resources/js/actor.js"></script>