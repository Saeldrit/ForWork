<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../static/style/styleForTable.css">
    <link rel="stylesheet" href="../../static/style/styleForMenu.css">

    <title>Cat House</title>

</head>
<body>
<div class="table_responsive">
    <table>
        <thead>
        <tr>
            <th>Мистер Кот</th>
            <th>Рейтинг</th>
            <th>Лайки</th>
            <th>Фото</th>
        </tr>
        </thead>

        <tbody>
            <#if cats ? has_content>
                <#list cats as cat>
                    <tr>
                        <td>${(cat.name)!}</td>
                        <td>${(cat.rating)!}</td>
                        <td>${(cat.countLike)!}</td>
                        <td>
                            <img src="${(cat.url)!}" alt=""/>
                        </td>
                    </tr>
                </#list>
            </#if>
        </tbody>
    </table>
</div>

<a href="/cats" class="cats">Голосование</a>
<a href="/results" class="results">Результаты</a>
<a href="/cats-admin" class="registration">Админ</a>
<a href="/signIn" class="admin">Выйти</a>

</body>
</html>