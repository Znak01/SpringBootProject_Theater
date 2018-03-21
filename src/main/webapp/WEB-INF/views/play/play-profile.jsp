<%@ include file="/WEB-INF/views/taglib.jsp" %>

<img alt="Profile" class="list-group-item" src="data:img/png; base64, ${playImageSrc }" width="300px">
<div class="col-lg-6 col-md-5 col-sm-4">
<div class="list-group">
 
  <a href="#" class="list-group-item list-group-item-action">Name: ${play.name }</a>
  <a href="#" class="list-group-item list-group-item-action">Genre: ${play.genre }</a>
  <a href="#" class="list-group-item list-group-item-action">Price: ${play.price }</a>
  
 </div>
     <a href="/play/edit/${play.id}" class="btn btn-primary btn-lg">Edit</a> 
</div> 