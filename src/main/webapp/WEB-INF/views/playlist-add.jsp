<%@ include file="parts/header.jsp" %>
<div class="container">
    <form method="POST" action="${contextPath}/playlist/new" class="form-signin form-inline">

        <div class="form-group">
            <h2>Create Your Personal Playlist</h2>
            <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
            <input type="text" name="playlistName" class="form-control" placeholer="+ NEW PLAYLIST">

        </div>

        <div>
            <select class="form-control" id="option" required
                    name="options" >
                <option value="true">public</option>
                <option value="false">private</option>
            </select>
        </div>
        <a class="btn btn-default" href="/playlist/all">Cancel</a>
        <button type="submit" class="btn btn-default">Create</button>
    </form>

</div>

