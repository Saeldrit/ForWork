<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Cat House</title>
</head>
<body>

<form method="post" action="/signIn">

    <span class="text">Логин</span>
    <label>
        <input name="login">
    </label>

    <span class="text">Пароль</span>
    <label>
        <input type="password" name="hashPassword">
    </label>

    <div>
        <input type="submit" value="Вход">
    </div>

</form>

</body>
</html>