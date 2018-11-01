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
                                            <br><a href="javascript:void(0)" id="fpassword" style="text-decoration: none" data-toggle="modal" data-target="#username">Forgot password ?</a>
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
                   
                </div>
            </div>
        </div>

        <!--get user name  Modal -->
        <div class="modal fade" id="username" role="dialog">
            <div class="modal-dialog modal-md">
                <div class="modal-content">  
                    <div class="modal-header" style="text-align:center">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <img src="resources/site_images/icon_forgot_password.png" style="height: 50px;width: 50px" alt=""/>
                        <p style="color: #286090; font-size: 25px;margin-bottom: -.7em">Forgot Password</p>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="checkuser" style="margin-left: 28%">

                            
                            <!--                            username<input type="text" name="uname"/>
                                                        <input type="submit" class="btn btn-default" style="margin-left: 100px; margin-top: 5px" value="Submit" />                            
                                                        <button type="button" class="btn btn-default" style="margin-top: 5px" data-dismiss="modal">Close</button>-->

                            <table>                                                    
                                <tr>
                                    <td>
                                        <label>Username &nbsp;</label>
                                    </td>
                                    <td>
                                        <input type="text" name="uname" class="form-control" placeholder="Enter Username" style="width: 84%" autofocus required>
                                    </td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td><p id="wronguser" style="display: none; color: red">Wrong Username !!<br> Please enter the correct username</p></td>
                                </tr>
                                <tr>
                                    <td>
                                    </td>
                                    <td>
                                        <input type="submit" value="Confirm" class="btn btn-primary" style="width: 40%">
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!--update password  Modal -->
        <div class="modal fade" id="newpass" role="dialog">
            <div class="modal-dialog modal-md">
                <div class="modal-content"> 
                    <div class="modal-header" style="text-align:center">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <img src="resources/site_images/icon_change_password.png" style="height: 50px;width: 50px" alt=""/>
                        <p style="color: #286090; font-size: 25px;margin-bottom: -.7em">Reset Password</p>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="recoverypassword" style="margin-left: 24%">
<!--                            <h2>Password Recovery</h2>
                            new password<br><input type="password" name="firstpass"/><br>
                            retype password<br><input type="password" name="pass"/>                            
                            <input type="submit" class="btn btn-default" style="margin-left: 100px; margin-top: 5px" value="Submit" />                            
                            <button type="button" class="btn btn-default" style="margin-top: 5px" data-dismiss="modal">Close</button>
                            -->
                            <table>                                                    
                                <tr>
                                    <td>
                                        <label> New Password &nbsp;</label>
                                    </td>
                                    <td>
                                        <input id="typePass" type="password" name="firstass" class="form-control" placeholder="New Password"  autofocus required>
                                    </td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td><p id="typePassMsg" style="color: tomato" hidden>Please enter Minimum 8 Characters </p></td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Re-type Password &nbsp;</label>
                                    </td>
                                    <td>
                                        <input id="reTypePass" type="password" name="secondPass" class="form-control" placeholder="Re-type Password" autofocus required>
                                    </td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td><p id="pasDontMatchMsg" style="color: red; display: none">Password don't match !! </p></td>
                                </tr>
                                <tr>
                                    <td>
                                    </td>
                                    <td>
                                        <input id='btnChangePas' type="submit" value="Reset" class="btn btn-primary" style="width: 40%">
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div> 
        <!--enter code  Modal -->
        <div class="modal fade" id="code_verify" role="dialog">
            <div class="modal-dialog modal-md">
                <div class="modal-content">   
                    <div class="modal-header" style="text-align: center">
                        <button type="button" class="close " data-dismiss="modal">&times;</button>
                        <img src="resources/site_images/icon_reset_password.png" style="height: 50px;width: 50px" alt=""/>
                        <p style="color: #286090; font-size: 20px;margin-bottom: -.7em">Recovery code has been sent to <b>${codetoemail}</b>.</p>
                        
                    </div>
                    <div class="modal-body" >
                        <form method="post" action="verifycode" style="margin-left: 28%">
                            
                            
<!--                            <input type="text" name="vcode"/>                            
                            <input type="submit" class="btn btn-primary" style="margin-left: 100px; margin-top: 5px" value="Submit" />  
                            -->
                            <table>                                                    
                                <tr>
                                    <td>
                                        <label>  Enter code &nbsp;</label>
                                    </td>
                                    <td>
                                        <input type="text" name="vcode" class="form-control" placeholder="Recovery Code" style="width: 84%" autofocus required>
                                    </td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td><p id="wrongcode" style="color: red; display: none">Wrong Code !!<br>Please enter correct code</p></td>
                                </tr>
                                <tr>
                                    <td>
                                    </td>
                                    <td>
                                        <input type="submit" value="Confirm" class="btn btn-primary" style="width: 40%">
                                    </td>
                                </tr>
                            </table>
                            
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <input type="hidden" value="${newpass}" id="mpass" style="display: none"/>
        <input type="hidden" id="codematchresult" value="${isCodeMatched}"/>

    </body>
    <script>
        var mpass = $("#mpass").val();
        //$("#newpass").modal("show");
        if (mpass === "yes") {
            $("#mpass").val('');
            $("#code_verify").modal("show");
        } else if (mpass === "no") {
            $("#wronguser").show("slow").delay(3000).slideUp("slow");
            $("#username").modal("show");
        }

        var matchcode = $("#codematchresult").val();
        console.log("match code : " + matchcode);
        if (matchcode === "yes") {
            $("#newpass").modal("show");
        } else if (matchcode === "no") {
            $("#wrongcode").show().delay(3000).slideUp("slow");
            $("#code_verify").modal("show");
        }

    </script>
</html>
