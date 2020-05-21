<!doctype html>
<html lang="en">
<head>
    <title>Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="js/profile.js"></script>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="/css/modal.css">
</head>

<body>
<hr>
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
<header class="header2">

    <div class="container bootstrap snippet user-info">

        <div class="row">
            <div class="col-sm-3"><!--left col-->


                <div class="text-center">
                    <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail"
                         alt="avatar">
                </div>
                </hr><br>


                <ul class="list-group">
                    <li class="list-group-item text-muted">Activity <i class="fa fa-dashboard fa-1x"></i></li>
                    <li class="list-group-item text-right"><span class="pull-left"><strong>Likes</strong></span> ${likes}</li>
                </ul>

            </div><!--/col-3-->
            <div class="col-sm-9">


                <div class="tab-content">
                    <div class="tab-pane active" id="home">
                        <hr>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="login"><h4>Login</h4></label>
                                <input type="text" class="form-control" name="login" id="login"
                                       placeholder="login" value="${login}">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="email"><h4>Email</h4></label>
                                <input type="email" class="form-control" name="email" id="email"
                                       placeholder="you@email.com" value="${email}">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-12">
                                <br>
                                <button class="btn btn-success" onclick="saveChanges()"><i
                                            class="glyphicon glyphicon-ok-sign"></i> Save
                                </button>
                                <button class="btn" onclick="location.href='/logout'">Logout</button>
                                <button type="button" class="btn btn-outline-primary" data-toggle="modal"
                                        data-target="#sem-reg">
                                    Create event
                                </button>
                                <div class="btn-group" role="group">
                                    <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle"
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Created events
                                    </button>
                                    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                                        <p class="dropdown-item">
                                            <#list created_events as cr_event>
                                                <a href="/event?event_name=${cr_event.name}">${cr_event.name}</a><br>
                                            </#list>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <hr>

                    </div><!--/tab-pane-->

                </div><!--/tab-pane-->
            </div><!--/tab-content-->

        </div><!--/col-9-->
    </div><!--/row-->


    <!-- The Modal -->
    <div class="modal fade seminor-login-modal" data-backdrop="static" id="sem-reg">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">

                <!-- Modal body -->
                <div class="modal-body seminor-login-modal-body">
                    <h5 class="modal-title text-center">CREATE AN EVENT</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>


                    <form id="eventForm" class="seminor-login-form" action="/createEvent" method="post">
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
                        <div class="btn-check-log">
                            <button type="submit" class="btn-check-login">CREATE EVENT</button>
                        </div>
                    </form>


                </div>
            </div>
        </div>
    </div>

</header>
<script>
    function saveChanges() {
        $.ajax({
            url: "/profile",
            method: "POST",
            data: "login=" + $('#login').val() + "&email=" + $('#email').val(),
            success: function (response) {
                alert(response);
            }
        });
    }

    function chooseImage() {
        alert("sss");
        let formData = new FormData();
        let files = ($('#file'))[0]['files'];
        [].forEach.call(files, function (file, i, files) {
            formData.append("file", file);
        });

        $.ajax({
            type: "POST",
            url: "/profile_image",
            data: formData,
            processData: false,
            contentType: false,
            cache: false
        })
            .success(function () {
                alert('success');
            })
            .fail(function () {
                alert('Error');
            });
    }

    function createEvent() {
        let form = $('#eventForm');
        $.ajax({
            url: "/createEvent",
            method: "POST",
            data: "name=" + form.elements.name + "&description=" + form.elements.description + "&capacity=" + form.elements.capacity +
            "&place=" + form.elements.place + "&time_start=" + form.elements.time_start + "&time_end=" + form.elements.time_end,
            success: function (response) {
                alert(response);
            }
        });
    }

</script>
</body>
</html>
