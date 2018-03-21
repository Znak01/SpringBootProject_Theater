<%@ include file="/WEB-INF/views/taglib.jsp" %>

        <div class="col-lg-12 col-md-10 col-sm-8">
       <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Age</th>
      <th scope="col">Gender</th>
      <th scope="col">Profile</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${actorList}" var="actor">
    <tr>
      <th scope="row">${actor.id}</th>
      <td>${actor.firstName}</td>
      <td>${actor.lastName}</td>
      <td>${actor.age}</td>
      <td>${actor.gender}</td>
      <td class="info"><a href="/actor/${actor.id}" class="btn btn-outline-info">View</a></td>
    </tr>
    </c:forEach>
    </tbody>
    </table>
    </div>