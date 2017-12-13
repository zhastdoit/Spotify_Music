<%@ include file="parts/header.jsp" %>
<div class="container">
    <h2>Artists</h2>
    <table class="table table-hover">
        <tr>
            <th>User ID</th>
            <th>Name</th>
            <%--<th>description</th>--%>
        </tr>

        <!-- loop over and print our customers -->
        <c:forEach var="follower" items="${followers}">
            <tr>
                <td><a href="/user/${follower.id}"> ${follower.id} </td>
                <td><a href="/user/${follower.id}"> ${follower.username} </td>
                    <%--<td><a href="/artist/${artist.id}"> ${artist.description} </td>--%>
            </tr>
        </c:forEach>

    </table>

</div>
<%@ include file="parts/footer.jsp" %>
