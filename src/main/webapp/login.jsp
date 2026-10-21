<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
</head>
<body>
<form action="login" method="post" id="login">
    <label for="username">Username : </label>
    <input type="text" name="username" id="username" placeholder="Write Here" required> <br> <br>

    <label for="password"> Password : </label>
    <input type="password" name="password" id="password" placeholder="Dont Forget !" required> <br> <br>

    <button type="submit" name="login" id="login"> Login </button>
</form>

<p>Back To <a href="index.jsp">Registration</a></p>

<p id="resultMessageLogin" style="color: Blue;"></p>
<p>If You Didn't Sign up Go To <button>
    <a href="index.jsp">Registration </a>
</button>  Page First</p>

<script src="login.js"></script>
</body>
</html>