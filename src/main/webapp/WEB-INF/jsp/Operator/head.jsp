<%@page import="com.bank.model.User"%>
<%
    User user=(User)session.getAttribute("user");
    
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--<link rel="icon" href="../<%= user.getBankInfo().getBankLogo()%>">-->
<link rel="icon" href="../software/org_icon/imcsl_icon.jpg">
<title><%= user.getBankInfo().getBankName() %></title>
<link rel="stylesheet" href="../resources/css/jquery.alerts.css" type="text/css" />
<link rel="stylesheet" href="../resources/css/style.css" type="text/css" />
<link rel="stylesheet" href="../resources/css/bootstrap.min.css" type="text/css" />
<link href="../resources/DataTables/datatables.min.css" rel="stylesheet" type="text/css"/>

<script src="../resources/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="../resources/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../resources/js/jquery.alerts.js" type="text/javascript"></script>
<script src="../resources/js/sweetAlert.js" type="text/javascript"></script>
<script src="../resources/js/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="../resources/js/co_op.js" type="text/javascript"></script>
<script src="../resources/DataTables/datatables.min.js" type="text/javascript"></script>

    