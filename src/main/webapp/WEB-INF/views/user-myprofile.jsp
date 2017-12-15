<%@ include file="parts/header.jsp" %>
<body>
<div class="container">
    <div class="col-lg-2 col-md-3 col-sm-4 col-xs-12">
        <img src="${user.uimage}" class="img-circle" height="140" width="140">
    </div>
    <div class="col-lg-10 col-md-9 col-sm-8 col-xs-12" style="margin-bottom: 30px;">
        <h2>${user.username}</h2>
        <h5 style="white-space:pre"> &#128104; Followers: <a href="/followers"> ${numberOfFollowers} </a> &#128420; Following: ${numberOfFollowings} </h5>
        <p class="lead" style="margin-bottom: 0px"> Currently in ${user.city}. ${user.email}   </p>
    </div>
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
        <div class="col-sm-8">
            <div class="pull-right">
            <button type="submit" class="btn btn-default" style="width: 200px">Submit</button>
            </div>
        </div>
    </form>
</div>
<%@ include file="parts/footer.jsp" %>
