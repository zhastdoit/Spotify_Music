<%@ include file="parts/header.jsp" %>
<body>
<div class="container">

    <h2>Artists</h2>
    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Number of Fans</th>
        </tr>

        <!-- loop over and print our customers -->
        <c:set var="i" value="${0}"/>
        <c:forEach var="artist" items="${artistList}">
            <tr>
                <td><a href="/artist/${artist.id}"> ${artist.id} </td>
                <td><a href="/artist/${artist.id}"> ${artist.aname} </td>
                <td><a href="/artist/${artist.id}"> ${numberOfFans.get(i)} </td>
            </tr>
            <c:set var="i" value="${i + 1}"/>
        </c:forEach>

    </table>

    <c:choose>
        <c:when test="${notFirstPage}">
            <div class="col-xs-5 col-md-2 col-md-offset-3">
                <form method="POST" action="${contextPath}/artist/all-page" class="form-signin form-inline">
                    <div class="form-group">
                        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                        <input type="hidden" name="next" class="form-control" value="False">
                        <input type="hidden" name="page" class="form-control" value="${page}">
                    </div>
                    <button type="submit" class="btn btn-default col-xs-12"><- Prev</button>
                </form>
            </div>
            <div class="col-xs-2 col-md-2">
                <h6 style="text-align: center">${page}</h6>
            </div>
            <div class="col-xs-5 col-md-2">
                <form method="POST" action="${contextPath}/artist/all-page" class="form-signin form-inline">
                    <div class="form-group">
                        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                        <input type="hidden" name="next" class="form-control" value="True">
                        <input type="hidden" name="page" class="form-control" value="${page}">
                    </div>
                    <button type="submit" class="btn btn-default col-xs-12">Next -></button>
                </form>
            </div>
        </c:when>
        <c:otherwise>
            <div class="col-md-6">
                <h6 style="text-align: right">${page}</h6>
            </div>
            <div class="col-sm-6 col-md-3">
                <form method="POST" action="${contextPath}/artist/all-page" class="form-signin form-inline">
                    <div class="form-group">
                        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                        <input type="hidden" name="next" class="form-control" value="True">
                        <input type="hidden" name="page" class="form-control" value="${page}">
                    </div>
                    <button type="submit" class="btn btn-default col-xs-12">Next -></button>
                </form>
            </div>
        </c:otherwise>
    </c:choose>
</div>
<%@ include file="parts/footer.jsp" %>
