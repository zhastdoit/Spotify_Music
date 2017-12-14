<%@ include file="parts/header.jsp" %>
<body>
<div class="container">
    <h2>Tracks</h2>
    <div style="overflow-y: auto">
        <table class="table table-hover">
            <tr>
                <th>+ ADD </th>
                <th>Title</th>
                <th>GENRE</th>
                <th>ARTIST</th>
                <th>Length</th>
                <%--<th>Score</th>--%>
            </tr>

            <!-- loop over and print our customers -->
            <c:forEach var="track" items="${trackList}">
                <tr>
                    <td> <button type="button" class="btn btn-default" aria-label="Left Align">
                        <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
                    </button> </td>
                    <td><a href="/track/${track.id}"> ${track.ttitle} </td>

                    <td><a href="/track/${track.id}"> ${track.genre} </td>
                    <td><a href="/artist/${track.artist.id}"> ${track.artist.aname} </td>
                    <td> ${(track.tduration/60).intValue().toString()}:${(track.tduration%60).intValue()} </td>
                    <%--<td> ${scores.get(track.id.intValue() - 1)} </td>--%>

                </tr>

            </c:forEach>

        </table>
        <c:choose>
            <c:when test="${notFirstPage}">
                <div class="col-sm-6 col-md-3 col-md-offset-3">
                    <form method="POST" action="${contextPath}/track/all" class="form-signin form-inline">
                        <div class="form-group">
                            <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                            <input type="hidden" name="next" class="form-control" value="False">
                            <input type="hidden" name="fromIndex" class="form-control" value="${fromIndex}">
                        </div>
                        <button type="submit" class="btn btn-default col-xs-12"><- Prev</button>
                    </form>
                </div>
                <div class="col-sm-6 col-md-3">
                    <form method="POST" action="${contextPath}/track/all" class="form-signin form-inline">
                        <div class="form-group">
                            <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                            <input type="hidden" name="next" class="form-control" value="True">
                            <input type="hidden" name="fromIndex" class="form-control" value="${fromIndex}">
                        </div>
                        <button type="submit" class="btn btn-default col-xs-12">Next -></button>
                    </form>
                </div>
            </c:when>
            <c:otherwise>
                <div class="col-sm-6 col-md-3 col-md-offset-5">
                    <form method="POST" action="${contextPath}/track/all" class="form-signin form-inline">
                        <div class="form-group">
                            <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                            <input type="hidden" name="next" class="form-control" value="True">
                            <input type="hidden" name="fromIndex" class="form-control" value="${fromIndex}">
                        </div>
                        <button type="submit" class="btn btn-default col-xs-12">Next -></button>
                    </form>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div style="height: 80px">
</div>
<%@ include file="parts/footer.jsp" %>