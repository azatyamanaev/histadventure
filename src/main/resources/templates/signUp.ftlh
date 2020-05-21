<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/login.css">
    <title>Document</title>
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->

        <div class="text-primary-fau">
            Registration
        </div>

        <!-- Login Form -->
        <form method="post" action="/signUp">
            <input type="text" id="login" class="fadeIn second" name="login" placeholder="login">
            <input type="email" id="email" name="email" class="fadeIn third" placeholder="email">
            <input type="password" id="password" class="fadeIn fourth" name="password" placeholder="password">
            <input type="submit" class="fadeIn fifth" value="Sign Up">
        </form>

        <!-- Remind Passowrd -->
        <div id="formFooter">
            <a class="underlineHover" href="/signUp">Already have an account?</a>
        </div>

    </div>
</div>
</body>
</html>
