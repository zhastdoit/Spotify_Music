<%@ include file="parts/header.jsp" %>
<div class="container">
    <h2>Tracks</h2>
    <div style="overflow-y: auto">
        <table class="table table-hover">
            <tr>
                <th>Track ID</th>
                <th>Track Title</th>
                <th>Track Length</th>
                <th>Genre</th>
                <th>Artist</th>
                <th>Score</th>
            </tr>

            <!-- loop over and print our customers -->
            <c:forEach var="track" items="${trackList}">
                <tr>
                    <td><a href="/track/${track.id}"> ${track.id} </td>
                    <td><a href="/track/${track.id}"> ${track.ttitle} </td>
                    <td><a href="/track/${track.id}"> ${track.tduration} </td>
                    <td><a href="/track/${track.id}"> ${track.genre} </td>
                    <td><a href="/artist/${track.artist.id}"> ${track.artist.aname} </td>
                    <td> ${scores.get(track.id.intValue() - 1)} </td>
                </tr>

            </c:forEach>

        </table>
    </div>
</div>
<%@ include file="parts/footer.jsp" %>