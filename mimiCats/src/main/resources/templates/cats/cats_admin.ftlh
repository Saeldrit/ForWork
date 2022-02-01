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
            <th>Просит есть?</th>
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
                        <td>
                          <span class="action_btn">
                              <form method="post" action="/cats/${(cat.catId)!}/delete">
                                  <button type="submit">Ты свободен</button>
                              </form>
                          </span>
                        </td>
                    </tr>
                </#list>
            </#if>
        </tbody>
    </table>
</div>

<a href="/results" class="cats">Результаты</a>
<a href="/cat-add" class="results">Добавить</a>
<a href="/users" class="registration">Пользователи</a>
<a href="/signIn" class="admin">Выйти</a>

</body>
</html>