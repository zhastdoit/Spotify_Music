<%@ include file="parts/header.jsp" %>
<div class="container">

    <table class="table table-hover">
        <tr>
            <th>Album ID</th>
            <th>Title</th>

        </tr>

        <!-- loop over and print our customers -->
        <c:forEach var="tempAlbum" items="${albums}">
            <tr>
                <td><a href="/album/${tempAlbum.alid}"> ${tempAlbum.alid} </td>
                <td><a href="/album/${tempAlbum.alid}"> ${tempAlbum.atitle} </td>

            </tr>

        </c:forEach>

    </table>

</div>

