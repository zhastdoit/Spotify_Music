<%@ include file="parts/header.jsp" %>
<div class="container">

    <table>
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
                <td> ${track.id} </td>
                <td> ${track.ttitle} </td>
                <td> ${track.tduration} </td>
                <td> ${track.genre} </td>
                <td> ${track.artist.aname} </td>
                <td> ${scores.get(track.id.intValue() - 1)} </td>
            </tr>

        </c:forEach>

    </table>

</div>
</container>
<%@ include file="parts/footer.jsp" %>