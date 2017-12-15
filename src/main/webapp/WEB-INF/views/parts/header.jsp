<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="shortcut icon" href="../../resources/images/Spotify.ico" type="image/x-icon" />

    <div>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/">Spotify</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <li class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="/album/all">Albums</a></li>
                        <li><a href="/track/all">Tracks<span class="sr-only">(current)</span></a></li>
                        <li><a href="/artist/all">Artists</a></li>
                    </ul>
                    <form method="POST" action="${contextPath}/search" class="navbar-form navbar-left">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <div class="form-group">
                            <input name="search" type="text" class="form-control" placeholder="Search">
                        </div>
                        <%--<button type="submit" class="btn btn-default">Submit</button>--%>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${pageContext.request.userPrincipal.name}<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/myprofile">My Profile</a></li>
                                <li><a href="/playlist/all">My Playlists</a></li>
                                <li><a href="/artist/favorite">My liked Artists</a></li>
                                <li><a href="/followers">My Followers</a></li>
                                <li><a href="/followings">My Followings</a></li>
                                <li><a href="/rates">My Rates</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a onclick="document.forms['logoutForm'].submit()">Logout</a></ul></li>
                            </ul>
                        </li>
                    </ul>
            </div><!-- /.navbar-collapse -->

        </nav>

    </div>

    <form id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>
    <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'><!--web font-->
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

<![endif]-->
</head>
