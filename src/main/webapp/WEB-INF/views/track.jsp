<%@ include file="parts/header.jsp" %>
<div class="container">
    <h3> Now Playing</h3>
    <h1>${track.ttitle}</h1>
    <h5><span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Score: ${avgScore}/5</h5>

        <form method="POST" action="${contextPath}/track/${track.id}" class="form-signin form-inline">
            <div class="form-group">
                <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                <input type="text" name="rateScore" class="form-control" placeholder="Rate this track">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>


</div>
<%@ include file="parts/footer.jsp" %>