/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
$("#btnLogOut").hide();
//    var hide=$("#hideByInput").val().toString();
//    if(hide.length === 0)
//    {
//        $("#hideP").hide();
//       
//    }
//    else{
////        $("#loginHere").hide();
//        $("#hideP").delay(8000).fadeOut(2000);
//        //$("#loginHere").show();
//    }

    
    $("#userNameValidation").keyup(function () {
        var userName = $("#userNameValidation").val().toString();

        if (userName.length < 6)
        {
            $("#userNameValidationMsg").slideDown(1000);
        } else {
            $("#userNameValidationMsg").slideUp(1000);
        }
    });


    $("#passwordValidation").keyup(function () {
        var password = $("#passwordValidation").val().toString();

        if (password.length < 8)
        {
            $("#passwordValidationMsg").slideDown(1000);
        } else {
            $("#passwordValidationMsg").slideUp(1000);
        }
    });


    $("#profileName").mouseenter(function () {
        $("#btnLogOut").slideDown(500);
    });

    $("#profileName").mouseleave(function () {
        $("#btnLogOut").delay(1500).slideUp(500);

    });
    
   $("#reTypePass").keyup(function (){
       var pas1=$("#reTypePass").val().toString();
       var pas2=$("#typePass").val().toString();
       
       if(pas1 !== pas2)
       {
           $("#pasDontMatchMsg").slideDown(400);
           $("#btnChangePas").slideUp(400);
       }
       else{
           $("#pasDontMatchMsg").slideUp(400);
           $("#btnChangePas").slideDown(400);
       }
   });
   
   $("#typePass").keyup(function (){
       var password = $("#typePass").val().toString();

        if (password.length < 8)
        {
            $("#typePassMsg").slideDown(500);
        } else {
            $("#typePassMsg").slideUp(500);
        }
   });
    
    $("#controllerMsg").delay(3000).slideUp(500);
});


