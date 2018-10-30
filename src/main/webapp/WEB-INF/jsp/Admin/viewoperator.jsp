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
        <div class="main_container">
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
                            <div class="col-md-10">
                                <center><h2>User List</h2></center>
                                <p style="text-align: center;color: #449d44" id="msg">${successMsg}</p>
                                <hr>
                                <table id="mydata" class="table table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th style="width: 18%;text-align: center">Image</th>
                                            <th style="width: 17%;text-align: center">Name</th>
                                            <th style="width: 17%;text-align: ceneter">User Type</th>
                                            <th style="width: 16%;text-align: center">Status</th>
                                            <th style="width: 16%;text-align: center">Joining Date</th>
                                            <th style="width: 17%;text-align: center">Remark</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${userlist}" var="user">
                                            <tr>
                                                <td align="center"><img src="../${user.image}" style="height: 55px;width: 55px"></td>
                                                <td algin="center">${user.fullname}</td>
                                                <td align="center">${user.usertype}</td>
                                                <td align="center">${user.status}</td>
                                                <td align="center">${user.joiningDate}</td>
                                                <td align="center"><button data-toggle="modal"  data-target="#myModal${user.id}" type="button" class="btn btn-default" style="background-color: #ccf2ff;width: 50%"><font color="black">Update</font></button></td>                                            
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="col-md-1">

                            </div>


                            <c:forEach items="${userlist}" var="user">
                                <div id="myModal${user.id}" class="modal fade" role="dialog">
                                <div class="modal-dialog">
                                    <!--Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header" style="text-align:center">
                                            <button type="button" class="close" data-dismiss="modal">&times</button>
                                            <img src="../resources/site_images/logo_update_user.png" style="height: 45px;width: 45px" alt=""/>
                                            <p style="color: #286090; font-size: 25px;margin-bottom: -.7em">Update User Information</p>
                                            
                                        </div>
                                        <div class="modal-body modelhid" >
                                            <form method="POST" action="updateoperator" ModelAttribute="User" class="form-inline" style="margin-left: 26%">
                                                </br>
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
                                                            <label>Email </label>
                                                        </td>
                                                        <td>
                                                            <input type="email" name="email" value="${user.email}" class="form-control" placeholder="Enter Email" style="width: 80%" autofocus readonly>
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
                                                            <input type="text" name="usertype" value="${user.usertype}" class="form-control" placeholder="Enter Designation" style="width: 80%" autofocus required>
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
                                                            <input type="date" name="join" value="${user.joiningDate}" class="form-control" style="width: 80%" autofocus required>
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
                                                        <td><select name="status" value="${user.status}" class="form-control" style="width: 80%">
                                                                <option value="Active">Active</option>
                                                                <option value="Inactive">Inactive</option>
                                                            </select>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><br></td>
                                                        <td><br></td>
                                                    </tr>                                                    

<!--                                                    <tr>
                                                        <td><br></td>
                                                        <td><br></td>
                                                    </tr>-->
                                                    <tr>
                                                        <td>
                                                        </td>
                                                        <td>
                                                            <input type="submit" value="Update" class="btn btn-primary" style="width: 40%">
                                                        </td>
                                                    </tr>
                                                </table>
                                                <br><br>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
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
        <script>
            $(document).ready(function () {
                $("#mydata").DataTable({
                    "pagingType": "simple_numbers",
                    language: {
                        search: "_INPUT_",
                        searchPlaceholder: "Search..."
                    }
                });
                
                $("#msg").delay(3000).slideUp(500);
            });
            
            
        </script>

    </body>
</html>
