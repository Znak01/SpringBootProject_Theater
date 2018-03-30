<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

    <%@ include file="../views/taglib.jsp"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <c:choose>
                <c:when test="${title == null}">
                    <tiles:putAttribute name="title" value="App title" />
                </c:when>
                <c:otherwise>
                    <tiles:putAttribute name="title" value="${title}" />
                </c:otherwise>
            </c:choose>

            <title>
                <tiles:getAsString name="title"></tiles:getAsString>
            </title>

            <jsp:include page="/WEB-INF/include/style-include.jsp" />

            

        </head>

        <body>

            <tiles:insertAttribute name="header" />
            
                <div class="container">

                    <%-- <div class="heading">
            <h1>
                <tiles:getAsString name="title"></tiles:getAsString>
            </h1>
        </div> --%>


                        <%-- <tiles:insertAttribute name="sidebar" /> --%>

                            <tiles:insertAttribute name="body" />

                            <tiles:insertAttribute name="footer" />

                </div>
            

            
            

        </body>

        </html>
