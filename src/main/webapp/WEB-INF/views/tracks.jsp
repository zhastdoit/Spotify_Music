<%@ include file="parts/header.jsp" %>
<div class="container">
    <h2>Tracks</h2>
    <div style="overflow-y: auto">
        <table class="table table-hover">
            <tr>
                <th> Add </th>
                <th>Title</th>
                <th>Genre</th>
                <th>Artist</th>
                <th>Length</th>
                <th>Avg Rate</th>
            </tr>

            <!-- loop over and print our customers -->
            <c:forEach var="track" items="${trackList}" varStatus="loop">
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
                    <td><a href="/artist/${track.artist.id}"> ${track.artist.aname} </td>
                    <td> ${(track.tduration/60).intValue().toString()}:${(track.tduration%60).intValue()} </td>
                    <td> ${scores.get(loop.index)} </td>
                </tr>
            </c:forEach>
        </table>
        <c:choose>
            <c:when test="${notFirstPage}">
                <div class="col-xs-5 col-md-2 col-md-offset-3">
                    <form method="POST" action="${contextPath}/track/all" class="form-signin form-inline">
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
                    <form method="POST" action="${contextPath}/track/all" class="form-signin form-inline">
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
                    <form method="POST" action="${contextPath}/track/all" class="form-signin form-inline">
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
</div>
<div style="height: 80px">
</div>
<%@ include file="parts/footer.jsp" %>