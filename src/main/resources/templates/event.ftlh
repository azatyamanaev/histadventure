<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Event</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="js/main.js"></script>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="/css/modal.css">
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
            <tbody>
            <tr>
                <td>Event name</td>
                <td>${event.name}</td>
            </tr>
            <tr>
                <td>Participants</td>
                <td>
                    <div class="btn-group" role="group">
                        <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Participants
                        </button>
                        <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                            <p class="dropdown-item">
                                <#list participants as participant>
                                    <a href="/other_profile?login=${participant.login}">${participant.login}</a><br>
                                </#list>
                            </p>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>Description</td>
                <td>${event.description}</td>
            </tr>
            <tr>
                <td>Capacity</td>
                <td>${event.capacity}</td>
            </tr>
            <tr>
                <td>Host</td>
                <td>${event.host}</td>
            </tr>
            <tr>
                <td>Time Start</td>
                <td>${event.timeStart}</td>
            </tr>
            <tr>
                <td>Time End</td>
                <td>${event.timeEnd}</td>
            </tr>
            <tr>
                <td>Likes</td>
                <td>${event.countLike}</td>
            </tr>
            </tbody>
        </table>
        <button class="btn btn-info" onclick="location.href='/subscribe?event_name=${event.name}'">subscribe</button>
        <button class="btn btn-secondary" onclick="location.href='/participate?event_name=${event.name}'">participate
        </button>
        <#if login == event.host>
        <button type="button" class="btn btn-danger" data-toggle="modal"
        data-target="#sem-reg">
        Edit
        </button>
        </#if>

    </div>
</header>
<!-- The Modal -->
<div class="modal fade seminor-login-modal" data-backdrop="static" id="sem-reg">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <!-- Modal body -->
            <div class="modal-body seminor-login-modal-body">
                <h5 class="modal-title text-center">CHANGE DETAILS OF AN EVENT</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>


                <form id="eventForm" class="seminor-login-form" action="/event" method="post">
                    <div class="form-group">
                        <input type="text" name="name" class="form-control" required autocomplete="off">
                        <label class="form-control-placeholder" for="name">Event name</label>
                    </div>
                    <div class="form-group">
                        <input type="text" name="description" class="form-control" required autocomplete="off">
                        <label class="form-control-placeholder" for="name">Description</label>
                    </div>
                    <div class="form-group">
                        <input type="number" name="capacity" class="form-control" required autocomplete="off">
                        <label class="form-control-placeholder" for="name">Capacity</label>
                    </div>
                    <div class="form-group">
                        <input type="text" name="place" class="form-control" required autocomplete="off">
                        <label class="form-control-placeholder" for="name">Place</label>
                    </div>
                    <div class="form-group">
                        <input type="datetime-local" name="time_start" class="form-control" required autocomplete="off">
                        <label class="form-control-placeholder" for="name">Time Start</label>
                    </div>
                    <div class="form-group">
                        <input type="datetime-local" name="time_end" class="form-control" required autocomplete="off">
                        <label class="form-control-placeholder" for="name">Time end</label>
                    </div>
                    <input type="hidden" name="pr_name" value="${event.name}">
                    <div class="btn-check-log">
                        <button type="submit" class="btn-check-login">SAVE CHANGES</button>
                    </div>
                </form>


            </div>
        </div>
    </div>
</div>
</body>
</html>
