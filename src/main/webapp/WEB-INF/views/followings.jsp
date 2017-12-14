<%@ include file="parts/header.jsp" %>
<body>
<div class="container">
    <h2>My Followings</h2>
    <table class="table table-hover">
        <tr>
            <th>User ID</th>
            <th>Name</th>
            <%--<th>description</th>--%>
        </tr>

        <!-- loop over and print our customers -->
        <c:forEach var="following" items="${followings}">
            <tr>
                <td><a href="/user/${following.id}"> ${following.id} </td>
                <td><a href="/user/${following.id}"> ${following.username} </td>
                    <%--<td><a href="/artist/${artist.id}"> ${artist.description} </td>--%>
            </tr>
        </c:forEach>

    </table>

</div>
<%@ include file="parts/footer.jsp" %>
