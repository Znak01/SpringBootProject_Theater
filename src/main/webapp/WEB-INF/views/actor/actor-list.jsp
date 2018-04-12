<%@ include file="/WEB-INF/views/taglib.jsp" %>
    
    <template id="pagination-template">
    <div class="pagination">
  <ul class="pagination pagination-lg">
    <li class="page-item">
      <a class="page-link pagination_left" href="#" @click="changePage(prevPage)">&laquo;</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">1</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">2</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">3</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">4</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">5</a>
    </li>
    <li class="page-item">
      <a class="page-link pagination_right" href="#" @click="changePage(nextPage)">&raquo;</a>
    </li>
  </ul>
</div>
    </template>
    
    <div id="app">
    
    <pagination :current="currentPage" @page-changed="getActors"></pagination>
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
    
    <script src="${pageContext.request.contextPath}/resources/js/pagination.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/actor.js"></script>