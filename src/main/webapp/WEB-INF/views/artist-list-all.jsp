<%@ include file="parts/header.jsp" %>
<body>
<div class="container">

    <h2>My Favorite Artists</h2>
    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Number of Fans</th>
        </tr>

        <!-- loop over and print our customers -->
        <c:set var="i" value="${0}"/>
        <c:forEach var="artist" items="${artistList}">
            <tr>
                <td><a href="/artist/${artist.id}"> ${artist.id} </td>
                <td><a href="/artist/${artist.id}"> ${artist.aname} </td>
                <td><a href="/artist/${artist.id}"> ${numberOfFans.get(i)} </td>
            </tr>
            <c:set var="i" value="${i + 1}"/>
        </c:forEach>

    </table>
</div>
<%@ include file="parts/footer.jsp" %>
