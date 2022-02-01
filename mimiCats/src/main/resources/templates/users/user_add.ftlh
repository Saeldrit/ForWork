<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../static/style/styleForLogin.css">
    <link rel="stylesheet" href="../../static/style/styleForMenu.css">

    <title>User Add</title>

</head>
<body>
<div class="container">
    <form method="post" action="/user-add">
        <h3>Регистрация</h3>
        <div class="inputBox">
            <span>Имя</span>
            <div class="box">
                <div class="icon">
                    <ion-icon name="person"></ion-icon>
                </div>
                <input type="text" name="firstName">
            </div>
        </div>
        <div class="inputBox">
            <span>Фамилия</span>
            <div class="box">
                <div class="icon">
                    <ion-icon name="person"></ion-icon>
                </div>
                <input type="text" name="lastName">
            </div>
        </div>
        <div class="inputBox">
            <span>Роль</span>
            <div class="box">
                <div class="icon">
                    <ion-icon name="game-controller"></ion-icon>
                </div>
                <input type="text" name="role">
            </div>
        </div>
        <div class="inputBox">
            <span>Логин</span>
            <div class="box">
                <div class="icon">
                    <ion-icon name="log-in"></ion-icon>
                </div>
                <input type="text" name="login">
            </div>
        </div>
        <div class="inputBox">
            <span>Пароль</span>
            <div class="box">
                <div class="icon">
                    <ion-icon name="lock-closed"></ion-icon>
                </div>
                <input type="password" name="hashPassword">
            </div>
        </div>
        <div class="inputBox">
            <div class="box">
                <input type="submit" value="Добавить">
            </div>
        </div>
        <a href="/cat-add" class="forget">Добавить друга человека</a>
    </form>
</div>

<a href="/cats" class="cats">Голосование</a>
<a href="/results" class="results">Результаты</a>

<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>
</html>