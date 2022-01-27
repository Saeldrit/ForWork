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
<table>
    <thead>
        <tr>
            <th>Погоняло</th>
            <th>Рейтинг</th>
            <th>Лайки</th>
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
                        <img width="150" height="150" src="${(cat.url)!}" alt=""/>
                    </td>
                </tr>
            </#list>
        </#if>
    </tbody>
</table>
</body>
</html>