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

<form method="post" action="/signUp">

    <span class="text">Имя</span>
    <label>
        <input type="text" name="firstName">
    </label>

    <span class="text">Фамилия</span>
    <label>
        <input type="text" name="lastName">
    </label>

    <span class="text">Логин</span>
    <label>
        <input type="text" name="login">
    </label>

    <span class="text">Пароль</span>
    <label>
        <input type="password" name="hashPassword">
    </label>

    <div>
        <input type="submit" value="Регистрация">
    </div>
</form>

</body>
</html>