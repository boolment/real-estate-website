<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include  file="../admin/adminheaderfiles.jsp" %>
        <style type="text/css">
            .portlet {
                margin-top: 0px;
                margin-bottom: 25px;
                box-shadow: 0px 2px 5px 2px rgba(0, 0, 0, 0.1);
                border: 0 !important;
                width: border-box;
            }
            .outlet-title{
                background-color: #cb5a5e;
                border-bottom: 0;
                padding: 0 10px;
                margin-bottom: 0;
                color: #fff;
                min-height: 42px;

            } 
            .caption{
                padding: 11px 0 9px 0;
                color: #FFFFFF;
                float: left;
                display: inline-block;
                font-size: 18px;
                line-height: 18px;

            }
            .portlet-body{
                background-color: #fff;
                padding: 10px;
                border: 0 !important;
                clear: both;
            }
            .main {
                display: flex;
                flex-flow: row wrap;
                background-color:#DEE0E0;
            }
            .widget {
                flex-basis: 300px;
                flex-grow: 10;
                height: 350px;
                margin: 15px;
                border-radius: 6px;
                background-color: #ffffff;
                position: relative;
            }
            .widget .title {
                background-color: #eef1f7;
                border-bottom: 1px solid #dfe4ec;
                padding: 10px;
                border-top-left-radius: 6px;
                border-top-right-radius: 6px;
                color: #617085;
                font-weight: 600;
            }
        </style>
    </head>
    <body>
         <!-- start of container -->
        <div class="container-fluid display-table">
                 <!-- start of row -->
            <div class="row display-table-row">
                <!-- side menu -->
                <%@include  file="../admin/adminsidebar.jsp" %>
                <!-- end side menu -->
                <!-- main content area -->
                <div class="col-md-10 col-sm-11 box display-table-cell valign-top">
                    <!-- top menu area --->
                    <%@include  file="../admin/admintopheader.jsp" %>
                    <!-- end of top menu area -->
                    <!-- start of main content area -->
                    <div id="content">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-lg-12">
                                    <h1 class="page-header clearfix">Dashboard</h1>
                                </div>

                            </div>
                            <!-- /.row -->
                            <div class="row">
                                <div class="col-lg-3 col-md-6">
                                    <div class="panel panel-primary">
                                        <div class="panel-heading">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <i class="fa fa-comments fa-5x"></i>
                                                </div>
                                                <div class="col-xs-9 text-right">
                                                    <div class="huge" id="customer"></div>
                                                    <div>Total Customer!</div>
                                                </div>
                                            </div>
                                        </div>
                                        <a href="#">
                                            <div class="panel-footer">
                                                <span class="pull-left">View Details</span>
                                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                <div class="clearfix"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6">
                                    <div class="panel panel-green">
                                        <div class="panel-heading">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <i class="fa fa-tasks fa-5x"></i>
                                                </div>
                                                <div class="col-xs-9 text-right">
                                                    <div class="huge" id="lead"></div>
                                                    <div>Total Lead!</div>
                                                </div>
                                            </div>
                                        </div>
                                        <a href="#">
                                            <div class="panel-footer">
                                                <span class="pull-left">View Details</span>
                                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                <div class="clearfix"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6">
                                    <div class="panel panel-yellow">
                                        <div class="panel-heading">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <i class="fa fa-shopping-cart fa-5x"></i>
                                                </div>
                                                <div class="col-xs-9 text-right">
                                                    <div class="huge" id="order"></div>
                                                    <div>New Orders!</div>
                                                </div>
                                            </div>
                                        </div>
                                        <a href="#">
                                            <div class="panel-footer">
                                                <span class="pull-left">View Details</span>
                                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                <div class="clearfix"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6">
                                    <div class="panel panel-red">
                                        <div class="panel-heading">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <i class="fa fa-support fa-5x"></i>
                                                </div>
                                                <div class="col-xs-9 text-right">
                                                    <div class="huge" id="ticket"></div>
                                                    <div>Total Tickets!</div>
                                                </div>
                                            </div>
                                        </div>
                                        <a href="#">
                                            <div class="panel-footer">
                                                <span class="pull-left">View Details</span>
                                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                <div class="clearfix"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>

                            </div>
                            <!-- /.row -->
                            <!-- Graphs for Business -->
                            <div class="row">
                                <hr/>    <h3 style="text-align:center">ScoreBoard</h3><hr/>  
                                <div class="main">
                                    <div class="col-lg-6 col-md-8">
                                        <div class="widget">
                                            <div class="title">Lead Detail Monthwise
                                                <select name="leadyear" id="leadyear">

                                                </select>                                           
                                                <a href="#" title="Export File" id="leaddetailmonthwise" onClick = "ExportDataExcelLead();"><i class="fa fa-file-excel-o fa-lg mt5 pull-right"></i>

                                                </a>
                                            </div>
                                            <div class="col-md-12 text-center pos-static" id="yearwiseleadcontainer">
                                                <!--Start  Column Chart Plotting -->


                                                <!--End of Column Chart Plotting -->
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-8">
                                        <div class="widget">
                                            <div class="title">Registered Customer Monthwise
                                                <select name="customeryear" id="customeryear">

                                                </select>
                                                <a href="#" title="Export File" id="customerdetailmonthwise" onClick = "ExportDataExcelUsers();"><i class="fa fa-file-excel-o fa-lg mt5 pull-right"></i>

                                                </a>
                                            </div>
                                            <div class="col-md-12 text-center pos-static" id="yearwisecustomercontainer">
                                                <!--Start  Column Chart Plotting -->


                                                <!--End of Column Chart Plotting -->
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-8">
                                        <div class="widget">
                                            <div class="title">Orders
                                                <select name="customeryear" id="orderyear">

                                                </select>
                                                <a href="#" title="Export File" id="orderdetailmonthwise" onClick = "ExportDataExcelOrders();"><i class="fa fa-file-excel-o fa-lg mt5 pull-right"></i>

                                                </a>
                                            </div>
                                            <div class="col-md-12 text-center pos-static" id="yearwiseordercontainer">
                                                <!--Start  Column Chart Plotting -->


                                                <!--End of Column Chart Plotting -->
                                            </div>
                                        </div>
                                    </div>
                                 <div class="col-lg-6 col-md-8">
                                        <div class="widget">
                                            <div class="title">Payment
                                                <select name="customeryear" id="paymentyear">

                                                </select>
                                                <a href="#" title="Export File" id="paymentdetailmonthwise" onClick = "ExportDataExcelPayments();"><i class="fa fa-file-excel-o fa-lg mt5 pull-right"></i>

                                                </a>
                                            </div>
                                            <div class="col-md-12 text-center pos-static" id="yearwisepaymentcontainer">
                                                <!--Start  Column Chart Plotting -->


                                                <!--End of Column Chart Plotting -->
                                            </div>
                                        </div>
                                    </div> 
                                </div>
                            </div>
                            <!-- End of Graphs for Business -->

                        </div>
                        <%@include  file="../admin/adminfooter.jsp" %>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>