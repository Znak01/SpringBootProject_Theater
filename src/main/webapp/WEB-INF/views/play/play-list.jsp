<%@ include file="/WEB-INF/views/taglib.jsp" %>

        <%-- <div class="col-lg-12 col-md-10 col-sm-8">
       <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Genres</th>
      <th scope="col">Price</th>
      <th scope="col">Profile</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${playList}" var="play">
    <tr>
      <th scope="row">${play.id}</th>
      <td>${play.name}</td>
      <td>${play.genres}</td>
      <td>${play.price}</td>
      <td class="info"><a href="/play/${play.id}" class="btn btn-outline-info">View</a></td>
    </tr>
    </c:forEach>
    </tbody>
    </table>
    </div> --%>
    
    <div v-for="play in plays">
    <div class="row">
       <div class="col-lg-4 col-md-10 col-sm-8">
         <img alt="Profile" class="list-group-item rounded" :src="'data:img/png; base64,' + play.playImage" height="400px" width="300px">
       </div>
       <div class="col-lg-6 col-md-10 col-sm-8">
          <h3>{{ play.name }}</h3>
          <h3>{{ play.genres }}</h3>
          
         <a href="/play/{{play.id}} " class="btn btn-outline-info">View</a>
       </div>
    
    </div>
    </div>