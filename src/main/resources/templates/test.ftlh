<!doctype html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<div class="container">
    <h2>Modal login Example</h2>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#sem-login">
        Open modal
    </button>

    <br/>
    <br/>

    <h2>Modal Reg Example</h2>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#sem-reg">
        Open modal
    </button>


    <!-- The Modal -->
    <div class="modal fade seminor-login-modal" data-backdrop="static" id="sem-reg">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">

                <!-- Modal body -->
                <div class="modal-body seminor-login-modal-body">
                    <h5 class="modal-title text-center">CREATE AN ACCOUNT</h5>
                    <button type="button" class="close" data-dismiss="modal">
                        <span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
                    </button>


                    <form class="seminor-login-form">
                        <div class="form-group">
                            <input type="name" class="form-control" required autocomplete="off">
                            <label class="form-control-placeholder" for="name">User Name</label>
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-control" required autocomplete="off">
                            <label class="form-control-placeholder" for="name">Email address</label>
                        </div>
                        <div class="form-group">
                            <label class="select-form-control-placeholder" for="sel1">profession</label>
                            <select class="form-control" id="sel1" name="sellist1">
                                <option>Select profession</option>
                                <option>Students</option>
                                <option>Research Scholar</option>
                                <option>Professor</option>
                                <option>Others</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="tel" class="form-control" required autocomplete="off">
                            <label class="form-control-placeholder" for="name">Phone Number</label>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" required autocomplete="off">
                            <label class="form-control-placeholder" for="name">Organization</label>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" required autocomplete="off">
                            <label class="form-control-placeholder" for="name">Designation</label>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" required autocomplete="off">
                            <label class="form-control-placeholder" for="name">City</label>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" required autocomplete="off">
                            <label class="form-control-placeholder" for="password">Password</label>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" required autocomplete="off">
                            <label class="form-control-placeholder" for="password">Confirm Password</label>
                        </div>

                        <div class="form-group forgot-pass-fau text-center ">
                            <a href="/terms-conditions/" class="text-secondary">
                                By Clicking "SIGN UP" you accept our<br>
                                <span class="text-primary-fau">Terms and Conditions</span>
                            </a>
                        </div>

                        <div class="btn-check-log">
                            <button type="submit" class="btn-check-login">SIGN UP</button>
                        </div>
                        <div class="create-new-fau text-center pt-3">
                            <a href="#" class="text-primary-fau"><span data-toggle="modal" data-target="#sem-login" data-dismiss="modal">Already Have An Account</span></a>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>




    <!-- The Modal -->
    <div class="modal fade seminor-login-modal" data-backdrop="static" id="sem-login">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">

                <!-- Modal body -->
                <div class="modal-body seminor-login-modal-body">
                    <h5 class="modal-title text-center">LOGIN TO MY ACCOUNT</h5>
                    <button type="button" class="close" data-dismiss="modal">
                        <span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
                    </button>


                    <form class="seminor-login-form">
                        <div class="form-group">
                            <input type="email" class="form-control" required autocomplete="off">
                            <label class="form-control-placeholder" for="name">Email address</label>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" required autocomplete="off">
                            <label class="form-control-placeholder" for="password">Password</label>
                        </div>
                        <div class="form-group">
                            <label class="container-checkbox">
                                Remember Me On This Computer
                                <input type="checkbox" checked="checked" required>
                                <span class="checkmark-box"></span>
                            </label>
                        </div>

                        <div class="btn-check-log">
                            <button type="submit" class="btn-check-login">LOGIN</button>
                        </div>


                        <div class="forgot-pass-fau text-center pt-3">
                            <a href="/reset_pass" class="text-secondary">Forgot Your Password?</a>

                        </div>
                        <div class="create-new-fau text-center pt-3">
                            <a href="#" class="text-primary-fau"><span data-toggle="modal" data-target="#sem-reg" data-dismiss="modal">Create A New Account</span></a>
                        </div>



                    </form>

                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
<div class="modal fade seminor-login-modal" data-backdrop="static" id="sem-reg">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <!-- Modal body -->
            <div class="modal-body seminor-login-modal-body">
                <h5 class="modal-title text-center">CREATE AN ACCOUNT</h5>
                <button type="button" class="close" data-dismiss="modal">
                    <span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
                </button>


                <form class="seminor-login-form" method="post" action="/signUp">
                    <div class="form-group">
                        <input type="text" name="login" class="form-control" required autocomplete="off">
                        <label class="form-control-placeholder" for="name">Login</label>
                    </div>
                    <div class="form-group">
                        <input type="email" name="email" class="form-control" required autocomplete="off">
                        <label class="form-control-placeholder" for="name">Email</label>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" required autocomplete="off">
                        <label class="form-control-placeholder" for="password">Password</label>
                    </div>

                    <div class="form-group forgot-pass-fau text-center ">
                        <a href="/terms-conditions/" class="text-secondary">
                            By Clicking "SIGN UP" you accept our<br>
                            <span class="text-primary-fau">Terms and Conditions</span>
                        </a>
                    </div>

                    <div class="btn-check-log">
                        <button type="submit" class="btn-check-login">SIGN UP</button>
                    </div>
                    <div class="create-new-fau text-center pt-3">
                        <a href="#sem-login" class="text-primary-fau"><span data-toggle="modal" data-target="#sem-login" data-dismiss="modal">Already Have An Account</span></a>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>

<div class="modal fade seminor-login-modal" data-backdrop="static" id="sem-login">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <!-- Modal body -->
            <div class="modal-body seminor-login-modal-body">
                <h5 class="modal-title text-center">LOGIN TO MY ACCOUNT</h5>
                <button type="button" class="close" data-dismiss="modal">
                    <span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
                </button>


                <form class="seminor-login-form" method="post" action="/logIn">
                    <div class="form-group">
                        <input type="text" name="login" class="form-control" required autocomplete="off">
                        <label class="form-control-placeholder" for="name">Login</label>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" required autocomplete="off">
                        <label class="form-control-placeholder" for="password">Password</label>
                    </div>
                    <!--<div class="form-group">
                        <label class="container-checkbox">
                            Remember Me On This Computer
                            <input type="checkbox" checked="checked" required>
                            <span class="checkmark-box"></span>
                        </label>
                    </div>-->

                    <div class="btn-check-log">
                        <button type="submit" class="btn-check-login">LOGIN</button>
                    </div>


                    <div class="forgot-pass-fau text-center pt-3">
                        <a href="/reset_pass" class="text-secondary">Forgot Your Password?</a>

                    </div>
                    <div class="create-new-fau text-center pt-3">
                        <a href="#sem-reg" class="text-primary-fau"><span data-toggle="modal" data-target="#sem-reg" data-dismiss="modal">Create A New Account</span></a>
                    </div>


                </form>

            </div>
        </div>
    </div>
</div>
