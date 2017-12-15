<%@ include file="parts/header.jsp" %>
<body style="background: url(https://www.arapahoe-phil.org/wp-content/uploads/2017/05/spring-musical-notes-3257.jpg)no-repeat center 0px;">

<div class="container">
<div class="col-md-offset-3 col-md-6">
    <form method="POST" action="${contextPath}/login" class="form-signin">
        <%--<h2 class="form-heading" style="text-align: center">Log in</h2>--%>

        <div class="form-group ${error != null ? 'has-error' : ''}" style="margin-top: 50px">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true" style="margin-bottom: 10px"/>
            <input name="password" type="password" class="form-control" placeholder="Password" style="margin-bottom: 10px"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>

    </form>
</div>
</div>
<%@ include file="parts/footer.jsp" %>
