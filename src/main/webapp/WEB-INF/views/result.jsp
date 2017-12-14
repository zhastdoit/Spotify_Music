<%@ include file="parts/header.jsp" %>
<body>
<div class="container">
    <h2>Tracks</h2>
    <div style="overflow-y: auto">
        <c:choose>
            <c:when test="${hasTrackList}">
                <table class="table table-hover">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">TRACK</h3>
                        </div>
                        <div class="panel-body">
                            <table class="table table-hover">
                                <tr>
                                    <th>+ ADD </th>
                                    <th>Title</th>
                                    <th>GENRE</th>
                                    <th>ARTIST</th>
                                    <th>Length</th>
                                    <%--<th>Score</th>--%>
                                </tr>

                                <!-- loop over and print our customers -->
                                <c:forEach var="track" items="${trackResult}">
                                <tr>
                                    <td> <button type="button" class="btn btn-default" aria-label="Left Align">
                                        <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
                                    </button> </td>
                                    <td><a href="/track/${track.id}"> ${track.ttitle} </td>

                                    <td><a href="/track/${track.id}"> ${track.genre} </td>
                                    <td><a href="/artist/${track.artist.id}"> ${track.artist.aname} </td>
                                    <td> ${(track.tduration/60).intValue().toString()}:${(track.tduration%60).intValue()} </td>
                                        <%--<td> ${scores.get(track.id.intValue() - 1)} </td>--%>

                                </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </table>
            </c:when>
            <c:otherwise>
            <table class="table table-hover">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">TRACK</h3>
                    </div>
                    <div class="panel-body">
                        <table class="table table-hover">
                            <tr>
                                <th>NOTHING... HAVE ANOTHER TRY... </th>
                            </tr>
                        </table>
                    </div>
                </div>
            </table>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${hasTrackGenreList}">
                <table class="table table-hover">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">TRACK GENRE</h3>
                        </div>
                        <div class="panel-body">
                            <table class="table table-hover">
                                <tr>
                                    <th>+ ADD </th>
                                    <th>Title</th>
                                    <th>GENRE</th>
                                    <th>ARTIST</th>
                                    <th>Length</th>
                                        <%--<th>Score</th>--%>
                                </tr>

                                <!-- loop over and print our customers -->
                                <c:forEach var="track" items="${trackGenreResult}">
                                    <tr>
                                        <td> <button type="button" class="btn btn-default" aria-label="Left Align">
                                            <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
                                        </button> </td>
                                        <td><a href="/track/${track.id}"> ${track.ttitle} </td>

                                        <td><a href="/track/${track.id}"> ${track.genre} </td>
                                        <td><a href="/artist/${track.artist.id}"> ${track.artist.aname} </td>
                                        <td> ${(track.tduration/60).intValue().toString()}:${(track.tduration%60).intValue()} </td>
                                            <%--<td> ${scores.get(track.id.intValue() - 1)} </td>--%>

                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </table>
            </c:when>
            <c:otherwise>
                <table class="table table-hover">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">TRACK</h3>
                        </div>
                        <div class="panel-body">
                            <table class="table table-hover">
                                <tr>
                                    <th>NOTHING... HAVE ANOTHER TRY... </th>
                                </tr>
                            </table>
                        </div>
                    </div>
                </table>
            </c:otherwise>
        </c:choose>


        <c:choose>
            <c:when test="${hasAlbumList}">
                <table class="table table-hover">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">ALBUM</h3>
                        </div>
                        <div class="panel-body">
                            <table class="table table-hover">
                                <tr>
                                    <th>Album ID</th>
                                    <th>Title</th>

                                </tr>
                                <c:forEach var="tempAlbum" items="${albumResult}">
                                    <tr>
                                        <td><a href="/album/${tempAlbum.alid}"> ${tempAlbum.alid} </td>
                                        <td><a href="/album/${tempAlbum.alid}"> ${tempAlbum.atitle} </td>

                                    </tr>

                                </c:forEach>

                            </table>
                        </div>
                    </div>
                </table>
            </c:when>
            <c:otherwise>
                <table class="table table-hover">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">ALBUM</h3>
                        </div>
                        <div class="panel-body">
                            <table class="table table-hover">
                                <tr>
                                    <th>NOTHING... HAVE ANOTHER TRY... </th>
                                </tr>
                            </table>
                        </div>
                    </div>
                </table>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${hasAlbumList}">
                <table class="table table-hover">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">ARTIST</h3>
                        </div>
                        <div class="panel-body">
                            <table class="table table-hover">
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                        <%--<th>description</th>--%>
                                </tr>

                                <!-- loop over and print our customers -->
                                <c:forEach var="artist" items="${aritstResult}">
                                    <tr>
                                        <td><a href="/artist/${artist.id}"> ${artist.id} </td>
                                        <td><a href="/artist/${artist.id}"> ${artist.aname} </td>
                                            <%--<td><a href="/artist/${artist.id}"> ${artist.description} </td>--%>
                                    </tr>
                                </c:forEach>

                            </table>
                        </div>
                    </div>
                </table>
            </c:when>
            <c:otherwise>
                <table class="table table-hover">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">ARTIST</h3>
                        </div>
                        <div class="panel-body">
                            <table class="table table-hover">
                                <tr>
                                    <th>NOTHING... HAVE ANOTHER TRY... </th>
                                </tr>
                            </table>
                        </div>
                    </div>
                </table>
            </c:otherwise>
        </c:choose>


    </div>
</div>
<%@ include file="parts/footer.jsp" %>