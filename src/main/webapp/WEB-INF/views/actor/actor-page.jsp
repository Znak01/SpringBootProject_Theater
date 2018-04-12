<%@ include file="/WEB-INF/views/taglib.jsp" %>

<div class="row">
<div class="col-lg-4 col-md-4 col-sm-4" style="padding-bottom:10px">
<form class="form-inline my-2 my-lg-0"
      action="/actor/list/pages/filter"
      method="get">
      <input class="form-control mr-sm-2" name="search" type="text" placeholder="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
</div>
</div>

<c:forEach items="${actorListByPageSize }" var="actor">
    <div class="row">
        <div class="col-lg-4 col-md-4 col-sm-4">
            <img alt="Profile" class="list-group-item rounded" src="data:img/png; base64, ${actor.actorImage }" height="400px" width="300px">
        </div>
        <div class="col-lg-6 col-md-4 col-sm-4">
            <h3>${actor.firstName} ${actor.lastName}</h3>

            <a href="/actor/${actor.id} " class="btn btn-outline-info">View</a>
        </div>
    </div>
</c:forEach>

<c:url var="firstUrl" value="/actor/list/pages?page=0" />
<c:url var="prevUrl" value="/actor/list/pages?page=${currentIndex - 1 }" />
<c:url var="nextUrl" value="/actor/list/pages?page=${currentIndex + 1 }" />
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
                    <c:url var="pageUrl" value="/actor/list/pages?page=${i+1}" />

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
                    <c:when test="${currentIndex == actorList.totalPages - 1}">
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

  