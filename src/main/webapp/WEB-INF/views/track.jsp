<%@ include file="parts/header.jsp" %>
<div class="container">

    ${track.ttitle}
    ${avgScore}

        <form method="POST" action="${contextPath}/track/${track.id}" class="form-signin">
            <div class="form-group">
                <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                <input type="text" name="rateScore" class="form-control" placeholder="rate">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>


</div>
</container>
<%@ include file="parts/footer.jsp" %>