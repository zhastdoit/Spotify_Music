<%@ include file="parts/header.jsp" %>
<body>
<div class="container">
    <div class="col-sm-2">
        <img src="${track.timage}" class="img-circle" height="140" width="140">
    </div>
    <div class="col-sm-10"></div>
        <h3>Now Playing</h3>
        <h1>${track.ttitle}</h1>
        <div class="row">
            <h4>&#127908;By <a href="/artist/${artist.id}">${artist.aname}</a> 	&#9998; Score: ${avgScore}/5</h4>
        </div>
        <div class="row">
            <form class="form-inline" id="rate" method="POST" action="${contextPath}/track/${track.id}">
                <div class="form-group col-xs-6">
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
    <div id = "Audio" class="col-xs-12" >
        <audio id="audioElement" controls class="col-xs-12">
            <source src="${track.trackurl}" type="audio/mpeg">
            Your browser does not support the audio element.
        </audio>
    </div>


    </div>
</div>
<%@ include file="parts/footer.jsp" %>