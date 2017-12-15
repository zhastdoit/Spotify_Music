<%@ include file="parts/header.jsp" %>
<body>
<div class="container">
    <div class="col-sm-2">
        <img src="${album.alimage}" class="img-thumbnail" height="140" width="140">
    </div>
    <h2>${album.atitle}</h2>

    <table class="table table-hover">
        <tr>
            <th>+ ADD</th>
            <th>Name</th>
            <th>Genre</th>
            <th>LENGTH</th>
            <th>SCORE</th>
        </tr>

        <!-- loop over and print our customers -->
        <c:forEach var="track" items="${trackList}" varStatus="loop">
            <tr>
                <td> <button type="button" class="btn btn-default" aria-label="Left Align">
                    <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
                </button> </td>
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