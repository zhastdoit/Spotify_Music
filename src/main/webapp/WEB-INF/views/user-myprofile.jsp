<%@ include file="parts/header.jsp" %>
<body>
<div class="container">
    <div class="col-sm-2">
        <img src="${user.uimage}" class="img-circle" height="140" width="140">
    </div>
    <h2>${user.username}'s Profile</h2>
    <p><span class="glyphicon glyphicon-user" aria-hidden="true">Followers: ${numberOfFollowers}  <span class="glyphicon glyphicon-heart" aria-hidden="true"></span> Following: ${numberOfFollowings} </p>
    <form>
        <div class="form-group col-sm-8">
            <label for="city">City</label>
            <input type="text" class="form-control" id="city"
                   name="city" value="${user.city}">
        </div>
        <div class="form-group col-sm-8">
            <label for="email">E-mail</label>
            <input type="text" class="form-control" id="email"
                   name="email" value="${user.email}">
        </div>
        <button type="submit" class="btn btn-block">Submit</button>
    </form>
</div>
<%@ include file="parts/footer.jsp" %>
