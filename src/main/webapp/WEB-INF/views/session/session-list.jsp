<%@ include file="/WEB-INF/views/taglib.jsp" %>

        <div class="col-lg-12 col-md-10 col-sm-8">
       <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Date</th>
      <th scope="col">Time</th>
      <th scope="col">Play</th>
      <th scope="col">Profile</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${sessionList}" var="session">
    <tr>
      <th scope="row">${session.id}</th>
      <td>${session.Date}</td>
      <td>${session.Time}</td>
      <td>${session.Play}</td>
      <%-- <td class="info"><a href="/session/${session.id}" class="btn btn-outline-info">View</a></td> --%>
    </tr>
    </c:forEach>
    </tbody>
    </table>
    </div>