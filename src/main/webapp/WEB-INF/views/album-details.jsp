<%@ include file="parts/header.jsp" %>
<body>
<div class="container">

    <h2>${album.atitle}</h2>
    <table class="table table-hover">
        <tr>
            <th>+ ADD</th>
            <th>Name</th>
            <th>Genre</th>
            <th>LENGTH</th>
        </tr>

        <!-- loop over and print our customers -->
        <c:forEach var="track" items="${trackList}">
            <tr>
                <td> <button type="button" class="btn btn-default" aria-label="Left Align">
                    <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
                </button> </td>
                <td><a href="/track/${track.id}"> ${track.ttitle} </td>
                <td><a href="/track/${track.id}"> ${track.genre} </td>
                <td> ${(track.tduration/60).intValue().toString()}:${(track.tduration%60).intValue()} </td>
            </tr>

        </c:forEach>

    </table>

</div>
<div style="height: 80px;"></div>
<%@ include file="parts/footer.jsp" %>