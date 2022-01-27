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
        </tr>
    </thead>
    <tbody>
        <#if cats ? has_content>
            <#list cats as cat>
                <tr>
                    <td>${(cat.name)!}</td>
                    <td>
                        <img width="300" height="300" src="${(cat.url)!}" alt=""/>
                    </td>
                    <td>
                        <form method="post" action="/cats/${(cat.catId)!}/delete">
                            <input type="submit" value="Delete">
                        </form>
                        <form method="post" action="/cats/${(cat.catId)!}/like">
                            <input type="submit" value="Like">
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>
    </tbody>
</table>
</body>
</html>