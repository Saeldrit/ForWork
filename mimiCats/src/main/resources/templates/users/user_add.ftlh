<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>User Add</title>

</head>
<body>
    <section>
        <div>
            <h2>Add a new User</h2>
            <form method="post" action="user-add">
                <div>
                    <label>
                        <input type="text" name="firstName" required="required">
                    </label>
                    <span class="text">First Name</span>
                    <span class="line"></span>
                </div>
                <div>
                    <label>
                        <input type="text" name="lastName" required="required">
                    </label>
                    <span class="text">Last Name</span>
                    <span class="line"></span>
                </div>
                <div>
                    <label>
                        <input type="text" name="role">
                    </label>
                    <span class="text">Role</span>
                    <span class="line"></span>
                </div>
                <div>
                    <input type="submit" value="send">
                </div>
            </form>
        </div>
    </section>
</body>
</html>