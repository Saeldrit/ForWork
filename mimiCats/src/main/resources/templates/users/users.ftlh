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
<table class="table">
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Role</th>
        </tr>
    </thead>
    <tbody>
        <#if users ? has_content>
            <#list users as user>
                <tr>
                    <td>${(user.firstName)!}</td>
                    <td>${(user.lastName)!}</td>
                    <td>${(user.role)!}</td>
                    <td>
                        <form method="post" action="/users/${(user.userId)!}/delete">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>
    </tbody>
</table>
</body>
</html>