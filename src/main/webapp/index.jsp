<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="registration" method="post" id="registrationّForm">
    <label for="fullName"> Full Name : </label>
    <input type="text" id="fullName" name="fullName" placeholder="* Type English *" required> <br> <br>

    <label for="username"> User Name ;</label>
    <input type="text" name="username" id="username" placeholder="e.g. Reza" required > <br> <br>

    <label for="password">Password : </label>
    <input type="password" name="password" id="password" placeholder="Use Simple One" required> <br><br>

    <button type="submit" id="submit" name="submit"> Create </button>
</form>
<p id="resultMessage" style="color: green;"></p>
<p>If You Had Registration Before Go To <a href="login.jsp">Login</a> Page</p>
<script src="registration.js"></script>
</body>
</html>