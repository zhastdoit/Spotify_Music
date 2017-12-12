<%@ include file="parts/header.jsp" %>
<div class="container">

    <table>
        <tr>
            <th>Artist ID</th>
            <th>aname</th>
            <th>description</th>
        </tr>

        <!-- loop over and print our customers -->
        <c:forEach var="tempArtist" items="${artist}">
            <tr>
                <td> ${tempArtist.id} </td>
                <td> ${tempArtist.aname} </td>
                <td> ${tempArtist.description} </td>
            </tr>

        </c:forEach>

    </table>

</div>
</container>
<%@ include file="parts/footer.jsp" %>
