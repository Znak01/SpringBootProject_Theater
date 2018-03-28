<%@ include file="/WEB-INF/views/taglib.jsp" %>

        <div class="col-lg-12 col-md-10 col-sm-8">
       <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Date</th>
      <th scope="col">Time</th>
      <th scope="col">Play</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${sessionList}" var="session">
    <tr>
      <th scope="row">${session.id}</th>
      <td>${session.date}</td>
      <td>${session.time}</td>
      <td>${session.play.name}</td>
      <td class="info"><a href="/session/${session.id}" class="btn btn-outline-info">View</a>
                       <a href="/session/edit/${session.id}" class="btn btn-outline-warning">Edit</a>
                       <a href="/session/buy/${session.id}" class="btn btn-outline-success">Buy</a></td>
    </tr>
    </c:forEach>
    </tbody>
    </table>
    </div>