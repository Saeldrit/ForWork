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
<section>
    <div>
        <h2>Add a new Cat</h2>
        <form method="post" action="/cat-add">
            <div>
                <label>
                    <input type="text" name="name" required="required">
                </label>
                <span class="text">Name</span>
            </div>
            <div>
                <label>
                    <input type="text" name="url" required="required">
                </label>
                <span class="text">URL</span>
            </div>
            <div>
                <input type="submit" value="send">
            </div>
        </form>
    </div>
</section>
</body>
</html>