<%@ include file="/WEB-INF/views/taglib.jsp" %>

<img alt="Profile" class="list-group-item" src="data:img/png; base64, ${actorImageSrc }" width="300px">
<div class="col-lg-6 col-md-5 col-sm-4">
<div class="list-group">
 
  <a href="#" class="list-group-item list-group-item-action">First Name: ${actor.firstName }</a>
  <a href="#" class="list-group-item list-group-item-action">Last Name: ${actor.lastName }</a>
  <a href="#" class="list-group-item list-group-item-action">Age: ${actor.age }</a>
  <a href="#" class="list-group-item list-group-item-action">Gender: ${actor.gender }</a> 
  
 </div>
     <a href="/actor/edit/${actor.id}" class="btn btn-primary btn-lg">Edit</a> 
</div> 