
$(document).ready(function(){
    $('[data-toggle="offcanvas"]').click(function(){
        $('#side-menu').toggleClass('hidden-xs');
    });
    
   
    $.ajax({
        type: 'post',
        url: "../PromoController.do",
        data: {'action': 'isValidPromoCode'},
        dataType: "json",
        restful: true,
        cache: false,
        timeout: 20000,
        async: true,
        success: function (data) {

        },
        error: function () {

        }
    });
 
    
 /*Start of coupan view */
    coupanTableData();
    function coupanTableData()
    {
        $.ajax({
            type: 'post',
            url: '../PromoController.do',
            data: {'action': 'getAllPromoCode'},
            dataType: "json",
            restful: true,
            cache: false,
            timeout: 20000,
            async: true,
            success: function (data) {
                var actionLinks;
                if (data.message === "success") {
                    $('#coupanVDisplay').DataTable().clear().draw();
                    jQuery(data.coupan).each(function (i, item) {
                        var id = item.server_id;
                        var dataItem = JSON.stringify(item);
                        if (item.Status === "Active")
                        {
                            actionLinks = "<div class='btn-group'><button class='btn btn-primary btn-xs dropdown-toggle' data-placement='left' type='button' data-toggle='dropdown' aria-expanded='false'>Action <i class='fa fa-angle-down'></i></button><ul class='dropdown-menu' style='left:-100px' role='menu'><li><a href='#' onclick='coupanProfileView(" + dataItem + ");'>View Coupan</a></li><li><a href='#' onclick='coupanProfileEdit(" + dataItem + ");'>Edit Coupan</a></li><li><a href='#' onclick='coupanProfileBlock(" + dataItem + ");'>Block Coupan</a></li></ul></div>";
                        } else
                            actionLinks = "<div class='btn-group'><button class='btn btn-primary btn-xs dropdown-toggle' data-placement='left' type='button' data-toggle='dropdown' aria-expanded='false'>Action <i class='fa fa-angle-down'></i></button><ul class='dropdown-menu' style='left:-100px' role='menu'><li><a href='#' onclick='coupanProfileView(" + dataItem + ");'>View Coupan</a></li><li><a href='#' onclick='coupanProfileEdit(" + dataItem + ");'>Edit Coupan</a></li><li><a href='#' onclick='coupanProfileBlock(" + dataItem + ");'>Active Coupan</a></li></ul></div>";
                        $('#coupanVDisplay').DataTable().row.add([
                            item.CoupanCode,
                            item.StartDate,
                            item.EndDate,
                            item.Discount,
                            item.Date,
                            item.Status,
                            actionLinks
                        ]).draw(false);
                    });
                } else {
//                    if (document.getElementById('errorCoupanV').style.display === 'none') {
//                        document.getElementById('errorCoupanV').style.display = 'block';
//                        document.getElementById("errorCoupanV").innerHTML = data.message;
//                    } else
//                    {
//                        document.getElementById("errorCoupanV").innerHTML = data.message;
//                    }
                }
            },
            error: function () {
                if (document.getElementById('errorCoupanV').style.display === 'none') {
                    $("#errorCoupanV").css("display =block");
                    $("#errorCoupanV").html("Something went wrong. Please try after some time!");
                } else
                {
                    $("#errorCoupanV").html("Something went wrong. Please try after some time!");
                }
            }
        });
    }
    /*End  of coupan view */
 
    
});

/*===============================viewAllCustomer.jsp ======================*/
$(document).ready(function(){
$("#mytable #checkall").click(function () {
        if ($("#mytable #checkall").is(':checked')) {
            $("#mytable input[type=checkbox]").each(function () {
                $(this).prop("checked", true);
            });

        } else {
            $("#mytable input[type=checkbox]").each(function () {
                $(this).prop("checked", false);
            });
        }
    });
    
//    $("[data-toggle=tooltip]").tooltip();
  $('input[type="number"].required').keypress(function (e) {
        //if the letter is not digit then display error and don't type anything
        $(this).css({"border": "", "background": ""});
        if (e.which !== 8 && e.which !== 0 && (e.which < 48 || e.which > 57)) {
            $("#staffError").css("display =block");
            $("#staffError").html("Please enter digits only eg. (0-9)");
            $("#staffError").fadeTo(7000, 500).slideUp(500, function () {
                $("#staffError").slideUp(500);
            });
            return false;
        }
    });

    $('input[type="text"].required').keypress(function (e) {
        $(this).css({"border": "", "background": ""});
        if (e.which !== 8 && e.which !== 0 && (e.which < 65 || e.which > 90) && (e.which < 97 || e.which > 122)) {
            //display error message
            $("#staffError").css("display =block");
            $("#staffError").html("Please enter only character eg. (a-z & A-Z)");
            $("#staffError").fadeTo(7000, 500).slideUp(500, function () {
                $("#staffError").slideUp(500);
            });
            return false;
        }
    });

    $('select[name="dropdownlist"].required').change(function () {
        $(this).css({"border": "", "background": ""});

    });
});
/*Start of add new coupan*/
    $("#addnewCoupan").click(function () {
        $('input[type="text"]').each(function () {
            $(this).css({
                "border": "",
                "background": ""
            });
        });
        var code = $("#code").val();
        if (typeof code === 'undefined' || !code)
        {
            $("#coupanError").css("display =block");
            $("#coupanError").html("Please enter the Coupan Code");
            $("#coupanError").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#coupanError").slideUp(1000);
            });
            $('#code').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else if ($('#code').val().length > 20)
        {
            $("#coupanError").css("display=block");
            $("#coupanError").html("Coupan Code can't be more than 20 characters");
            $("#coupanError").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#coupanError").slideUp(1000);
            });
            $('#code').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else
        {
            $('#code').css({"border": "", "background": ""});
        }
        var sdate = $("#sdate").val();
        if (typeof sdate === 'undefined' || !sdate)
        {
            $("#coupanError").css("display =block");
            $("#coupanError").html("Please enter the Start Date");
            $("#coupanError").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#coupanError").slideUp(1000);
            });
            $('#sdate').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else if ($('#sdate').val().length > 20)
        {
            $("#coupanError").css("display=block");
            $("#coupanError").html("Start Date can't be more than 20 characters");
            $("#coupanError").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#coupanError").slideUp(1000);
            });
            $('#sdate').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else
        {
            $('#sdate').css({"border": "", "background": ""});
        }
        var edate = $("#edate").val();
        if (typeof edate === 'undefined' || !edate)
        {
            $("#coupanError").css("display =block");
            $("#coupanError").html("Please enter the Expiry Date");
            $("#coupanError").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#coupanError").slideUp(1000);
            });
            $('#edate').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else if ($('#edate').val().length > 20)
        {
            $("#coupanError").css("display=block");
            $("#coupanError").html("Expiry Date can't be more than 20 characters");
            $("#coupanError").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#coupanError").slideUp(1000);
            });
            $('#edate').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else
        {
            $('#edate').css({"border": "", "background": ""});
        }
        var discount = $("#discount").val();
        if (typeof discount === 'undefined' || !discount)
        {
            $("#coupanError").css("display =block");
            $("#coupanError").html("Please enter the Discount");
            $("#coupanError").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#coupanError").slideUp(1000);
            });
            $('#discount').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else if ($('#discount').val().length > 20)
        {
            $("#coupanError").css("display=block");
            $("#coupanError").html("Discount can't be greater than 20 characters");
            $("#coupanError").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#coupanError").slideUp(1000);
            });
            $('#discount').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else
        {
            $('#discount').css({"border": "", "background": ""});
        }
        $.ajax({
            type: "POST",
            url: '../PromoController.do',
            data: {'action': 'addPromoCode', 'code': code, 'sdate': sdate, 'edate': edate, 'discount': discount},
            datatype: "json",
            restful: true,
            cache: false,
            timeout: 20000,
            async: true,
            success: function (data) {
                var jsonData = JSON.parse(data);
                if (jsonData.message === "success") {
                    $('input[type=text]').each(function () {
                        $(this).val('');
                    });
                    if (document.getElementById('successCoupan').style.display === 'none') {
                        document.getElementById('successCoupan').style.display = 'block';
                        document.getElementById("successCoupan").innerHTML = "Coupan is added successfully";
                    } else
                    {
                        document.getElementById("successCoupan").innerHTML = "Coupan is added successfully";
                    }
                    $("#successCoupan").fadeTo(2000, 1000).slideUp(1000, function () {
                        $("#successCoupan").slideUp(1000);
                    });
                } else {
                    if (document.getElementById('coupanError').style.display === 'none') {
                        document.getElementById('coupanError').style.display = 'block';
                        document.getElementById("coupanError").innerHTML = jsonData.message;
                    } else
                    {
                        document.getElementById("coupanError").innerHTML = jsonData.message;
                    }

                    $("#coupanError").fadeTo(2000, 1000).slideUp(1000, function () {
                        $("#coupanError").slideUp(1000);
                    });
                }
            },
            error: function () {
                if (document.getElementById('coupanError').style.display === 'none') {
                    $("#coupanError").css("display =block");
                    $("#coupanError").html("Something went wrong. Please try after some time!");
                } else
                {
                    $("#coupanError").html("Something went wrong. Please try after some time!");
                }
                $("#coupanError").fadeTo(2000, 1000).slideUp(1000, function () {
                    $("#coupanError").slideUp(1000);
                });
            }
        });
    });
    /*End of add new coupan*/
    
     /*Start of update new coupan*/
    $("#editCoupanBasic").click(function () {
        $('input[type="text"]').each(function () {
            $(this).css({
                "border": "",
                "background": ""
            });
        });
        var ecode = $("#ecode").val();
        if (typeof ecode === 'undefined' || !ecode)
        {
            $("#errorCoupanbus").css("display =block");
            $("#errorCoupanbus").html("Please enter the Coupan Code");
            $("#errorCoupanbus").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorCoupanbus").slideUp(1000);
            });
            $('#ecode').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else if ($('#ecode').val().length > 20)
        {
            $("#errorCoupanbus").css("display=block");
            $("#errorCoupanbus").html("Coupan Code can't be more than 20 characters");
            $("#errorCoupanbus").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorCoupanbus").slideUp(1000);
            });
            $('#ecode').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else
        {
            $('#ecode').css({"border": "", "background": ""});
        }
        var esdate = $("#esdate").val();
        if (typeof esdate === 'undefined' || !esdate)
        {
            $("#errorCoupanbus").css("display =block");
            $("#errorCoupanbus").html("Please enter the Start Date");
            $("#errorCoupanbus").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorCoupanbus").slideUp(1000);
            });
            $('#esdate').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else if ($('#esdate').val().length > 20)
        {
            $("#errorCoupanbus").css("display=block");
            $("#errorCoupanbus").html("Start Date can't be more than 20 characters");
            $("#errorCoupanbus").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorCoupanbus").slideUp(1000);
            });
            $('#esdate').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else
        {
            $('#esdate').css({"border": "", "background": ""});
        }
        var eedate = $("#eedate").val();
        if (typeof eedate === 'undefined' || !eedate)
        {
            $("#errorCoupanbus").css("display =block");
            $("#errorCoupanbus").html("Please enter the Expiry Date");
            $("#errorCoupanbus").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorCoupanbus").slideUp(1000);
            });
            $('#eedate').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else if ($('#eedate').val().length > 20)
        {
            $("#errorCoupanbus").css("display=block");
            $("#errorCoupanbus").html("Expiry Date can't be more than 20 characters");
            $("#errorCoupanbus").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorCoupanbus").slideUp(1000);
            });
            $('#eedate').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else
        {
            $('#eedate').css({"border": "", "background": ""});
        }
        var ediscount = $("#ediscount").val();
        if (typeof ediscount === 'undefined' || !ediscount)
        {
            $("#errorCoupanbus").css("display =block");
            $("#errorCoupanbus").html("Please enter the Discount");
            $("#errorCoupanbus").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorCoupanbus").slideUp(1000);
            });
            $('#ediscount').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else if ($('#ediscount').val().length > 20)
        {
            $("#errorCoupanbus").css("display=block");
            $("#errorCoupanbus").html("Discount can't be greater than 20 characters");
            $("#errorCoupanbus").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorCoupanbus").slideUp(1000);
            });
            $('#ediscount').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else
        {
            $('#ediscount').css({"border": "", "background": ""});
        }
        var coupanStatus = $("#coupanStatus").val();
        if (typeof coupanStatus === 'undefined' || !coupanStatus)
        {
            $("#errorCoupanbus").css("display =block");
            $("#errorCoupanbus").html("Please select the Status.");
            $("#errorCoupanbus").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorLead").slideUp(1000);
            });
            $('#coupanStatus').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else
        {
            $('#coupanStatus').css({"border": "", "background": ""});
        }
        var coupanId = $("#coupanId").val();
        $.ajax({
            type: "POST",
            url: '../PromoController.do',
            data: {'action': 'updatePromoCode', 'code': ecode, 'sdate': esdate, 'edate': eedate, 'discount': ediscount, 'coupanStatus': coupanStatus, 'coupanId': coupanId},
            datatype: "json",
            restful: true,
            cache: false,
            timeout: 20000,
            async: true,
            success: function (data) {
                var jsonData = JSON.parse(data);
                if (jsonData.message === "success") {
                    $('input[type=text]').each(function () {
                        $(this).val('');
                    });
                    $('#coupanStatus').val('');
                    if (document.getElementById('successBusiness').style.display === 'none') {
                        document.getElementById('successBusiness').style.display = 'block';
                        document.getElementById("successBusiness").innerHTML = "Coupan is updated successfully";
                    } else
                    {
                        document.getElementById("successBusiness").innerHTML = "Coupan is updated successfully";
                    }
                    $("#successBusiness").fadeTo(2000, 1000).slideUp(1000, function () {
                        $("#successBusiness").slideUp(1000);
                    });
                } else {
                    if (document.getElementById('errorCoupanbus').style.display === 'none') {
                        document.getElementById('errorCoupanbus').style.display = 'block';
                        document.getElementById("errorCoupanbus").innerHTML = jsonData.message;
                    } else
                    {
                        document.getElementById("errorCoupanbus").innerHTML = jsonData.message;
                    }

                    $("#errorCoupanbus").fadeTo(2000, 1000).slideUp(1000, function () {
                        $("#errorCoupanbus").slideUp(1000);
                    });
                }
            },
            error: function () {
                if (document.getElementById('errorCoupanbus').style.display === 'none') {
                    $("#errorCoupanbus").css("display =block");
                    $("#errorCoupanbus").html("Something went wrong. Please try after some time!");
                } else
                {
                    $("#errorCoupanbus").html("Something went wrong. Please try after some time!");
                }
                $("#errorCoupanbus").fadeTo(2000, 1000).slideUp(1000, function () {
                    $("#errorCoupanbus").slideUp(1000);
                });
            }
        });
    });
    /*End of update new coupan*/
    
     /*Start of admin signin area*/
    $("#adminSignIn").click(function () {
        $('input[type="text"]').each(function () {
            $(this).css({
                "border": "",
                "background": ""
            });
        });
        var aEmail = $("#aEmail").val();
        if (typeof aEmail === 'undefined' || !aEmail)
        {
            $("#adminError").css("display =block");
            $("#adminError").html("Please enter the Mail Id.");
            $("#adminError").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#adminError").slideUp(1000);
            });
            $('#aEmail').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else if (validateEmail(aEmail) === false) {
            $("#adminError").css("display =block");
            $("#adminError").html("Please enter the valid Mail Id eg. info@webhosting.com");
            $("#adminError").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#adminError").slideUp(1000);
            });
            $('#aEmail').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else
        {
            $('#aEmail').css({"border": "", "background": ""});
        }
        var aPassword = $("#aPassword").val();
        if (typeof aPassword === 'undefined' || !aPassword)
        {
            $("#adminError").css("display =block");
            $("#adminError").html("Please enter the Password.");
            $("#adminError").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#adminError").slideUp(1000);
            });
            $('#aPassword').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
            return false;
        } else
        {
            $('#aPassword').css({"border": "", "background": ""});
        }
        $.ajax({
            type: "POST",
            url: '../AdminController.do',
            data: {'action': 'aSignIn', 'aEmail': aEmail, 'aPassword': aPassword},
            datatype: "json",
            restful: true,
            cache: false,
            timeout: 20000,
            async: true,
            success: function (data) {
                if (data.message === "success") {
                    window.location.href = data.url;
                } else {
                    if (document.getElementById('adminError').style.display === 'none') {
                        document.getElementById('adminError').style.display = 'block';
                        document.getElementById("adminError").innerHTML = data.message;
                    } else
                    {
                        document.getElementById("adminError").innerHTML = data.message;
                    }
                    $("#adminError").fadeTo(2000, 1000).slideUp(1000, function () {
                        $("#adminError").slideUp(1000);
                    });
                }
            },
            error: function () {
                if (document.getElementById('adminError').style.display === 'none') {
                    $("#adminError").css("display =block");
                    $("#adminError").html("Something went wrong. Please try after some time!");
                } else
                {
                    $("#adminError").html("Something went wrong. Please try after some time!");
                }
                $("#adminError").fadeTo(2000, 1000).slideUp(1000, function () {
                    $("#adminError").slideUp(1000);
                });
            }
        });
    });
    /*End of admin signin area*/

    /*Start of admin forgot password*/
    $("#forgotLink").click(function () {
        $("#siginDiv").hide();
        $("#forgotDiv").show();
    });
    $("#adminSendOTP").click(function () {
        var forogotemail = $("#forogotemail").val();
        if (typeof forogotemail === 'undefined' || !forogotemail)
        {
            $("#errorForgotPassword").css("display=block");
            $("#errorForgotPassword").html("Please enter the Email address");
            $("#errorForgotPassword").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorForgotPassword").slideUp(1000);
            });
            $("#forogotemail").focus();
            return;
        } else if (validateEmail(forogotemail) === false) {
            $("#errorForgotPassword").css("display =block");
            $("#errorForgotPassword").html("Please enter the valid Mail Id eg. info@webhosting.com");
            $("#errorForgotPassword").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorForgotPassword").slideUp(1000);
            });
            $("#forogotemail").focus();
            return;
        }
        $.ajax({
            type: "post",
            url: "../AdminController.do",
            data: {'emailId': forogotemail},
            dataType: 'json',
            cache: false,
            success: function (data) {
                if (data.message === "success")
                {
                    $("#forgotPasswordOTP").show();
                    $("#forgotDiv").hide();
                    $("#siginDiv").hide();
                } else {
                    if (document.getElementById('errorForgotPassword').style.display === 'none') {
                        document.getElementById('errorForgotPassword').style.display = 'block';
                        document.getElementById("errorForgotPassword").innerHTML = data.message;
                    } else
                    {
                        document.getElementById("errorForgotPassword").innerHTML = data.message;
                    }
                }
            },
            error: function () {
                if (document.getElementById('errorForgotPassword').style.display === 'none') {
                    $("#errorForgotPassword").css("display =block");
                    $("#errorForgotPassword").html("Something went wrong. Please try after some time!");
                } else
                {
                    $("#errorForgotPassword").html("Something went wrong. Please try after some time!");
                }
            }
        });
    });
    $("#otpSubmit").click(function () {
        var emailId = $("#emailId").val();
        if (typeof emailId === 'undefined' || !emailId)
        {
            $("#errorBus").css("display=block");
            $("#errorBus").html("Please enter the emailid");
            $("#errorBus").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorBus").slideUp(1000);
            });
            $("#emailId").focus();
            return;
        } else if (validateEmail(emailId) === false) {
            $("#errorBus").css("display =block");
            $("#errorBus").html("Please enter the valid Mail Id eg. info@webhosting.com");
            $("#errorBus").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorBus").slideUp(1000);
            });
            $("#emailId").focus();
            return;
        }
        var otp = $("#otp").val();
        if (typeof otp === 'undefined' || !otp)
        {
            $("#errorBus").css("display=block");
            $("#errorBus").html("Please enter the OTP");
            $("#errorBus").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorBus").slideUp(1000);
            });
            $("#otp").focus();
            return;
        }
        var newpassword = $("#newpassword").val();
        if (typeof newpassword === 'undefined' || !newpassword)
        {
            $("#errorBus").css("display=block");
            $("#errorBus").html("Please enter the New Password");
            $("#errorBus").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorBus").slideUp(1000);
            });
            $("#newpassword").focus();
            return;
        } else if (newpassword.length < 6)
        {
            $("#errorBus").css("display =block");
            $("#errorBus").html("Please enter the Password at least 6 digits");
            $("#errorBus").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorBus").slideUp(0);
            });
            $("#cnewpassword").focus();
            return;
        } else if (newpassword.length > 10)
        {
            $("#errorBus").css("display =block");
            $("#errorBus").html("Please enter the Password less than 10 digits");
            $("#errorBus").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorBus").slideUp(0);
            });
            $("#cnewpassword").focus();
            return;
        }
        var confirmnewpassword = $("#confirmnewpassword").val();
        if (typeof confirmnewpassword === 'undefined' || !confirmnewpassword)
        {
            $("#errorBus").css("display=block");
            $("#errorBus").html("please enter the Confirm Password");
            $("#errorBus").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorBus").slideUp(1000);
            });
            $("#confirmnewpassword").focus();
            return;
        }
        $.ajax({
            type: "post",
            url: "../AdminController.do",
            data: {'emailId': emailId, 'otp': otp, 'newpassword': newpassword, 'confirmnewpassword': confirmnewpassword},
            dataType: 'json',
            cache: false,
            success: function (data) {
                if (data.message === "success")
                {
                    window.location.href = data.url;
                } else {
                    if (document.getElementById('errorBus').style.display === 'none') {
                        document.getElementById('errorBus').style.display = 'block';
                        document.getElementById("errorBus").innerHTML = data.message;
                    } else
                    {
                        document.getElementById("errorBus").innerHTML = data.message;
                    }
                }
            },
            error: function () {
                if (document.getElementById('errorBus').style.display === 'none') {
                    $("#errorBus").css("display =block");
                    $("#errorBus").html("Something went wrong. Please try after some time!");
                } else
                {
                    $("#errorBus").html("Something went wrong. Please try after some time!");
                }
            }
        });
    });
    $("#resendOTP").click(function () {
        $.ajax({
            type: 'post',
            url: '../AdminController.do',
            data: {'action': 'ResendOtp'},
            dataType: "json",
            restful: true,
            cache: false,
            timeout: 20000,
            async: true,
            success: function (data) {
                if (data.message === "success") {
                    if (document.getElementById('successBusiness').style.display === 'none') {
                        document.getElementById('successBusiness').style.display = 'block';
                        document.getElementById("successBusiness").innerHTML = data.message;
                    } else
                    {
                        document.getElementById("successBusiness").innerHTML = data.message;
                    }
                    $("#successBusiness").fadeTo(2000, 1000).slideUp(1000, function () {
                        $("#successBusiness").slideUp(1000);
                    });
                } else {
                    if (document.getElementById('errorBusiness').style.display === 'none') {
                        document.getElementById('errorBusiness').style.display = 'block';
                        document.getElementById("errorBusiness").innerHTML = data.message;
                    } else
                    {
                        document.getElementById("errorBusiness").innerHTML = data.message;
                    }
                    $("#errorBusiness").fadeTo(2000, 1000).slideUp(1000, function () {
                        $("#errorBusiness").slideUp(1000);
                    });
                }
            },
            error: function () {
                if (document.getElementById('errorBusiness').style.display === 'none') {
                    $("#errorBusiness").css("display =block");
                    $("#errorBusiness").html("Something went wrong. Please try after some time!");
                } else
                {
                    $("#errorBusiness").html("Something went wrong. Please try after some time!");
                }
                $("#errorBusiness").fadeTo(2000, 1000).slideUp(1000, function () {
                    $("#errorBusiness").slideUp(1000);
                });
            }
        });
    });
    /*End of forgot password admin*/


    
    /*Start of edit coupan */
    function coupanProfileEdit(item)
{
    $("#getAllCoupan").hide();
    $("#viewCoupan").hide();
    $("#editCoupan").show();
    $("#ecode").val(item.CoupanCode);
    $("#esdate").val(item.StartDate);
    $("#eedate").val(item.EndDate);
    $("#ediscount").val(item.Discount);
    $("#coupanStatus").val(item.Status);
    $("#coupanId").val(item.coupanId);
}
/* End of coupan edit profile */

/* Start of coupan view  */
function coupanProfileView(item)
{
    $("#editCoupan").hide();
    $("#getAllCoupan").hide();
    $("#viewCoupan").show();
    $("#coupanProfileView").append('<li><span class="outDetails">Coupan Id </span>' + item.coupanId + '</li><li><span class="outDetails">Coupan Code</span>' + item.CoupanCode + '</li><li><span class="outDetails">Start date</span>' + item.StartDate + '</li><li><span class="outDetails">Expiry Date</span>' + item.EndDate + '</li><li><span class="outDetails">Discount</span>' + item.Discount + '</li><li><span class="outDetails">Creator Id</span>' + item.CreatorId + '</li><li><span class="outDetails">Creation Date</span>' + item.Date + '</li><li><span class="outDetails">Status</span>' + item.Status + '</li>');
    $("#coupanEditInfo").click(function () {
        coupanProfileEdit(item);
    });
}
/* End of coupan view  */

/*Start of coupan  block*/
function coupanProfileBlock(dataItem)
{
    var actionCoupan;
    if (dataItem.Status === 'Block')
    {
        if (!confirm("Do you want to Active Coupan")) {
            return false;
        }
        actionCoupan = 'activeCoupan';
    }
    if (dataItem.Status === 'Active')
    {
        if (!confirm("Do you want to Block Coupan")) {
            return false;
        }
        actionCoupan = 'blockCoupan';
    }
    $.ajax({
        type: 'post',
        url: '../PromoController.do',
        data: {'action': actionCoupan, 'id': dataItem.coupanId},
        dataType: "json",
        restful: true,
        cache: false,
        timeout: 20000,
        async: true,
        success: function (data) {
            if (data.message === "success") {
                location.reload();
            } else {
            }
        },
        error: function () {
        }
    });

}
/*End of coupan  block*/
