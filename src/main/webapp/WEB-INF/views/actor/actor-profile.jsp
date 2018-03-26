<%@ include file="/WEB-INF/views/taglib.jsp" %>

<div class="row">
<div class="col-lg-4 col-md-3 col-sm-2">
<div class="list-group">

  <ul class="list-group">
    <li class="list-group-item list-group-item-action">First Name: ${actor.firstName }</li>
    <li class="list-group-item list-group-item-action">Last Name: ${actor.lastName }</li>
    <li class="list-group-item list-group-item-action">Age: ${actor.age }</li>
    <li class="list-group-item list-group-item-action">Gender: ${actor.gender }</li>
  </ul>
  
 </div>
     <sec:authorize access="hasRole('ROLE_ADMIN')">
       <a href="/actor/edit/${actor.id}" class="btn btn-outline-warning btn-lg">Edit</a> 
     </sec:authorize>
</div> 
<div class="col-lg-4 col-md-3 col-sm-2 offset-lg-4">
<img alt="Profile" class="list-group-item rounded" src="data:img/png; base64, ${actorImageSrc }" height="400px" width="300px">
</div>
</div>
<div class="row">
<div class="col-lg-12 col-md-8 col-sm-6">
<h2>Example body text</h2>
          <p>Nullam quis risus eget <a href="#">urna mollis ornare</a> vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam id dolor id nibh ultricies vehicula.Ut laoreet, sem ac pharetra molestie, magna quam sodales sem, in aliquam velit lorem nec magna. Aenean a nunc a risus vestibulum varius a quis mauris. Sed in tincidunt justo. Ut augue massa, fringilla sit amet rutrum sit amet, cursus in erat. Cras finibus lectus vel nulla aliquam dignissim. Proin imperdiet ex nisi, id euismod metus pellentesque quis. Phasellus faucibus tempor est. Phasellus at euismod ex, sit amet lobortis sapien. Donec varius, lectus accumsan sollicitudin pharetra, leo augue mattis tellus, eget auctor ante urna sit amet turpis. Sed imperdiet, augue convallis mattis egestas, massa elit scelerisque turpis, hendrerit sollicitudin erat neque sed lorem. Sed tincidunt rutrum faucibus. Aenean condimentum augue ut nibh suscipit rhoncus. Etiam sed pulvinar metus. Aenean vulputate tempus feugiat. Nunc elit ante, condimentum quis ultrices nec, ultrices ut leo.</p>
</div>
</div>