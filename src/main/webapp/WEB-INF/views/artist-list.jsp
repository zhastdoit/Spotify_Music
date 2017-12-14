<%@ include file="parts/header.jsp" %>
<body>
<div class="container">
    <h2>Artists</h2>
    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <%--<th>description</th>--%>
        </tr>

        <!-- loop over and print our customers -->
        <c:forEach var="artist" items="${artist}">
            <tr>
                <td><a href="/artist/${artist.id}"> ${artist.id} </td>
                <td><a href="/artist/${artist.id}"> ${artist.aname} </td>
                <%--<td><a href="/artist/${artist.id}"> ${artist.description} </td>--%>
            </tr>
        </c:forEach>

    </table>

</div>
<div style="height :80px;"></div>
<%@ include file="parts/footer.jsp" %>
