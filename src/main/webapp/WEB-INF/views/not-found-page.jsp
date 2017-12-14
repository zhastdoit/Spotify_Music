
<%@ include file="parts/header.jsp" %>

<body style="background: url(http://cdn.cnn.com/cnnnext/dam/assets/170313183141-tromso-northern-lights-full-169.jpg)no-repeat center 0px;">
<link href="${contextPath}/resources/css/style1.css" rel="stylesheet" type="text/css" media="all" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<div class="wrap">
    <div class="logo">
        <img src="${contextPath}/WEB-INF/views/images/1.jpg" alt=""  />
    </div>
</div>
<div class="agileits-main">
    <div class="agileinfo-row">

        <div class="w3layouts-errortext">
            <h2>4<span>0</span>4</h2>

            <h1>Sorry! The page you were looking for could not be found </h1>
            <p class="w3lstext">You have been tricked into click on a link that can not be found. Please check the url or go to <a href="#">main page</a> and see if you can locate what you are looking for </p>
            <div class="agile-search">
                <form method="POST" action="${contextPath}/search">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="text" name="search" placeholder="Enter your search term..." id="search" required="">
                    <input type="submit" value="Search">
                </form>
            </div>
            <div class="w3top-nav-right">
                <ul>
                    <li><a href="/">Home</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<%@ include file="parts/footer.jsp" %>