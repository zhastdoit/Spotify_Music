<%@ include file="parts/header.jsp" %>
<body>
<div class="container">

    <h2>${playlist.pname}</h2>

    <h5>Owner: <a href="/user/${playlist.uid}">${owner.username}</a></h5>
    <div>
        <table class="table table-hover">
            <tr>
                <th>Remove</th>
                <th>Name</th>
                <th>Artist</th>
                <th>Genre</th>
                <th>Duration</th>
                <th>Score</th>
            </tr>

        <!-- loop over and print our customers -->
        <c:forEach var="track" items="${trackList}" varStatus="loop">
            <tr>
                <td>
                    <form method="GET" action="${contextPath}/playlist/${playlist.pid}/remove/${track.id}">
                        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-default" aria-label="Left Align">
                            <span class="glyphicon glyphicon-minus-sign" aria-hidden="true"></span>
                        </button>
                    </form>
                </td>
                <td><a href="/track/${track.id}"> ${track.ttitle} </td>
                <td><a href="/artist/${track.artist.id}"> ${track.artist.aname} </td>
                <td><a href="/track/${track.id}"> ${track.genre} </td>
                <td> ${(track.tduration/60).intValue().toString()}:${(track.tduration%60).intValue()} </td>
                <td> ${scores.get(loop.index)} </td>
            </tr>
            <!-- loop over and print our customers -->
            </c:forEach>
        </table>
    </div>
    <h4 style="text-align: center">${alert}</h4>
</div>
<div style="height: 80px;"></div>
<%@ include file="parts/footer.jsp" %>