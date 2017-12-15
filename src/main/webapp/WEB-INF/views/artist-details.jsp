<%@ include file="parts/header.jsp" %>
<body>
<div class="container">
    <div class="col-sm-2">
        <img src="${artist.aimage}" class="img-circle" height="140" width="140">
    </div>
    <h2>${artist.aname}</h2>
    <h5 style="white-space:pre"> <span class="glyphicon glyphicon-heart" aria-hidden="true"> Fans: ${numberOfFans}  </h5>
    <div class="col-xs-12">
        <c:choose>
            <c:when test="${isLiking}">
                <form method="POST" action="${contextPath}/artist/${artist.id}/new" class="form-signin">
                    <div class="form-group">
                        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                        <input type="hidden" name="likeStatus" class="form-control" value="False">
                    </div>
                    <button type="submit" class="btn btn-default btn-xs" style="width: 200px">UnLike</button>
                </form>
            </c:when>
            <c:otherwise>
                <form method="POST" action="${contextPath}/artist/${artist.id}/new" class="form-signin">
                    <div class="form-group">
                        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                        <input type="hidden" name="likeStatus" class="form-control" value="True">
                    </div>
                    <button type="submit" class="btn btn-default btn-xs" style="width: 200px">Like</button>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
    <p class="lead"> ${artist.description} </p>
    <table class="table table-hover">
        <tr>
            <th>+ ADD</th>
            <th>Name</th>
            <th>Genre</th>
            <th>LENGTH</th>
        </tr>

        <!-- loop over and print our customers -->
        <c:forEach var="track" items="${track}">
            <tr>
                <td> <button type="button" class="btn btn-default" aria-label="Left Align">
                    <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
                </button> </td>
                <td>
                    <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${pageContext.request.userPrincipal.name}<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <%--<c:forEach>--%>
                            <%--<li>${playlist.pname}</li>--%>
                        <%--</c:forEach>--%>
                        <li role="separator" class="divider"></li>
                        <li><a onclick="document.forms['logoutForm'].submit()">Logout</a></ul></li>
                    <a href="javascript:{}" onclick="document.getElementById('rate').submit();">Rate</a>
                </ul>
                </li>
                </td>
                <td><a href="/track/${track.id}"> ${track.ttitle} </td>
                <td><a href="/track/${track.id}"> ${track.genre} </td>
                <td> ${(track.tduration/60).intValue().toString()}:${(track.tduration%60).intValue()} </td>
            </tr>

        </c:forEach>

    </table>

</div>
<div style="height :80px;"></div>
<%@ include file="parts/footer.jsp" %>