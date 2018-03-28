<%@ include file="/WEB-INF/views/taglib.jsp" %>

       <%--  <div class="col-lg-12 col-md-10 col-sm-8">
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
    </div> --%>
    
    
    <div v-for="actor in actors">
    <div class="row">
       <div class="col-lg-4 col-md-10 col-sm-8">
         <img alt="Profile" class="list-group-item rounded" :src="'data:img/png; base64,' + actor.actorImage" height="400px" width="300px">
       </div>
       <div class="col-lg-6 col-md-10 col-sm-8">
          <h3>{{ actor.firstName }} {{ actor.lastName }}</h3>
          
         <a href="/actor/{{actor.id}} " class="btn btn-outline-info">View</a>
       </div>
    
    </div>
    </div>
    
    
    
    <script>
    
    
    </script>