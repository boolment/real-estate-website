
$(document).ready(function () {
    $('[data-toggle="offcanvas"]').click(function () {
        $('#side-menu').toggleClass('hidden-xs');
    });


//    $.ajax({
//        type: 'post',
//        url: "../PromoController.do",
//        data: {'action': 'isValidPromoCode'},
//        dataType: "json",
//        restful: true,
//        cache: false,
//        timeout: 20000,
//        async: true,
//        success: function (data) {
//
//        },
//        error: function () {
//
//        }
//    });


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

    /*Start of owner view */
    ownerTableData();
    function ownerTableData()
    {
        $.ajax({
            type: 'post',
            url: '../OwnerController.do',
            data: {'action': 'getAllOwner'},
            dataType: "json",
            restful: true,
            cache: false,
            timeout: 20000,
            async: true,
            success: function (data) {
                var actionLinks;
                if (data.message === "success") {
                    $('#ownerDisplay').DataTable().clear().draw();
                    jQuery(data.owner).each(function (i, item) {
                        var id = item.server_id;
                        var dataItem = JSON.stringify(item);
                        if (item.Status === "Active")
                        {
                            actionLinks = "<div class='btn-group'><button class='btn btn-primary btn-xs dropdown-toggle' data-placement='left' type='button' data-toggle='dropdown' aria-expanded='false'>Action <i class='fa fa-angle-down'></i></button><ul class='dropdown-menu' style='left:-100px' role='menu'><li><a href='#' onclick='ownerProfileView(" + dataItem + ");'>View Owner</a></li><li><a href='#' onclick='ownerProfileEdit(" + dataItem + ");'>Edit Owner</a></li><li><a href='#' onclick='ownerProfileBlock(" + dataItem + ");'>Block Owner</a></li></ul></div>";
                        } else
                            actionLinks = "<div class='btn-group'><button class='btn btn-primary btn-xs dropdown-toggle' data-placement='left' type='button' data-toggle='dropdown' aria-expanded='false'>Action <i class='fa fa-angle-down'></i></button><ul class='dropdown-menu' style='left:-100px' role='menu'><li><a href='#' onclick='ownerProfileView(" + dataItem + ");'>View Owner</a></li><li><a href='#' onclick='ownerProfileEdit(" + dataItem + ");'>Edit Owner</a></li><li><a href='#' onclick='ownerProfileBlock(" + dataItem + ");'>Active Owner</a></li></ul></div>";
                        $('#ownerDisplay').DataTable().row.add([
                            item.Firstname,
                            item.Lastname,
                            item.PhnNo,
                            item.Email,
                            item.Address,
                            item.Date,
                            item.Status,
                            actionLinks
                        ]).draw(false);
                    });
                } else {
//                    if (document.getElementById('errorOwner').style.display === 'none') {
//                        document.getElementById('errorOwner').style.display = 'block';
//                        document.getElementById("errorOwner").innerHTML = data.message;
//                    } else
//                    {
//                        document.getElementById("errorOwner").innerHTML = data.message;
//                    }
                }
            },
            error: function () {
                if (document.getElementById('errorOwner').style.display === 'none') {
                    $("#errorOwner").css("display =block");
                    $("#errorOwner").html("Something went wrong. Please try after some time!");
                } else
                {
                    $("#errorOwner").html("Something went wrong. Please try after some time!");
                }
            }
        });
    }
    /*End  of owner view */

    /*Start of view all customer */
    customerTableData();
    function customerTableData()
    {
        $.ajax({
            type: 'post',
            url: '../CustomerController.do',
            data: {'action': 'getAllCustomer'},
            dataType: "json",
            restful: true,
            cache: false,
            timeout: 20000,
            async: true,
            success: function (data) {
                var actionLinks;
                if (data.message === "success") {
                    $('#Cdisplay').DataTable().clear().draw();
                    jQuery(data.customers).each(function (i, item) {

                        var id = item.customerUniqueid;
                        var dataItem = JSON.stringify(item);
                        if (item.Status === "Active")
                        {
                            actionLinks = "<div class='btn-group'><button class='btn btn-primary btn-xs dropdown-toggle' data-placement='left' type='button' data-toggle='dropdown' aria-expanded='false'>Action <i class='fa fa-angle-down'></i></button><ul class='dropdown-menu' style='left:-100px' role='menu'><li><a href='#' onclick='custProfileView(" + dataItem + ");'>View Customer</a></li><li><a href='#' onclick='custProfileEdit(" + dataItem + ");'>Edit Customer</a></li><li><a href='#' onclick='customerProfileBlock(" + dataItem + ");'>Block Customer</a></li></ul></div>";
                        } else
                            actionLinks = "<div class='btn-group'><button class='btn btn-primary btn-xs dropdown-toggle' data-placement='left' type='button' data-toggle='dropdown' aria-expanded='false'>Action <i class='fa fa-angle-down'></i></button><ul class='dropdown-menu' style='left:-100px' role='menu'><li><a href='#' onclick='custProfileView(" + dataItem + ");'>View Customer</a></li><li><a href='#' onclick='custProfileEdit(" + dataItem + ");'>Edit Customer</a></li><li><a href='#' onclick='customerProfileBlock(" + dataItem + ");'>Active Customer</a></li></ul></div>";
                        $('#Cdisplay').DataTable().row.add([
                            item.customerFirstName,
                            item.customerLastName,
                            item.customerMobileNo,
                            item.customermailId,
                            item.Address,
                            item.Date,
                            item.Status,
                            actionLinks
                        ]).draw(false);
                    });
                } else {
                    if (document.getElementById('ErrorsCustomers').style.display === 'none') {
                        document.getElementById('ErrorsCustomers').style.display = 'block';
                        document.getElementById("ErrorsCustomers").innerHTML = data.message;
                    } else
                    {
                        document.getElementById("ErrorsCustomers").innerHTML = data.message;
                    }
                }
            },
            error: function () {
                if (document.getElementById('ErrorsCustomers').style.display === 'none') {
                    $("#ErrorsCustomers").css("display =block");
                    $("#ErrorsCustomers").html("Something went wrong. Please try after some time!");
                } else
                {
                    $("#ErrorsCustomers").html("Something went wrong. Please try after some time!");
                }
            }
        });
    }

    /*End of view all customer*/



});

/*===============================viewAllCustomer.jsp ======================*/
$(document).ready(function () {
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

/*Start of update new owner*/
$("#editOwnerBasic").click(function () {
    $('input[type="text"]').each(function () {
        $(this).css({
            "border": "",
            "background": ""
        });
    });
    var fname = $("#fname").val();
    if (typeof fname === 'undefined' || !fname)
    {
        $("#errorOwner").css("display =block");
        $("#errorOwner").html("Please enter the First Name");
        $("#errorOwner").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorOwner").slideUp(1000);
        });
        $('#fname').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else if ($('#fname').val().length > 20)
    {
        $("#errorOwner").css("display=block");
        $("#errorOwner").html("First name can't be more than 20 characters");
        $("#errorOwner").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorOwner").slideUp(1000);
        });
        $('#fname').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else
    {
        $('#fname').css({"border": "", "background": ""});
    }
    var lname = $("#lname").val();
    if (typeof lname === 'undefined' || !lname)
    {
        $("#errorOwner").css("display =block");
        $("#errorOwner").html("Please enter the Last Name");
        $("#errorOwner").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorOwner").slideUp(1000);
        });
        $('#lname').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else if ($('#lname').val().length > 20)
    {
        $("#errorOwner").css("display=block");
        $("#errorOwner").html("Last Name can't be more than 20 characters");
        $("#errorOwner").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorOwner").slideUp(1000);
        });
        $('#lname').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else
    {
        $('#lname').css({"border": "", "background": ""});
    }
    var mobno = $("#mobno").val();
    if (typeof mobno === 'undefined' || !mobno)
    {
        $("#errorOwner").css("display =block");
        $("#errorOwner").html("Please enter the Mobile Number");
        $("#errorOwner").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorOwner").slideUp(1000);
        });
        $('#mobno').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else if ($('#mobno').val().length > 12)
    {
        $("#errorOwner").css("display=block");
        $("#errorOwner").html("Mobile Number can't be more than 12 characters");
        $("#errorOwner").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorOwner").slideUp(1000);
        });
        $('#mobno').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else
    {
        $('#mobno').css({"border": "", "background": ""});
    }
    var emailId = $("#emailId").val();
    if (typeof emailId === 'undefined' || !emailId)
    {
        $("#errorOwner").css("display =block");
        $("#errorOwner").html("Please enter the Mail Id.");
        $("#errorOwner").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorOwner").slideUp(1000);
        });
        $('#emailId').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else if (validateEmail(emailId) === false) {
        $("#errorOwner").css("display =block");
        $("#errorOwner").html("Please enter the valid Mail Id eg. info@webhosting.com");
        $("#errorOwner").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorOwner").slideUp(1000);
        });
        $('#emailId').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else
    {
        $('#emailId').css({"border": "", "background": ""});
    }
    var dob = $("#dob").val();
    if (typeof dob === 'undefined' || !dob)
    {
        $("#errorOwner").css("display =block");
        $("#errorOwner").html("Please enter the Date of birth");
        $("#errorOwner").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorOwner").slideUp(1000);
        });
        $('#dob').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else if ($('#dob').val().length > 20)
    {
        $("#errorOwner").css("display=block");
        $("#errorOwner").html("Date of Birth can't be greater than 20 characters");
        $("#errorOwner").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorOwner").slideUp(1000);
        });
        $('#dob').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else
    {
        $('#dob').css({"border": "", "background": ""});
    }
    var address = $("#address").val();
    if (typeof address === 'undefined' || !address)
    {
        $("#errorOwner").css("display =block");
        $("#errorOwner").html("Please enter the Address.");
        $("#errorOwner").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorOwner").slideUp(1000);
        });
        $('#address').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else
    {
        $('#address').css({"border": "", "background": ""});
    }
    var ostatus = $("#ostatus").val();
    if (typeof ostatus === 'undefined' || !ostatus)
    {
        $("#errorOwner").css("display =block");
        $("#errorOwner").html("Please select the Status.");
        $("#errorOwner").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorOwner").slideUp(1000);
        });
        $('#ostatus').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else
    {
        $('#ostatus').css({"border": "", "background": ""});
    }
    var ownerId = $("#ownerId").val();
    $.ajax({
        type: "POST",
        url: '../OwnerController.do',
        data: {'action': 'updateOwner', 'fname': fname, 'lname': lname, 'mobno': mobno, 'emailId': emailId, 'dob': dob, 'address': address, 'ostatus': ostatus, 'ownerId': ownerId},
        datatype: "json",
        restful: true,
        cache: false,
        timeout: 20000,
        async: true,
        success: function (data) {
            var jsonData = JSON.parse(data);
            if (jsonData.message === "success") {
                alert("successfully");
                $('input[type=text]').each(function () {
                    $(this).val('');
                });

                if (document.getElementById('successBusiness').style.display === 'none') {
                    document.getElementById('successBusiness').style.display = 'block';
                    document.getElementById("successBusiness").innerHTML = "Owner is updated successfully";
                } else
                {
                    document.getElementById("successBusiness").innerHTML = "Owner is updated successfully";
                }
                $("#successBusiness").fadeTo(2000, 1000).slideUp(1000, function () {
                    $("#successBusiness").slideUp(1000);
                });
            } else {
                if (document.getElementById('errorOwner').style.display === 'none') {
                    document.getElementById('errorOwner').style.display = 'block';
                    document.getElementById("errorOwner").innerHTML = jsonData.message;
                } else
                {
                    document.getElementById("errorOwner").innerHTML = jsonData.message;
                }
                $("#errorOwner").fadeTo(2000, 1000).slideUp(1000, function () {
                    $("#errorOwner").slideUp(1000);
                });
            }
        },
        error: function () {
            if (document.getElementById('errorOwner').style.display === 'none') {
                $("#errorOwner").css("display =block");
                $("#errorOwner").html("Something went wrong. Please try after some time!");
            } else
            {
                $("#errorOwner").html("Something went wrong. Please try after some time!");
            }
            $("#errorOwner").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorOwner").slideUp(1000);
            });
        }
    });
});
/*End of update new owner*/

/*Start of update new customer*/
$("#editCustomerBasic").click(function () {
    alert("called");
    $('input[type="text"]').each(function () {
        $(this).css({
            "border": "",
            "background": ""
        });
    });
    var cfirstname = $("#cfirstname").val();
    if (typeof cfirstname === 'undefined' || !cfirstname)
    {
        $("#errorCustomer").css("display =block");
        $("#errorCustomer").html("Please enter the First Name");
        $("#errorCustomer").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorCustomer").slideUp(1000);
        });
        $('#cfirstname').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else if ($('#cfirstname').val().length > 20)
    {
        $("#errorCustomer").css("display=block");
        $("#errorCustomer").html("First name can't be more than 20 characters");
        $("#errorCustomer").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorCustomer").slideUp(1000);
        });
        $('#cfirstname').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else
    {
        $('#cfirstname').css({"border": "", "background": ""});
    }
    alert(cfirstname);
    var clastname = $("#clastname").val();
    if (typeof clastname === 'undefined' || !clastname)
    {
        $("#errorCustomer").css("display =block");
        $("#errorCustomer").html("Please enter the Last Name");
        $("#errorCustomer").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorCustomer").slideUp(1000);
        });
        $('#clastname').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else if ($('#clastname').val().length > 20)
    {
        $("#errorCustomer").css("display=block");
        $("#errorCustomer").html("Last Name can't be more than 20 characters");
        $("#errorCustomer").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorCustomer").slideUp(1000);
        });
        $('#clastname').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else
    {
        $('#clastname').css({"border": "", "background": ""});
    }
    var cmobilenumber = $("#cmobilenumber").val();
    if (typeof cmobilenumber === 'undefined' || !cmobilenumber)
    {
        $("#errorCustomer").css("display =block");
        $("#errorCustomer").html("Please enter the Mobile Number");
        $("#errorCustomer").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorCustomer").slideUp(1000);
        });
        $('#cmobilenumber').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else if ($('#cmobilenumber').val().length > 12)
    {
        $("#errorCustomer").css("display=block");
        $("#errorCustomer").html("Mobile Number can't be more than 12 characters");
        $("#errorCustomer").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorCustomer").slideUp(1000);
        });
        $('#cmobilenumber').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else
    {
        $('#cmobilenumber').css({"border": "", "background": ""});
    }
    var cmailid = $("#cmailid").val();
    if (typeof cmailid === 'undefined' || !cmailid)
    {
        $("#errorCustomer").css("display =block");
        $("#errorCustomer").html("Please enter the Mail Id.");
        $("#errorCustomer").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorCustomer").slideUp(1000);
        });
        $('#cmailid').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else if (validateEmail(cmailid) === false) {
        $("#errorCustomer").css("display =block");
        $("#errorCustomer").html("Please enter the valid Mail Id eg. info@webhosting.com");
        $("#errorCustomer").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorCustomer").slideUp(1000);
        });
        $('#cmailid').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else
    {
        $('#cmailid').css({"border": "", "background": ""});
    }
    var caddress1 = $("#caddress1").val();
    if (typeof caddress1 === 'undefined' || !caddress1)
    {
        $("#errorCustomer").css("display =block");
        $("#errorCustomer").html("Please enter the Address.");
        $("#errorCustomer").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorCustomer").slideUp(1000);
        });
        $('#caddress1').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else
    {
        $('#caddress1').css({"border": "", "background": ""});
    }
    var custStatus = $("#custStatus").val();
    if (typeof custStatus === 'undefined' || !custStatus)
    {
        $("#errorCustomer").css("display =block");
        $("#errorCustomer").html("Please select the Status.");
        $("#errorCustomer").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorCustomer").slideUp(1000);
        });
        $('#custStatus').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else
    {
        $('#custStatus').css({"border": "", "background": ""});
    }
    var customerUniqueid = $("#customerUniqueid").val();
    $.ajax({
        type: "POST",
        url: '../CustomerController.do',
        data: {'action': 'updateCustomer', 'fname': cfirstname, 'lname': clastname, 'mobno': cmobilenumber, 'emailId': cmailid, 'address': caddress1, 'ostatus': custStatus, 'customerUniqueid': customerUniqueid},
        datatype: "json",
        restful: true,
        cache: false,
        timeout: 20000,
        async: true,
        success: function (data) {
            var jsonData = JSON.parse(data);
            if (jsonData.message === "success") {
                alert("successfully");
                $('input[type=text]').each(function () {
                    $(this).val('');
                });
                $(cmobilenumber).val('');
                $(custStatus).val('');
                if (document.getElementById('successBusiness').style.display === 'none') {
                    document.getElementById('successBusiness').style.display = 'block';
                    document.getElementById("successBusiness").innerHTML = "Owner is updated successfully";
                } else
                {
                    document.getElementById("successBusiness").innerHTML = "Owner is updated successfully";
                }
                $("#successBusiness").fadeTo(2000, 1000).slideUp(1000, function () {
                    $("#successBusiness").slideUp(1000);
                });
            } else {
                if (document.getElementById('errorCustomer').style.display === 'none') {
                    document.getElementById('errorCustomer').style.display = 'block';
                    document.getElementById("errorCustomer").innerHTML = jsonData.message;
                } else
                {
                    document.getElementById("errorCustomer").innerHTML = jsonData.message;
                }
                $("#errorCustomer").fadeTo(2000, 1000).slideUp(1000, function () {
                    $("#errorCustomer").slideUp(1000);
                });
            }
        },
        error: function () {
            if (document.getElementById('errorCustomer').style.display === 'none') {
                $("#errorCustomer").css("display =block");
                $("#errorCustomer").html("Something went wrong. Please try after some time!");
            } else
            {
                $("#errorCustomer").html("Something went wrong. Please try after some time!");
            }
            $("#errorCustomer").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#errorCustomer").slideUp(1000);
            });
        }
    });
});
/*End of update new customer*/

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
    $("#emailId").val(forogotemail);
    $.ajax({
        type: "post",
        url: "../AdminController.do",
        data: {'action': 'ForgotPassword', 'emailId': forogotemail},
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
    var emailId = $("#forogotemail").val();
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
        data: {'action': 'OtpSubmit', 'emailId': emailId, 'otp': otp, 'newpassword': newpassword, 'confirmnewpassword': confirmnewpassword},
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
    alert("Email Ids:" + $("#emailId").val());
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
    $.ajax({
        type: 'post',
        url: '../AdminController.do',
        data: {'action': 'ForgotPassword', 'emailId': emailId},
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

/*Start of owner signin area*/
$("#ownerSignIn").click(function () {
    $('input[type="text"]').each(function () {
        $(this).css({
            "border": "",
            "background": ""
        });
    });
    var oEmail = $("#oEmail").val();
    if (typeof oEmail === 'undefined' || !oEmail)
    {
        $("#ownerError").css("display =block");
        $("#ownerError").html("Please enter the Mail Id.");
        $("#ownerError").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#ownerError").slideUp(1000);
        });
        $('#oEmail').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else if (validateEmail(oEmail) === false) {
        $("#ownerError").css("display =block");
        $("#ownerError").html("Please enter the valid Mail Id eg. info@webhosting.com");
        $("#ownerError").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#ownerError").slideUp(1000);
        });
        $('#oEmail').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else
    {
        $('#oEmail').css({"border": "", "background": ""});
    }
    var oPassword = $("#oPassword").val();
    if (typeof oPassword === 'undefined' || !oPassword)
    {
        $("#ownerError").css("display =block");
        $("#ownerError").html("Please enter the Password.");
        $("#ownerError").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#ownerError").slideUp(1000);
        });
        $('#oPassword').css({"border": "1px solid red", "background": "#FFCECE"}).focus();
        return false;
    } else
    {
        $('#oPassword').css({"border": "", "background": ""});
    }
    $.ajax({
        type: "POST",
        url: '../OwnerController.do',
        data: {'action': 'aSignIn', 'oEmail': oEmail, 'oPassword': oPassword},
        datatype: "json",
        restful: true,
        cache: false,
        timeout: 20000,
        async: true,
        success: function (data) {
            if (data.message === "success") {
                window.location.href = data.url;
            } else {
                if (document.getElementById('ownerError').style.display === 'none') {
                    document.getElementById('ownerError').style.display = 'block';
                    document.getElementById("ownerError").innerHTML = data.message;
                } else
                {
                    document.getElementById("ownerError").innerHTML = data.message;
                }
                $("#ownerError").fadeTo(2000, 1000).slideUp(1000, function () {
                    $("#ownerError").slideUp(1000);
                });
            }
        },
        error: function () {
            if (document.getElementById('ownerError').style.display === 'none') {
                $("#ownerError").css("display =block");
                $("#ownerError").html("Something went wrong. Please try after some time!");
            } else
            {
                $("#ownerError").html("Something went wrong. Please try after some time!");
            }
            $("#ownerError").fadeTo(2000, 1000).slideUp(1000, function () {
                $("#ownerError").slideUp(1000);
            });
        }
    });
});
/*End of owner signin area*/

/*Start of owner forgot password*/
$("#oforgotLink").click(function () {
    alert("called");
    $("#osiginDiv").hide();
    $("#oforgotDiv").show();
});
$("#ownerSendOTP").click(function () {
    var oforogotemail = $("#oforogotemail").val();
    if (typeof oforogotemail === 'undefined' || !oforogotemail)
    {
        $("#errorForgotPassword").css("display=block");
        $("#errorForgotPassword").html("Please enter the Email address");
        $("#errorForgotPassword").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorForgotPassword").slideUp(1000);
        });
        $("#oforogotemail").focus();
        return;
    } else if (validateEmail(oforogotemail) === false) {
        $("#errorForgotPassword").css("display =block");
        $("#errorForgotPassword").html("Please enter the valid Mail Id eg. info@webhosting.com");
        $("#errorForgotPassword").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorForgotPassword").slideUp(1000);
        });
        $("#oforogotemail").focus();
        return;
    }
    $("#oemailId").val(oforogotemail);
    $.ajax({
        type: "post",
        url: "../OwnerController.do",
        data: {'action': 'ForgotPassword', 'emailId': oforogotemail},
        dataType: 'json',
        cache: false,
        success: function (data) {
            if (data.message === "success")
            {
                $("#oforgotPasswordOTP").show();
                $("#oforgotDiv").hide();
                $("#osiginDiv").hide();
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
$("#ootpSubmit").click(function () {
    var oemailId = $("#oemailId").val();
    if (typeof oemailId === 'undefined' || !oemailId)
    {
        $("#errorBus").css("display=block");
        $("#errorBus").html("Please enter the emailid");
        $("#errorBus").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorBus").slideUp(1000);
        });
        $("#emailId").focus();
        return;
    } else if (validateEmail(oemailId) === false) {
        $("#errorBus").css("display =block");
        $("#errorBus").html("Please enter the valid Mail Id eg. info@webhosting.com");
        $("#errorBus").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorBus").slideUp(1000);
        });
        $("#oemailId").focus();
        return;
    }
    var ootp = $("#ootp").val();
    if (typeof ootp === 'undefined' || !ootp)
    {
        $("#errorBus").css("display=block");
        $("#errorBus").html("Please enter the OTP");
        $("#errorBus").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorBus").slideUp(1000);
        });
        $("#ootp").focus();
        return;
    }
    var onewpassword = $("#onewpassword").val();
    if (typeof onewpassword === 'undefined' || !onewpassword)
    {
        $("#errorBus").css("display=block");
        $("#errorBus").html("Please enter the New Password");
        $("#errorBus").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorBus").slideUp(1000);
        });
        $("#onewpassword").focus();
        return;
    } else if (onewpassword.length < 6)
    {
        $("#errorBus").css("display =block");
        $("#errorBus").html("Please enter the Password at least 6 digits");
        $("#errorBus").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorBus").slideUp(0);
        });
        $("#onewpassword").focus();
        return;
    } else if (onewpassword.length > 10)
    {
        $("#errorBus").css("display =block");
        $("#errorBus").html("Please enter the Password less than 10 digits");
        $("#errorBus").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorBus").slideUp(0);
        });
        $("#onewpassword").focus();
        return;
    }
    var oconfirmnewpassword = $("#oconfirmnewpassword").val();
    if (typeof oconfirmnewpassword === 'undefined' || !oconfirmnewpassword)
    {
        $("#errorBus").css("display=block");
        $("#errorBus").html("please enter the Confirm Password");
        $("#errorBus").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorBus").slideUp(1000);
        });
        $("#oconfirmnewpassword").focus();
        return;
    }
    $.ajax({
        type: "post",
        url: "../OwnerController.do",
        data: {'action': 'OtpSubmit', 'emailId': oemailId, 'otp': ootp, 'newpassword': onewpassword, 'confirmnewpassword': oconfirmnewpassword},
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
$("#oresendOTP").click(function () {
    alert("Email Ids:" + $("#emailId").val());
    var oemailId = $("#oemailId").val();
    if (typeof oemailId === 'undefined' || !oemailId)
    {
        $("#errorBus").css("display=block");
        $("#errorBus").html("Please enter the emailid");
        $("#errorBus").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorBus").slideUp(1000);
        });
        $("#oemailId").focus();
        return;
    } else if (validateEmail(oemailId) === false) {
        $("#errorBus").css("display =block");
        $("#errorBus").html("Please enter the valid Mail Id eg. info@webhosting.com");
        $("#errorBus").fadeTo(2000, 1000).slideUp(1000, function () {
            $("#errorBus").slideUp(1000);
        });
        $("#oemailId").focus();
        return;
    }
    $.ajax({
        type: 'post',
        url: '../OwnerController.do',
        data: {'action': 'ForgotPassword', 'emailId': oemailId},
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
/*End of forgot password owner*/

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
    var actionCustomer;
    if (dataItem.Status === 'Block')
    {
        if (!confirm("Do you want to Active Customer")) {
            return false;
        }
        actionCustomer = 'activeCustomer';
    }
    if (dataItem.Status === 'Active')
    {
        if (!confirm("Do you want to Block Customer")) {
            return false;
        }
        actionCustomer = 'blockCustomer';
    }
    $.ajax({
        type: 'post',
        url: '../CustomerController.do',
        data: {'action': actionCustomer, 'id': dataItem.Id},
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


/*Start of owner coupan */
function ownerProfileEdit(item)
{
    $("#getAllOwner").hide();
    $("#viewOwner").hide();
    $("#editOwner").show();
    $("#fname").val(item.Firstname);
    $("#lname").val(item.Lastname);
    $("#mobno").val(item.PhnNo);
    $("#emailId").val(item.Email);
    $("#dob").val(item.DOB);
    $("#address").val(item.Address);
    $("#ostatus").val(item.Status);
    $("#ownerId").val(item.ownerId);
}
/* End of owner edit profile */

/* Start of owner view  */
function ownerProfileView(item)
{
    $("#editOwner").hide();
    $("#getAllOwner").hide();
    $("#viewOwner").show();
    $("#ownerProfileView").append('<li><span class="outDetails">Owner Id </span>' + item.ownerId + '</li><li><span class="outDetails">First Name</span>' + item.Firstname + '</li><li><span class="outDetails">Last Name</span>' + item.Lastname + '</li><li><span class="outDetails">Unique Id</span>' + item.UnqId + '</li><li><span class="outDetails">Mobile No</span>' + item.PhnNo + '</li><li><span class="outDetails">Address</span>' + item.Address + '</li><li><span class="outDetails">Email Id</span>' + item.Email + '</li><li><span class="outDetails">Gender</span>' + item.Gender + '</li><li><span class="outDetails">DOB</span>' + item.DOB + '</li><li><span class="outDetails">Date</span>' + item.Date + '</li><li><span class="outDetails">Status</span>' + item.Status + '</li>');
    $("#ownerEditInfo").click(function () {
        ownerProfileEdit(item);
    });
}
/* End of owner view  */

/*Start of owner  block*/
function ownerProfileBlock(dataItem)
{
    var actionOwner;
    if (dataItem.Status === 'Block')
    {
        if (!confirm("Do you want to Active owner")) {
            return false;
        }
        actionOwner = 'activeOwner';
    }
    if (dataItem.Status === 'Active')
    {
        if (!confirm("Do you want to Block owner")) {
            return false;
        }
        actionOwner = 'blockOwner';
    }
    $.ajax({
        type: 'post',
        url: '../OwnerController.do',
        data: {'action': actionOwner, 'id': dataItem.UnqId},
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
/*End of owner  block*/

/* Start of customer edit profile */
function custProfileEdit(item)
{
    $("#viewAllCustomer").hide();
    $("#viewCustomer").hide();
    $("#editCustomers").show();
    $("#cfirstname").val(item.customerFirstName);
    $("#clastname").val(item.customerLastName);
    $("#cmobilenumber").val(item.customerMobileNo);
    $("#cmailid").val(item.customermailId);
    $("#caddress1").val(item.Address);
    $("#custStatus").val(item.Status);
    $("#customerUniqueid").val(item.Id);
}
/* End of customer edit profile */

/* Start of customer view profile */
function custProfileView(item)
{
    $("#editCustomers").hide();
    $("#viewAllCustomer").hide();
    $("#viewCustomer").show();
    $("#customerProfileView").append('<li><span class="outDetails">Id</span>' + item.Id + '</li><li><span class="outDetails">F Name</span>' + item.customerFirstName + '</li><li><span class="outDetails">L Name</span>' + item.customerLastName + '</li><li><span class="outDetails">Unique Id</span>' + item.customerUserName + '</li><li><span class="outDetails">Email id</span>' + item.customermailId + '</li><li><span class="outDetails">Mobile Number</span>' + item.customerMobileNo + '</li><li><span class="outDetails">Photo</span>' + item.photo + '</li><li><span class="outDetails">Gender</span>' + item.Gender + '</li><li><span class="outDetails">DOB</span>' + item.DOB + '</li><li><span class="outDetails">Address</span>' + item.Address + '</li><li><span class="outDetails">Membership type</span>' + item.MembershipType + '</li><li><span class="outDetails">No. Of Times Prop Changed</span>' + item.noOfTimesPropChanged + '</li><li><span class="outDetails">Payment Status</span>' + item.PaymentStatus + '</li><li><span class="outDetails">Creation date</span>' + item.Date + '</li><li><span class="outDetails">Membership Start date</span>' + item.MembershipStartDate + '</li><li><span class="outDetails">Membership End Date</span>' + item.MembershipEndDate + '</li><li><span class="outDetails">Owner Unique Id</span>' + item.OwnerUnqId + '</li><li><span class="outDetails">Prop Unique Id</span>' + item.PropUnqId + '</li><li><span class="outDetails">Status</span>' + item.Status + '</li>');
    $("#customerEditInfo").click(function () {
        custProfileEdit(item);
    });
}
/* End of customer view profile */

/*Start of customer profile block*/
function customerProfileBlock(dataItem)
{
    var actionCustomer;
    if (dataItem.Status === 'Block')
    {
        if (!confirm("Do you want to Active Customer Profile")) {
            return false;
        }
        actionCustomer = 'activeCustomer';
    }
    if (dataItem.Status === 'Active')
    {
        if (!confirm("Do you want to Block Customer Profile")) {
            return false;
        }
        actionCustomer = 'blockCustomer';
    }
    $.ajax({
        type: 'post',
        url: '../CustomerController.do',
        data: {'action': actionCustomer, 'id': dataItem.customerUserName},
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
/*End of customer profile block*/


function validateEmail(email) {
    var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    if (filter.test(email)) {
        return true;
    } else {
        return false;
    }
}