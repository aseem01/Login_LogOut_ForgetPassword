<div class="footer">
    <div class="col-md-6" style="font-size: 13px">
        <h4><%= user.getBankInfo().getBankName()%></h4>
        <p><%= user.getBankInfo().getBankAddress()%></p>
        <p>Mobile : <%=user.getBankInfo().getBankContactno() %></p>
        <p>E-mail : <%= user.getBankInfo().getBankEmail() %></p>
    </div>
    <div class="col-md-6">
        
    </div>
</div>


