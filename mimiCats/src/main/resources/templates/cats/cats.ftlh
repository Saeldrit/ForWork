<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../static/style/styleForMenu.css">
    <link rel="stylesheet" href="../../static/style/styleForLike.css">
    <link rel="stylesheet" href="../../static/style/styleForCardCat.css">

    <title>Cat House</title>

</head>
<body>
<#if cats ? has_content>
    <#list cats as cat>
        <div class="wrapper">
            <div class="card">
                <img src="${(cat.url)!}"
                     alt="">
                <div class="info">
                    <h3>${(cat.name)!}</h3>
                    <form method="post" action="/cats/${(cat.catId)!}/like">
                        <button class="button" role="button" value="like">Ниче такой</button>
                    </form>
                </div>
            </div>
        </div>
    </#list>
</#if>

<a href="/results" class="cats">Результаты</a>
<a href="/cats-admin" class="results">Админ</a>
<a href="/signIn" class="registration">Выйти</a>

</body>
</html>