<%@ include file="parts/header.jsp" %>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Welcome, ${pageContext.request.userPrincipal.name}! &#9731;</h2>
    </c:if>

    <ul class="nav nav-tabs">
        <li role="presentation" class="active"><a data-toggle="pill" href="#home">Home</a></li>
        <li role="presentation"><a data-toggle="pill" href="#profile">Profile</a></li>
        <li role="presentation"><a data-toggle="pill" href="#favorite">Favorite Artists</a></li>
        <li role="presentation"><a data-toggle="pill" href="#following">Following</a></li>
        <li role="presentation"><a data-toggle="pill" href="#followers">Followers</a></li>
    </ul>

    <div class="tab-content">
        <div id="home" class="tab-pane fade in active">

            <h3>Recommend for you</h3>
            <div class="col-sm-6">
            <h4>Tracks</h4>
                <table class="table table-hover">
                    <tr>
                        <th>Track Name</th>
                        <th>Duration</th>
                    </tr>

                    <!-- loop over and print our customers -->
                    <c:forEach var="track" items="${recommendByRecentListen}">
                        <tr>
                            <td><a href="/track/${track.id}"> ${track.ttitle} </td>
                            <td><a href="/track/${track.id}"> ${track.artist.aname} </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-sm-6">
                <h4>Artists</h4>
                <table class="table table-hover">
                    <tr>
                        <th>Name</th>
                        <th>Duration</th>
                        <th>Genre</th>
                    </tr>

                    <!-- loop over and print our customers -->
                    <c:forEach var="artist" items="${recommendByRecentListen}">
                        <tr>
                            <td><a href="/artist/${artist.id}"> ${artist.ttitle} </td>
                            <td><a href="/artist/${artist.id}"> ${artist.tduration} </td>
                            <td><a href="/artist/${artist.id}"> ${artist.genre} </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="form-group">
                <label for="artists">Recommended Artists</label>
                <input type="text" class="form-control" id="artists"
                       name="username" disabled value="">
            </div>
        </div>
        <div id="profile" class="tab-pane fade">
            <div class="col-xs-offset-10"></div><a href="/user/edit">Edit</a>
            <div class="form-group col-sm-8">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username"
                       name="username" disabled value="">
            </div>
            <div class="form-group col-sm-8">
                <label for="city">City</label>
                <input type="text" class="form-control" id="city"
                       name="city" disabled value="">
            </div>
            <div class="form-group col-sm-8">
                <label for="email">E-mail</label>
                <input type="text" class="form-control" id="email"
                       name="email" disabled value="">
            </div>
        </div>
        <div id="favorite" class="tab-pane fade">

            <h4>Recommended Artists</h4>
            <form class="navbar-form">
                <button type="button" class="btn btn-large btn-success" (click)="resetPassword()">Reset password via email</button>
            </form>
        </div>
        <div id="following" class="tab-pane fade">
            <h4>Following</h4>
            <form class="navbar-form">
                <button type="button" class="btn btn-large btn-success" (click)="resetPassword()">Reset password via email</button>
            </form>
        </div>
        <div id="followers" class="tab-pane fade">
            <h4>Followers</h4>
            <form class="navbar-form">
                <button type="button" class="btn btn-large btn-success" (click)="resetPassword()">Reset password via email</button>
            </form>
        </div>
    </div>

</div>
<%@ include file="parts/footer.jsp" %>
