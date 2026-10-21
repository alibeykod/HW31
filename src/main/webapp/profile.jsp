<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Profile</title>
</head>
<body>
<p><%
    String username = session.getAttribute("username").toString();
%>  Welcome To Your Profile </p>
<hr>
<h3>Create Your Post</h3>
<form id="postForm">
    <label for="title">Title : </label>
    <input type="text" name="title" id="title" placeholder="Title" required> <br> <br>

    <label for="textOfPost">Text : </label>
    <input type="text" name="textOfPost" id="textOfPost" placeholder="Explain About Your Title ">

    <button type="button" id="Upload">Upload</button>
</form>
<p id="profileWelcome" style="color: black;"></p>
<div id="postsContainer"></div>
<button type="button">
    <a href="login.jsp">Login</a>
</button>
<script src="profile.js"></script>
</body>
</html>