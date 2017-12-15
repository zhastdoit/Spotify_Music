<%@ include file="parts/header.jsp" %>
<body>
<div class="container">
    <h2>Create Your New Playlist</h2>
    <form method="POST" action="${contextPath}/playlist/new" class="form-signin form-inline">
        <div class="form-group">
            <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
            <input type="text" name="playlistName" class="form-control" placeholer="name">
            <select class="form-control" id="option" required
                    name="options" >
                <option value="true">&#128275; public</option>
                <option value="false">&#128274; private</option>
            </select>
            <a class="btn btn-default" href="/playlist/all">Cancel</a>
            <button type="submit" class="btn btn-default">Create</button>
        </div>
    </form>

</div>

