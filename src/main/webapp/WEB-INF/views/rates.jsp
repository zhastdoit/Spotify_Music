<%@ include file="parts/header.jsp" %>
<body>
<div class="container">
    <h2>&#10084;My Rates</h2>
    <div>
        <table class="table table-hover">

        <tr>
            <th>User ID</th>
            <th>Track ID</th>
            <th>Score</th>
        </tr>

        <!-- loop over and print our customers -->
        <c:forEach var="tempRate" items="${rateList}">
            <tr>
                <td><a href="/track/${tempRate.tid}"> ${tempRate.uid} </td>
                <td><a href="/track/${tempRate.tid}"> ${tempRate.tid} </td>
                <td><a href="/track/${tempRate.tid}"> ${tempRate.score} </td>
            </tr>

        </c:forEach>

        </table>
    </div>
</div>
<%@ include file="parts/footer.jsp" %>