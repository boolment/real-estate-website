
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>     
<%@page import="beans.PromoMasterBean"%>
<%@page import="DAOImpl.PromoImpl"%>
<%@page import="DAOInterface.PromoInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin | Coupan Report</title>
        <%@include file="adminheaderfiles.jsp" %>
        <style>
            .hyperTicket{
                a:link{
                    text-decoration:none;
                }
                a:visited{text-decoration: none;}
                a:hover{text-decoration: underline;}
                a:active{text-decoration: underline;}
            }
            .text-success {
                color: #10c469;
            }
            .text-warning {
                color: #FFC107;
            }
            .status {
                font-size: 30px;
                margin: 2px 2px 0 0;
                display: inline-block;
                vertical-align: middle;
                line-height: 10px;
            }

        </style>
    </head>
    <body>
        <!-- start of container -->
        <div class="container-fluid display-table">
            <!-- start of row -->
            <div class="row display-table-row">
                <!-- start of side menu -->
                <%@include file="adminsidebar.jsp" %>
                <!-- end of side menu -->
                <!-- main content area -->
                <div class="col-md-10 col-sm-11 box display-table-cell valign-top">
                    <!-- top menu area --->
                    <%@include file="admintopheader.jsp" %>
                    <!-- end of top menu area -->
                    <div class="content">
                        <header class="clearfix">
                            <h2 class="page_title">View Coupan</h2>
                        </header>

                        <div class="content-inner">
                            <div class="row">
                                <div class="form-group">
                                    <label for="service" class="col-md-2">Select Specific Period</label>
                                    <div class="col-md-12 ">
                                        From Date:<input type="date" name="bday" id="fromticket" class="input-daterange">
                                        &nbsp;&nbsp;&nbsp;&nbsp;To Date:<input type="date" name="bday" id="toticket" class="input-daterange">
                                        &nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="btn btn-info" id="cbtnexport" value="Export to Excel">
                                        &nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="btn btn-primary"><i class="fa fa-file-excel-o fa-lg mt5 pull-right"></i><span>Refresh List</span></a>
                                        <a href="coupanAdminReport.jsp" id="report" style="display:block;opacity:0">Download Report</a>
                                    </div>

                                </div>
                            </div><hr>
                            <table id="example" class="table table-striped table-bordered removeTableWeight" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th>Code</th>                                  
                                        <th>Start Date</th>
                                        <th>Expiry Date</th>
                                        <th>Condition</th>
                                        <th>Discount</th>
                                        <th>Creation Date</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                       <th>Code</th>                                  
                                        <th>Start Date</th>
                                        <th>Expiry Date</th>
                                        <th>Condition</th>
                                        <th>Discount</th>
                                        <th>Creation Date</th>
                                        <th>Status</th>
                                    </tr>
                                </tfoot>
                                <tbody>

                                </tbody>
                            </table> 

                        </div>
                        <!-- End of Main Content Area -->
                        <%@include file="adminfooter.jsp" %>
                    </div>
                    <script type="text/javascript">
                        $('#example').DataTable({
                            "autoWidth": false
                        });
                        $('#cbtnexport').click(function () {
                            var todate = $("#toticket").val();
                            var fromdate = $("#fromticket").val();
                            if (todate !== null && fromdate !== null && todate !== "" && fromdate !== "")
                            {
                                $.ajax({
                                    type: 'POST',
                                    url: '../PromoController.do',
                                    data: {'todate': todate, 'fromdate': fromdate},
                                    dataType: "json",
                                    restful: true,
                                    cache: false,
                                    timeout: 20000,
                                    async: true,
                                    success: function (data) {
                                        if (data.message === "success") {
                                            $('#example').DataTable().clear().draw();
                                            //   var jsonArray = JSON.parse(data.exportExcel);
                                            //   var  jsonArray=JSON.parse(data.exportExcel);
                                            // int i=0;
                                            jQuery(data.Excel).each(function (i, item) {
                                                console.log(item.UserId, item.First_Name, item.Email, item.Phone_No);
                                                $('#example').DataTable().row.add([
                                                    item.coupan_code,
                                                    item.coupan_start_date,
                                                    item.coupan_expire_date,
                                                    item.coupen_condition,
                                                    item.coupan_discount,
                                                    item.coupan_creation_date_and_time,
                                                    item.coupan_status,
                                                ]).draw(false);
                                            });
                                            if (data.Excel.length !== 0)
                                            {
                                                //  document.getElementById('report').style.display = 'block';
                                                // document.getElementById('report').style.opacity='1';
                                                $('#report').css('display', 'block');
                                                $('#report').css('opacity', '1');
                                            } else
                                            {
                                                $('#report').css('display', 'none');
                                                $('#report').css('opacity', '0');
                                            }
                                        } else
                                        {
                                        }
                                    },
                                    error: function (data) {
                                        alert("Something went wrong. Please try after sometime!");
                                    }
                                });
                            } else
                            {
                                alert("Please select the corret Period of time");
                            }
                        });
                    </script>
                </div>
            </div>
            <!-- end of row -->
        </div>
    </body>
</html>