<%@ include file="parts/header.jsp" %>
<body style="background: url(https://www.arapahoe-phil.org/wp-content/uploads/2017/05/spring-musical-notes-3257.jpg)no-repeat center 0px;">
<div class="container">
    <div class="col-lg-2 col-md-3 col-sm-4 col-xs-12">
        <img src="${track.timage}" class="img-circle" height="140" width="140">
        <div class="row">
            <form class="form-inline" id="rate" method="POST" action="${contextPath}/track/${track.id}">
                <div class="form-group col-xs-12">
                    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                    <label class="sr-only" for="rateScore">Amount (in dollars)</label>
                    <div class="input-group">
                        <input type="number" id="rateScore" name="rateScore" class="form-control" placeholer="Rate this track" min="1" max="5">
                        <div class="input-group-addon">
                            <a href="javascript:{}" onclick="document.getElementById('rate').submit();">Rate</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="col-lg-10 col-md-9 col-sm-8 col-xs-12" style="margin-bottom: 30px;">
        <h3>Now Playing</h3>
        <h1>${track.ttitle}</h1>
        <div class="row">
            <h4>&#127908;By <a href="/artist/${artist.id}">${artist.aname}</a> 	&#9998; Score: ${avgScore}/5</h4>
        </div>
    </div>


        <div id = "Audio" class="col-xs-12" >
            <audio id="audioElement" controls class="col-xs-12">
                <source src="${track.trackurl}" type="audio/mpeg">
                Your browser does not support the audio element.
            </audio>
        </div>
        <div class="col-xs-3 form-inline">
            <li class="dropdown" style="color: white; padding-top: 0px">
                <a href="#" class="dropdown-toggle btn btn-default col-xs-12" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span> Add To Playlist</a>
                <ul class="dropdown-menu">
                    <c:forEach var="playlist" items="${playlists}">
                        <li><a href="/playlist/${playlist.pid}/addToPlaylist/${track.id}"> ${playlist.pname} </a></li>
                    </c:forEach>
                    <li role="separator" class="divider"></li>
                    <li><a href="/playlist/newplaylist">New Playlist</a></li>
                </ul>
            </li>
        </div>
    </div>
</div>
<%@ include file="parts/footer.jsp" %>