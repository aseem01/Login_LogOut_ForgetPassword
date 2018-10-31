<div class="col-md-3" style="background-color: #B3A99C">
    <img src="../software/org_logo/imcsl_logo.png" style="height: 85px;width: 340px;float: left">
</div>
<div class="col-md-6">
    <div class="row" style="margin-top: -.5em;margin-bottom: -.5em;text-align: center">
        <h3 style="color: #1D3575;"><strong>Improvement Multipurpose Co-operative Society Ltd.</strong></h3>
    </div>

    <div class="row" style="margin-bottom: -.7em">
        <div class="menubar">
            <%@include file="menubar.jsp" %>
        </div>

    </div>
</div>

<div class="col-md-3" style="display: block;margin-top: auto;margin-bottom: auto">

    <div class="col-md-4" style="">
        <img src="../<%= user.getImage()%>"  style="border-radius: 50%;margin-top: .4em;float: right" height="70" width="70">
        <p></p>
    </div>
    <div class="col-md-8" style="">

        <div id="profileName">
            <br>
            <strong><b style="color: white;"><%= user.getFullname()%></b></strong>
            <br>
        </div>
        <div id="btnLogOut">
             <a href="profileview">
                <button type="button" class="btn btn-sm">
                    <span class="glyphicon glyphicon-edit"></span>Profile
                </button>
            </a>
            <a href="Logout" >
                <button type="button" class="btn btn-danger btn-sm">
                    <span class="glyphicon glyphicon-log-out"></span> Log out
                </button>
            </a>
           
        </div>
            
    </div>

</div>
