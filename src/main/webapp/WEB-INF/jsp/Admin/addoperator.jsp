<%-- 
    Document   : addoperator
    Created on : Sep 30, 2018, 11:15:53 PM
    Author     : ASHIM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Operator</title>
        <%@include file="head.jsp"%>
    </head>
    <body>
        <div class="main_container">

            <div class="container-fluid">
                <div>

                    <div class="row" style="background-color: #93958B">
                        <%@include file="header.jsp" %>
                    </div>

                </div>
                <div class="row">
                    <br>
                    <br>
                    <div class="leftSideBar">

                        <div class="col-md-3">

                        </div>

                    </div>
                    <div class="col-md-6" style="background-color: #eaecef">
                        <img src="../resources/site_images/signup.png" alt=""  style="height: 25%;width: 25%;margin-left: 37%"/>  
                        <hr style="border-bottom: 1px solid green">
                        <form method="POST" action="AddOperator" ModelAttribute="User" enctype = "multipart/form-data" class="form-inline" style="margin-left: 18%">
                            </br> 
                            <table>

                                <tr>
                                    <td>
                                        <label>FullName :</label>
                                    </td>
                                    <td>
                                        <input type="text" name="fullname" class="form-control" placeholder="Enter Fullname" style="width: 80%" autofocus required>
                                    </td>
                                </tr>


                                <tr>
                                    <td><br></td>
                                    <td><br></td>
                                </tr>

                                <tr>
                                    <td>
                                        <label>Email :</label>
                                    </td>
                                    <td>
                                        <input type="email" name="email" class="form-control" placeholder="Enter Email" style="width: 80%" autofocus required>
                                    </td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td><br></td>
                                </tr>



                                <tr>
                                    <td>
                                        <label>Username :</label>
                                    </td>
                                    <td>
                                        <input type="text" name="username" class="form-control" placeholder="Enter Username" style="width: 80%" autofocus required>
                                    </td>

                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td><br></td>
                                </tr>

                                <tr>
                                    <td>
                                        <label>Password :</label>
                                    </td>
                                    <td>
                                        <input type="text" name="password" class="form-control" placeholder="Enter Password" style="width: 80%" autofocus required>
                                    </td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td><br></td>
                                </tr>

                                <tr>
                                    <td>
                                        <label>User Type</label>
                                    </td>
                                    <td><select name="usertype" class="form-control" style="width: 80%">
                                            <option value="Operator">Operator</option>
                                            <option value="Admin">Admin</option>
                                        </select>

                                    </td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td><br></td>
                                </tr>

                                <tr>
                                    <td>
                                        <label>Joining Date :</label>
                                    </td>
                                    <td>
                                        <input type="date" name="join" class="form-control" style="width: 80%" autofocus required>
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
                                    <td><select name="status" class="form-control" style="width: 80%">
                                            <option value="Active">Active</option>
                                            <option value="InActive">InActive</option>
                                        </select>

                                    </td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td><br></td>
                                </tr>

                                <tr>
                                    <td>
                                        <label>Image :</label>
                                    </td>
                                    <td>
                                        <input type="file" name="upload" class="form-control" style="width: 80%" autofocus required>
                                    </td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td><br></td>
                                </tr>
                                <tr>
                                    <td>

                                    </td>
                                    <td>
                                        <input type="submit" value="Register" class="btn btn-primary" style="margin-left: 1%;width: 40%">
                                    </td>
                                </tr>

                            </table>
                            <br><br>
                        </form>
                    </div>
                </div>

                <div class="right">

                    <div class="col-md-3">

                    </div>

                </div>

            </div>
            <br>
            <div class="row">
                <%@include file="footer.jsp"%>
            </div>

        </div>

    </div>
</body>
</html>
