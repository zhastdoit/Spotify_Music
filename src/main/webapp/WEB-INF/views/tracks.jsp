<%@ include file="parts/header.jsp" %>
<div class="container">
    <h2>Tracks</h2>
    <div style="overflow-y: auto">
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
            <c:forEach var="track" items="${trackList}">
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
<%@ include file="parts/footer.jsp" %>