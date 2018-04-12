<%@ include file="/WEB-INF/views/taglib.jsp" %>

<div class="row">
<div class="col-lg-4 col-md-4 col-sm-4" style="padding-bottom:10px">
<form class="form-inline my-2 my-lg-0"
      action="/visitor/list/filter"
      method="get">
      <input class="form-control mr-sm-2" name="search" type="text" placeholder="Search by Login">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
</div>
</div>

        <div class="col-lg-12 col-md-10 col-sm-8">
       <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Login</th>
      <th scope="col">Email</th>
      <th scope="col">Full Name</th>
      <th scope="col">Age</th>
      <th scope="col">Balance</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${visitorListByPageSize}" var="visitor">
    <tr>
      <th scope="row">${visitor.id}</th>
      <td>${visitor.login}</td>
      <td>${visitor.email}</td>
      <td>${visitor.firstName} ${visitor.lastName }</td>
      <td>${visitor.age }</td>
      <td>${visitor.balance}</td>
      <td class="info"><a href="/visitor/${visitor.id}" class="btn btn-outline-info">View</a>
                       <a href="/visitor/edit/${visitor.id}" class="btn btn-outline-warning">Edit</a>
                       <a href="/visitor/delete/${visitor.id}" class="btn btn-outline-danger">Delete</a>
                       </td>
    </tr>
    </c:forEach> 
    </tbody>
    </table>
    </div>
    
<c:url var="firstUrl" value="/visitor/list?page=0" />
<c:url var="prevUrl" value="/visitor/list?page=${currentIndex - 1 }" />
<c:url var="nextUrl" value="/visitor/list?page=${currentIndex + 1 }" />
<div class="row">
    <div class="col-lg-12 col-md-4 col-sm-4 d-flex justify-content-center" style="padding-top:40px">
        <div class="pagination">
            <ul class="pagination pagination-lg">
                <c:choose>
                    <c:when test="${currentIndex == 0 }">
                        <li class="page-item disabled">
                            <a class="page-link" href="${prevUrl}">&laquo;</a>
                        </li>
                        <li class="page-item disabled">
                            <a class="page-link" href="${firstUrl}">1</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item">
                            <a class="page-link" href="${prevUrl}">&laquo;</a>
                        </li>

                    </c:otherwise>
                </c:choose>

                <c:forEach var="i" begin="${beginIndex }" end="${endIndex }">
                    <c:url var="pageUrl" value="/visitor/list?page=${i+1}" />

                    <c:choose>
                        <c:when test="${i == currentIndex }">
                            <li class="page-item disabled">
                                <a class="page-link" href="${pageUrl  } ">
                                    <c:out value="${i+1 }" />
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link" href="${pageUrl }">
                                    <c:out value="${i+1 }" />
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:choose>
                    <c:when test="${currentIndex == visitorList.totalPages - 1}">
                        <li class="page-item disabled">
                            <a class="page-link" href="${nextUrl}">&raquo;</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item">
                            <a class="page-link" href="${nextUrl}">&raquo;</a>
                        </li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>
    </div>
</div>  
    