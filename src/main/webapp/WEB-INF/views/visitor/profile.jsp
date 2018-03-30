<%@ include file="/WEB-INF/views/taglib.jsp" %>

<div class="row">
<div class="col-lg-4 col-md-3 col-sm-2">
<div class="list-group">

  <ul class="list-group">
    <li class="list-group-item list-group-item-action">Login: ${visitor.login }</li>
    <li class="list-group-item list-group-item-action">Email: ${visitor.email }</li>
    <li class="list-group-item list-group-item-action">First Name: ${visitor.firstName }</li>
    <li class="list-group-item list-group-item-action">Last Name: ${visitor.lastName }</li>
    <li class="list-group-item list-group-item-action">Age: ${visitor.age }</li>
    <li class="list-group-item list-group-item-action">Mobile: ${visitor.mobile }</li>
    <li class="list-group-item list-group-item-action">Gender: ${visitor.gender }</li>
    <li class="list-group-item list-group-item-action">Balance: ${visitor.balance } $</li>
  </ul>
  
 </div>
       <a href="/visitor/edit/${visitor.id}" class="btn btn-outline-warning btn-lg">Edit</a>
 </div>
 <div class="col-lg-4 col-md-3 col-sm-2 offset-lg-4">
<img alt="Profile" class="list-group-item rounded" src="data:img/png; base64, ${imageSrc }" width="300px">
</div>
</div>