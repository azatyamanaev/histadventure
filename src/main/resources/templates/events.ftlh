<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/fontawesome-free-5.11.2-web/css/all.css">
    <script src="js/main.js"></script>
    <link rel="stylesheet" href="css/main.css">
    <title>Events</title>
</head>
<body>
<nav class="navbar navbar-expand-lg fixed-top ">
    <a class="navbar-brand" href="/"><img src="images/logo.png" alt="Evento"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse " id="navbarSupportedContent">
        <ul class="navbar-nav mr-4">
            <li class="nav-item">
                <a class="nav-link" href="/profile">Profile</a></li>
            <li class="nav-item">
                <a class="nav-link " href="/events">Events</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/chat">Contact</a></li>
        </ul>
    </div>
</nav>
<header class="header">
    <div class="overlay"></div>
    <div class="container events">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Event</th>
                <th scope="col">Description</th>
                <th scope="col">Info</th>
            </tr>
            </thead>
            <tbody>
            <#list events as event>
                <tr>
                    <td>${event.name}</td>
                    <td>${event.description}</td>
                    <td>
                        <button class="btn btn-link" onclick="location.href='/event?event_name=${event.name}'">event info</button>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</header>
</body>
</html>