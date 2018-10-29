<%-- 
    Document   : index
    Created on : Oct 28, 2018, 2:03:57 AM
    Author     : Monirul Islam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resources/css/jquery.alerts.css" type="text/css" />
        <link rel="stylesheet" href="resources/css/style.css" type="text/css" />
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css" />

        <script src="resources/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="resources/js/jquery.alerts.js" type="text/javascript"></script>
        <script src="resources/js/sweetAlert.js" type="text/javascript"></script>
        <script src="resources/js/jquery.ui.draggable.js" type="text/javascript"></script>
        <script src="resources/js/co_op.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container-fluid">

            <div class="row" style="background-color: #93958B">
                <div class="col-md-3" style="background-color: #B3A99C">
                    <img src="software/org_logo/imcsl_logo.png" style="height: 85px;width: 340px;float: left">
                </div>
                <div class="col-md-9">
                    <h1 style="color: #1D3575"><strong>Improvement Multipurpose Co-operative Society Ltd.</strong></h1>
                </div>
            </div>

            <div class="row">

                <div class="main" style="">
                    <div class="col-md-4">

                    </div>
                    <div class="col-md-4" style="background-color: #eaecef;margin-top: 3em">

                        <div class="row">
                            <br>
                            <img src="resources/site_images/login_logo1.png" style="border-radius: 50%;" height="115" width="115" class="center">
                            
                            <hr style="margin-bottom: -15px">
                            
                            <h3 id="loginHere"> Login Here</h3>
                            <input type="hidden" id="hideByInput" value=${controllerReply}>
                            <p style="color: #286090;text-align: center" id="hideP">${controllerReply}</p>
                            <hr style="margin-top: -2px">
                        </div>
                        <div class="row" style="background-color: #d2d8e0">

                            <form id="login-form" method="POST" action="UserLogin" class="form-inline" autocomplete="off" style="margin-left: 18%">
                                <br>
                                <table>
                                    <tr>
                                        <td>
                                            <label>Username &nbsp;</label>
                                        </td>
                                        <td>
                                            <input id="userNameValidation" type="text" name="username" class="form-control" placeholder="Enter Username"  autofocus required>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> <br></td>
                                        <td> <br></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Password &nbsp;</label>
                                        </td>
                                        <td>
                                            <input id="passwordValidation" type="password" name="password" class="form-control" placeholder="Enter Password"  autofocus  required>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> <br></td>
                                        <td> <p id="passwordValidationMsg" class="validationMsg" hidden><b>Please Enter Minimum 8 <br>Characters</b></p></td>
                                    </tr>
                                    <tr>
                                        <td>

                                        </td>
                                        <td>
                                            <input type="submit" value="Login" class="btn btn-primary" style="width: 50%">
                                        </td>
                                    </tr>
                                </table>

                                <br>


                            </form>
                        </div>
                    </div>
                    <div class="col-md-4">

                    </div>
                </div>

            </div>

            <div class="row">
                <div class="footer">
                    sd
                </div>
            </div>
        </div>

    </body>
</html>
