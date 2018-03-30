<%@ include file="/WEB-INF/views/taglib.jsp" %>
    
    <div id="app">
    <div v-for="actor in actors">
    <div class="row">
       <div class="col-lg-4 col-md-10 col-sm-8">
         <img alt="Profile" class="list-group-item rounded" :src="'data:img/png; base64,' + actor.actorImage" height="400px" width="300px">
       </div>
       <div class="col-lg-6 col-md-10 col-sm-8">
          <h3>{{ actor.firstName }} {{ actor.lastName }}</h3>
          
         <a :href="'/actor/' + actor.id " class="btn btn-outline-info">View</a>
       </div>
    
    </div>
    </div>
    </div>
    
    
    <script src="${pageContext.request.contextPath}/resources/js/actor.js"></script>