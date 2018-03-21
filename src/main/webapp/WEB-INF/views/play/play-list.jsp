<%@ include file="/WEB-INF/views/taglib.jsp" %>

        <div class="col-lg-12 col-md-10 col-sm-8">
       <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Genre</th>
      <th scope="col">Price</th>
      <th scope="col">Profile</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${playList}" var="play">
    <tr>
      <th scope="row">${play.id}</th>
      <td>${play.name}</td>
      <td>${play.genre}</td>
      <td>${play.price}</td>
      <td class="info"><a href="/play/${play.id}" class="btn btn-outline-info">View</a></td>
    </tr>
    </c:forEach>
    </tbody>
    </table>
    </div>