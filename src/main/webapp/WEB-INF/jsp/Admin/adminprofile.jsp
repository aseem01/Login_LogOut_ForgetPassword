<%-- 
    Document   : viewoperator
    Created on : Sep 30, 2018, 11:18:01 PM
    Author     : ASHIM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View User</title>
        <%@include file="head.jsp"%>
    </head>
    <body>
        <div class="main">
            <div class="container-fluid">
                <div>
                    <div class="row" style="background-color: #93958B">
                        <%@include file="header.jsp" %>
                    </div>
                </div>
                <div class="main">
                    <div class="row">
                        <div class="main_view" style="min-height: 45em">
                            <div class="col-md-1">

                            </div>
                            <form method="POST" action="updateadmin" ModelAttribute="User" enctype = "multipart/form-data" class="form-inline" style="margin-left: 18%">

                                <div class="col-md-10">
                                    <center><h2>Personal Information</h2></center>

                                    <hr>
                                    <div class="row">
                                        <div class="col-md-1"></div>
                                        <div class="col-md-4">
                                            <table>
                                                <tr>
                                                    <td> <img src="../${user.image}" id="blah" style="height: 250px;width: 250px;border-radius: 5px"></td>
                                                </tr>
                                                <tr>
                                                    <td><br></td>
                                                </tr>
                                                <tr>
                                                    <td style="text-align: center"> <label class="btn btn-primary glyphicon glyphicon-upload" style="width:100px">Upload<input type="file" id="imgInp" style="display: none"/></label></td>
                                                </tr>



                                            </table>
                                        </div>


                                        <div class="col-md-7 vl">
                                            <table>                                                    
                                                <input type="text" value="${user.id}" name="id" style="display: none"/>
                                                <tr>
                                                    <td>
                                                        <label>&nbsp;Full Name</label>
                                                    </td>
                                                    <td>
                                                        <input type="text" name="fullname" value="${user.fullname}" class="form-control" placeholder="Enter Fullname" style="width: 80%" autofocus required>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><br></td>
                                                    <td><br></td>
                                                </tr>



                                                <tr>
                                                    <td>
                                                        <label>Username</label>
                                                    </td>
                                                    <td>
                                                        <input type="text" name="username" value="${user.username}" class="form-control" placeholder="Enter Username" style="width: 80%"readonly>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td><br></td>
                                                    <td><br></td>
                                                </tr>

                                                <tr>
                                                    <td>
                                                        <label>Password</label>
                                                    </td>
                                                    <td>
                                                        <input type="password" name="password" class="form-control" placeholder="Enter new Password" style="width: 80%">
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td><br></td>
                                                    <td><br></td>
                                                </tr>


                                                <tr>
                                                    <td>
                                                        <label>Email </label>
                                                    </td>
                                                    <td>
                                                        <input type="email" name="email" value="${user.email}" class="form-control" placeholder="Enter Email" style="width: 80%" autofocus>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><br></td>
                                                    <td><br></td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <label>User-Type </label>
                                                    </td>
                                                    <td>
                                                        <input  type="text" name="usertype" value="${user.usertype}" class="form-control" placeholder="Enter Designation" style="width: 80%" autofocus readonly>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><br></td>
                                                    <td><br></td>
                                                </tr>                                                   
                                                <tr>
                                                    <td>
                                                        <label>Joining Date </label>
                                                    </td>
                                                    <td>
                                                        <input type="date" name="join" value="${user.joiningDate}" class="form-control" style="width: 80%" autofocus readonly>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><br></td>
                                                    <td><br></td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <label>Status</label>
                                                    </td>
                                                    <td><input name="status" value="${user.status}" class="form-control" style="width: 80%" readonly> </input>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><br></td>
                                                    <td><br></td>
                                                </tr> 
                                                <tr>
                                                    <td><button class="btn btn-primary glyphicon glyphicon-upload" style="width:100px;">Update</button></td>
                                                    <td><a href="dashboard"<button class="btn btn-danger glyphicon glyphicon-remove" style="width:100px;">Cancel</button></td>
                                                </tr>
                                            </table>



                                        </div>
                                    </div>


                                </div>
                                <div class="col-md-1">

                                </div>
                            </form>

                        </div>

                    </div>
                </div>
                <div class="row">
                    <div class="footer">
                        <%@include file="footer.jsp"%>
                    </div>
                </div>
            </div>
        </div>


    </body>
    <script>
        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#blah').attr('src', e.target.result);
                };

                reader.readAsDataURL(input.files[0]);
            }
        }

        $("#imgInp").change(function () {
            readURL(this);
        });
    </script>
</html>
