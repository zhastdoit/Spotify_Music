<%@ include file="parts/header.jsp" %>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Welcome, ${pageContext.request.userPrincipal.name}!</h2>
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
            <div class="form-group">
                <label for="tracks">Recommended Tracks</label>
                <input type="text" class="form-control" id="tracks"
                       name="email" disabled value="">
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
