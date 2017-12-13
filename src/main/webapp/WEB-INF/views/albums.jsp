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
                <td> ${tempAlbum.alid} </td>
                <td> ${tempAlbum.atitle} </td>

            </tr>

        </c:forEach>

    </table>

</div>

