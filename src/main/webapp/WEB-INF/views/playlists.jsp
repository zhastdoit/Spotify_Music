<%@ include file="parts/header.jsp" %>
<div class="container">

    <button type="button" class="btn btn-default pull-right"
            onclick="window.location.href='newplaylist';return false;">+ NEW PLAYLIST</button>

    <table class="table table-hover">
        <tr>
            <th>List ID</th>
            <th>Name</th>
            <th>Adding Time</th>
            <th>Public</th>
        </tr>

        <!-- loop over and print our customers -->
        <c:forEach var="tempPlaylist" items="${playlist}">
            <tr>
                <td><a href="/playlist/${tempPlaylist.pid}"> ${tempPlaylist.pid} </td>
                <td><a href="/playlist/${tempPlaylist.pid}"> ${tempPlaylist.pname} </td>
                <td> ${tempPlaylist.timestamp.toString().split("\\s+")[0]} </td>
                <td> ${tempPlaylist.canSee == false ? "&#xf06e" : "&#xf070" } </td>
            </tr>

        </c:forEach>

    </table>

</div>

