<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Page Login</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="../css/login.css">
</head>

<body>
    <div class="container">
        <form class="form-signin" id="form">
            <h2 class="form-signin-heading">Please sign in or sign up</h2>
            <label for="inputLogin" class="sr-only">Login</label>
            <input type="text" id="login" class="form-control" placeholder="Login" title="Incorrect login" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <br/>
            <button class="btn btn-lg btn-primary btn-block" id="bLoginSignIn" type="submit" formaction="login" formmethod="POST">Sign In</button>
            <button class="btn btn-lg btn-primary btn-block" id="bLoginEnterGuest" type="button">Enter as guest</button>
            <button class="btn btn-lg btn-primary btn-block" id="bLoginReg" type="button">Register</button>
        </form>

    </div>
    <script src="../js/jquery-3.1.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/redirect.js"></script>
</body>

</html>