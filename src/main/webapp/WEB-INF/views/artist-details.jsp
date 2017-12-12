<%@ include file="parts/header.jsp" %>
<div class="container">

    <h2>${artist.aname}</h2>
    <p class="lead"> ${artist.description} </p>
    <table class="table table-hover">
        <tr>
            <th>Name</th>
            <th>Duration</th>
            <th>Genre</th>
        </tr>

        <!-- loop over and print our customers -->
        <c:forEach var="track" items="${track}">
            <tr>
                <td><a href="/track/${track.id}"> ${track.ttitle} </td>
                <td><a href="/track/${track.id}"> ${track.tduration} </td>
                <td><a href="/track/${track.id}"> ${track.genre} </td>
            </tr>

        </c:forEach>

    </table>

</div>
</container>
<%@ include file="parts/footer.jsp" %>