<%@ include file="parts/header.jsp" %>
<body>
<table>
    <tr>
        <th>User ID</th>
        <th>Track ID</th>
        <th>Score</th>
    </tr>

    <!-- loop over and print our customers -->
    <c:forEach var="tempRate" items="${rateList}">
        <tr>
            <td> ${tempRate.uid} </td>
            <td> ${tempRate.tid} </td>
            <td> ${tempRate.score} </td>
        </tr>

    </c:forEach>

</table>
<%@ include file="parts/footer.jsp" %>