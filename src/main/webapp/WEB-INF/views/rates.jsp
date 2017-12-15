<%@ include file="parts/header.jsp" %>
<body>
<h2>&#10084;Rates</h2>
<div style="overflow-y: auto" class="col-md-6">
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
<%@ include file="parts/footer.jsp" %>