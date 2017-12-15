<%@ include file="parts/header.jsp" %>
<body>
<div class="container">
    <div class="col-lg-2 col-md-3 col-sm-4 col-xs-12">
        <img src="${artist.aimage}" class="img-circle" height="140" width="140">
    </div>
    <div class="col-lg-10 col-md-9 col-sm-8 col-xs-12" style="margin-bottom: 30px;">
        <h2>${artist.aname}</h2>
        <h5 style="white-space:pre"> &#10084; Fans: ${numberOfFans}  </h5>
        <p class="lead" style="margin-bottom: 0px"> ${artist.description} </p>
        <div>
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
    </div>

    <div class="row" style="margin-top: 30px">
        <table class="table table-hover">
            <tr>
                <th>ADD</th>
                <th>Name</th>
                <th>Genre</th>
                <th>Duration</th>
            </tr>

        <!-- loop over and print our customers -->
            <c:forEach var="track" items="${track}">
                <tr>
                    <td>
                        <li class="dropdown" style="color: white;">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span></a>
                            <ul class="dropdown-menu">
                                <c:forEach var="playlist" items="${playlists}">
                                        <li><a href="/playlist/${playlist.pid}/addToPlaylist/${track.id}"> ${playlist.pname} </a></li>
                                </c:forEach>
                                <li role="separator" class="divider"></li>
                                <li><a href="/playlist/newplaylist">New Playlist</a></li>
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

</div>
<div style="height :80px;"></div>
<%@ include file="parts/footer.jsp" %>