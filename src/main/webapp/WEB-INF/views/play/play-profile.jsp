<%@ include file="/WEB-INF/views/taglib.jsp" %>

<div class="row">
<div class="col-lg-4 col-md-2 col-sm-2">
<div class="card">
  <img alt="Profile" class="" src="data:img/png; base64, ${playImageSrc }" height="400px" width="100%">
  <div class="card-body">
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item list-group-item-action">Name: ${play.name }</li>
    <li class="list-group-item list-group-item-action">Genre: ${play.genres }</li>
    <li class="list-group-item list-group-item-action">Price: ${play.price }</li>
  </ul>
  <div class="card-body">
    <sec:authorize access="hasRole('ROLE_ADMIN')">
     <a href="/play/edit/${play.id}" class="btn btn-outline-warning btn-lg">Edit</a> 
    </sec:authorize>
  </div>
   </div>
    </div>
    <div class="col-lg-6 col-md-2 col-sm-2">
       <h2>Example body text</h2>
          <p>Nullam quis risus eget <a href="#">urna mollis ornare</a> vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam id dolor id nibh ultricies vehicula.Ut laoreet, sem ac pharetra molestie, magna quam sodales sem, in aliquam velit lorem nec magna. Aenean a nunc a risus vestibulum varius a quis mauris. Sed in tincidunt justo. Ut augue massa, fringilla sit amet rutrum sit amet, cursus in erat. Cras finibus lectus vel nulla aliquam dignissim. Proin imperdiet ex nisi, id euismod metus pellentesque quis. Phasellus faucibus tempor est. Phasellus at euismod ex, sit amet lobortis sapien. Donec varius, lectus accumsan sollicitudin pharetra, leo augue mattis tellus, eget auctor ante urna sit amet turpis. Sed imperdiet, augue convallis mattis egestas, massa elit scelerisque turpis, hendrerit sollicitudin erat neque sed lorem. Sed tincidunt rutrum faucibus. Aenean condimentum augue ut nibh suscipit rhoncus. Etiam sed pulvinar metus. Aenean vulputate tempus feugiat. Nunc elit ante, condimentum quis ultrices nec, ultrices ut leo.</p>
  <div class="col-lg-12 col-md-3 col-sm-2">
<div class="list-group">
<button class="btn btn-outline-info btn-lg" @click="see = !see">Show Actorss</button>
 <ul class="list-group" v-if="see">
 <li class="list-group-item list-group-item-action">Name: ${play.name }</li>
    <li v-for="play in plays" class="list-group-item list-group-item-action">Actor Name: {{play.actors.firstName }} {{play.actors.lastName }}</li>
  </ul>
</div>
</div>
  </div>
</div>