<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../static/style/styleForLogin.css">
    <link rel="stylesheet" href="../../static/style/styleForMenu.css">

    <title>Cat House</title>

</head>
<body>
<div class="container">
    <form method="post" action="/cat-add">
        <h3>Добавить кореша</h3>
        <div class="inputBox">
            <span>Кот</span>
            <div class="box">
                <div class="icon">
                    <ion-icon name="person"></ion-icon>
                </div>
                <input type="text" name="name">
            </div>
        </div>
        <div class="inputBox">
            <span>URL</span>
            <div class="box">
                <div class="icon">
                    <ion-icon name="link"></ion-icon>
                </div>
                <input type="text" name="url">
            </div>
        </div>
        <div class="inputBox">
            <div class="box">
                <input type="submit" value="Добавить">
            </div>
        </div>
        <a href="/user-add" class="forget">Добавить пользователя</a>
    </form>
</div>

<a href="/cats" class="cats">Голосование</a>
<a href="/results" class="results">Результаты</a>
<a href="/cats-admin" class="registration">Админ</a>
<a href="/signIn" class="admin">Выйти</a>

<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>
</html>