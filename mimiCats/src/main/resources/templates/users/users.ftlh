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
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Role</th>
            <th>Логин</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <#if users ? has_content>
            <#list users as user>
                <tr>
                    <td>${(user.firstName)!}</td>
                    <td>${(user.lastName)!}</td>
                    <td>${(user.role)!}</td>
                    <td>${(user.login)!}</td>
                    <td>
                        <span class="action_btn">
                               <form method="post" action="/users/${(user.userId)!}/delete">
                                    <button type="submit">Удалить</button>
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
<a href="/signIn" class="registration">Выйти</a>

</body>
</html>