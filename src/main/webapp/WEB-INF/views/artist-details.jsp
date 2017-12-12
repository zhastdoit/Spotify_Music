<%@ include file="parts/header.jsp" %>
<div class="container">

    <table>
        <tr>
            <th>Artist ID</th>
            <th>aname</th>
            <th>description</th>
        </tr>

        <!-- loop over and print our customers -->
        <c:forEach var="track" items="${track}">
            <tr>
                <td><a href=""> ${track.ttitle} </td>
                <td> ${track.tduration} </td>
                <td> ${track.genre} </td>
            </tr>

        </c:forEach>

    </table>

</div>
</container>
<%@ include file="parts/footer.jsp" %>