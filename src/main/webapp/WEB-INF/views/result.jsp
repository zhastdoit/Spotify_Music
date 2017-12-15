<%@ include file="parts/header.jsp" %>
<body>
<div class="container">
    <h2>Results</h2>
    <div style="overflow-y: auto" >

        <div class="col-sm-6">
            <div>
                <c:choose>
                <c:when test="${hasTrackList}">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">TRACK</h3>
                            </div>
                            <div class="panel-body">
                                <table class="table table-hover">
                                    <tr>
                                        <th>Title</th>
                                        <th>Genre</th>
                                        <th>Artist</th>
                                        <th>Duration</th>
                                    </tr>

                                    <c:forEach var="track" items="${trackResult}">
                                        <tr>
                                            <td><a href="/track/${track.id}"> ${track.ttitle} </td>
                                            <td><a href="/track/${track.id}"> ${track.genre} </td>
                                            <td><a href="/artist/${track.artist.id}"> ${track.artist.aname} </td>
                                            <td> ${(track.tduration/60).intValue().toString()}:${(track.tduration%60).intValue()} </td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>

                </c:when>
                <c:otherwise>

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

                </c:otherwise>
            </c:choose>
            </div>
            <div>
                <c:choose>
                <c:when test="${hasTrackGenreList}">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">TRACK GENRE</h3>
                            </div>
                            <div class="panel-body">
                                <table class="table table-hover">
                                    <tr>
                                        <th>Title</th>
                                        <th>GENRE</th>
                                        <th>ARTIST</th>
                                        <th>Length</th>
                                    </tr>

                                    <c:forEach var="track" items="${trackGenreResult}">
                                        <tr>
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

                </c:when>
                <c:otherwise>

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

                </c:otherwise>
            </c:choose>
            </div>
        </div>
        <div class="col-sm-6">
            <div>
                <c:choose>
                <c:when test="${hasAlbumList}">

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

                </c:when>
                <c:otherwise>

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

                </c:otherwise>
            </c:choose>
            </div>
            <div>
                <c:choose>
                <c:when test="${hasAlbumList}">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">ARTIST</h3>
                            </div>
                            <div class="panel-body">
                                <table class="table table-hover">
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                    </tr>
                                    <c:forEach var="artist" items="${aritstResult}">
                                        <tr>
                                            <td><a href="/artist/${artist.id}"> ${artist.id} </td>
                                            <td><a href="/artist/${artist.id}"> ${artist.aname} </td>
                                        </tr>
                                    </c:forEach>

                                </table>
                            </div>
                        </div>

                </c:when>
                <c:otherwise>

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

                </c:otherwise>
            </c:choose>
            </div>
        </div>
    </div>
</div>
<div style="height: 80px;"></div>
<%@ include file="parts/footer.jsp" %>