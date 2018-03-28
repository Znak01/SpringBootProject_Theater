<%@ include file="/WEB-INF/views/taglib.jsp" %>

<h1>Admin board</h1>
<div class="row ">
<div class="col-lg-2 col-md-2 col-sm-1">
<ul class="nav nav-pills flex-column">
  
  <li class="nav-item">
    <a class="nav-link" href="actor/add">Add actor</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="play/add">Add Play</a>
  </li>
  
  <li class="nav-item">
    <a class="nav-link" href="session/add">Add Session</a>
  </li>
</ul>
</div>

<div class="col-lg-10 col-md-8 col-sm-7">

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#actor-list">List of Actors</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#play-list">List of Plays</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#session-list">List of Sessions</a>
  </li>
  
</ul>
<div id="myTabContent" class="tab-content">
  <div class="tab-pane fade show active" id="actor-list">
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
  <div class="tab-pane fade show" id="play-list">
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
      <td>${play.genres}</td>
      <td>${play.price}</td>
      <td class="info"><a href="/play/${play.id}" class="btn btn-outline-info">View</a></td>
    </tr>
    </c:forEach>
    </tbody>
    </table>
  </div>
  <div class="tab-pane fade" id="sessin-list">
    
  </div>
  
</div>
</div>
</div>