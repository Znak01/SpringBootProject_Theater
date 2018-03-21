<%@ include file="/WEB-INF/views/taglib.jsp" %>

<img alt="Profile" class="list-group-item" src="data:img/png; base64, ${imageSrc }" width="300px">
<div class="col-lg-6 col-md-5 col-sm-4">
<div class="list-group">
 
  <a href="#" class="list-group-item list-group-item-action">Login: ${visitor.login }</a>
  <a href="#" class="list-group-item list-group-item-action">Email: ${visitor.email }</a>
  <a href="#" class="list-group-item list-group-item-action">First Name: ${visitor.firstName }</a>
  <a href="#" class="list-group-item list-group-item-action">Last Name: ${visitor.lastName }</a>
  <a href="#" class="list-group-item list-group-item-action">Age: ${visitor.age }</a>
  <a href="#" class="list-group-item list-group-item-action">Mobile: ${visitor.mobile }</a>
  <a href="#" class="list-group-item list-group-item-action">Gender: ${visitor.gender }</a> 
  
</div>
<a href="/visitor/edit/${visitor.id}" class="btn btn-primary btn-lg">Edit</a>
</div>