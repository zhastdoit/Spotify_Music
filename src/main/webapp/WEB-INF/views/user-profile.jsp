<%@ include file="parts/header.jsp" %>
<body>
<div class="container">
    <div class="col-lg-2 col-md-3 col-sm-4 col-xs-12">
        <img src="${user.uimage}" class="img-circle" height="140" width="140">
    </div>
    <div class="col-lg-10 col-md-9 col-sm-8 col-xs-12" style="margin-bottom: 30px;">
        <h2>${user.username}</h2>
        <h5 style="white-space:pre"> &#128104; Followers: ${numberOfFollowers}  &#128420; Following: ${numberOfFollowings} </h5>
        <p class="lead" style="margin-bottom: 0px"> Currently in ${user.city}. ${user.email}   </p>
        <div>
            <c:choose>
                <c:when test="${isFollowing}">
                    <form method="POST" action="${contextPath}/user/${user.id}" class="form-signin">
                        <div class="form-group">
                            <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                            <input type="hidden" name="followStatus" class="form-control" value="False">
                        </div>
                        <button type="submit" class="btn btn-default btn-xs" style="width: 200px">UnFollow</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <form method="POST" action="${contextPath}/user/${user.id}" class="form-signin">
                        <div class="form-group">
                            <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                            <input type="hidden" name="followStatus" class="form-control" value="True">
                        </div>
                        <button type="submit" class="btn btn-default btn-xs" style="width: 200px">Follow</button>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div>
        <h4>${user.username}'s Playlists</h4>
        <div>
            <table class="table table-hover">
                <tr>
                    <th>List ID</th>
                    <th>Name</th>
                    <th>Adding Time</th>
                    <th>Public</th>
                </tr>

                <!-- loop over and print our customers -->
                <c:forEach var="tempPlaylist" items="${playlists}">
                    <tr>
                        <td><a href="/playlist/${tempPlaylist.pid}"> ${tempPlaylist.pid} </td>
                        <td><a href="/playlist/${tempPlaylist.pid}"> ${tempPlaylist.pname} </td>
                        <td> ${tempPlaylist.timestamp.toString().split("\\s+")[0]} </td>
                        <td> ${tempPlaylist.canSee == false ? "&#128275;" : "&#128274;" } </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>
<%@ include file="parts/footer.jsp" %>
