<%@ include file="parts/header.jsp" %>
<body>
<div class="container">
    <div class="col-sm-2">
        <img src="${album.alimage}" class="img-thumbnail" height="140" width="140">
    </div>
    <h2>${album.atitle}</h2>

    <table class="table table-hover">
        <tr>
            <th> ADD </th>
            <th>Name</th>
            <th>Genre</th>
            <th>LENGTH</th>
            <th>SCORE</th>
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
                <td> ${(track.tduration/60).intValue().toString()}:${(track.tduration%60).intValue()} </td>
                <td> ${scores.get(loop.index)} </td>
            </tr>

        </c:forEach>

    </table>

</div>
<div style="height: 80px;"></div>
<%@ include file="parts/footer.jsp" %>