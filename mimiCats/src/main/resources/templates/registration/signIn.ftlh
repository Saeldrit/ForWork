<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../static/style/styleForLogin.css">

    <title>Cat House</title>
</head>
<body>
<div class="container">
    <form method="post" action="/signIn">
        <h3>Авторизация</h3>
        <div class="inputBox">
            <span>Логин</span>
            <div class="box">
                <div class="icon"><ion-icon name="person"></ion-icon></div>
                <input type="text" name="login">
            </div>
        </div>
        <div class="inputBox">
            <span>Пароль</span>
            <div class="box">
                <div class="icon"><ion-icon name="lock-closed"></ion-icon></div>
                <input type="password" name="hashPassword">
            </div>
        </div>
        <div class="inputBox">
            <div class="box">
                <input type="submit" value="Войти">
            </div>
        </div>
        <a href="/signUp" class="forget">Регистрация</a>
    </form>
</div>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>
</html>