<%@ include file="parts/header.jsp" %>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Welcome, ${pageContext.request.userPrincipal.name}! </h2>
        <p>&#9731; It's cold outside. Come inside!</p>
    </c:if>

    <div class="tab-content">
        <div class="row">
            <h3>Recommend for you</h3>
            <div class="col-sm-6">
                <h4>Highly Popular</h4>
                <table class="table table-hover">
                    <tr>
                        <th>Name</th>
                        <th>Artist</th>
                        <th>Genre</th>
                        <th>Length</th>
                        <th>Score</th>
                    </tr>

                    <!-- loop over and print our customers -->
                    <c:forEach var="track" items="${recommendTrack}" varStatus="loop">
                        <tr>
                            <td><a href="/track/${track.id}"> ${track.ttitle} </a></td>
                            <td><a href="/track/${track.id}"> ${track.artist.aname} </a></td>
                            <td><a href="/track/${track.id}"> ${track.genre} </a></td>
                            <td> ${(track.tduration/60).intValue().toString()}:${(track.tduration%60).intValue()} </td>
                            <td> ${scores.get(loop.index)} </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-sm-6">
                <h4>The Artist You Listen</h4>
                <table class="table table-hover">
                    <tr>
                        <th>Name</th>
                        <th>Artist</th>
                        <th>Genre</th>
                        <th>Length</th>
                        <th>Score</th>
                    </tr>

                    <!-- loop over and print our customers -->
                    <c:forEach var="track" items="${recommendByRecentListen}" varStatus="loop">
                        <tr>
                            <td><a href="/track/${track.id}"> ${track.ttitle} </a></td>
                            <td><a href="/track/${track.id}"> ${track.artist.aname} </a></td>
                            <td><a href="/track/${track.id}"> ${track.genre} </a></td>
                            <td> ${(track.tduration/60).intValue().toString()}:${(track.tduration%60).intValue()} </td>
                            <td> ${scores.get(loop.index)} </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <h4>Recent listening</h4>
                <table class="table table-hover">
                    <tr>
                        <th>Name</th>
                        <th>Artist</th>
                        <th>Genre</th>
                        <th>Length</th>
                        <th>Score</th>
                    </tr>

                    <!-- loop over and print our customers -->
                    <c:forEach var="track" items="${history}" varStatus="loop">
                        <tr>
                            <td><a href="/track/${track.id}"> ${track.ttitle} </a></td>
                            <td><a href="/track/${track.id}"> ${track.artist.aname} </a></td>
                            <td><a href="/track/${track.id}"> ${track.genre} </a></td>
                            <td> ${(track.tduration/60).intValue().toString()}:${(track.tduration%60).intValue()} </td>
                            <td> ${scores.get(loop.index)} </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-sm-6">
                <h4>Your Following's Taste</h4>
                <table class="table table-hover">
                    <tr>
                        <th>Name</th>
                        <th>Artist</th>
                        <th>Genre</th>
                        <th>Length</th>
                        <th>Score</th>
                    </tr>

                    <c:forEach var="track" items="${followingHistory}" varStatus="loop">
                        <tr>
                            <td><a href="/track/${track.id}"> ${track.ttitle} </a></td>
                            <td><a href="/track/${track.id}"> ${track.artist.aname} </a></td>
                            <td><a href="/track/${track.id}"> ${track.genre} </a></td>
                            <td> ${(track.tduration/60).intValue().toString()}:${(track.tduration%60).intValue()} </td>
                            <td> ${scores.get(loop.index)} </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
<%@ include file="parts/footer.jsp" %>
