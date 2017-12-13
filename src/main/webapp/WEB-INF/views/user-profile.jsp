<%@ include file="parts/header.jsp" %>
<div class="container">
    <div class="col-md-12">
        <h2>${user.username}</h2>
        <p style="white-space:pre"> <span class="glyphicon glyphicon-user" aria-hidden="true"> Followers: ${numberOfFollowers} <span class="glyphicon glyphicon-heart" aria-hidden="true"></span> Following: ${numberOfFollowings} </p>
    </div>
    <div class="col-xs-12">
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

    <div style="margin-top: 20px" class="form-group col-sm-8">
        <label for="city">City</label>
        <div id="city">
            <p> ${user.city} </p>
        </div>
    </div>
    <div class="form-group col-sm-8">
        <label for="email">E-mail</label>
        <div id="email">
            <p> ${user.email} </p>
        </div>
    </div>
</div>
<%@ include file="parts/footer.jsp" %>
