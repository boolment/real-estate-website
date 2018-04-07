<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="adminheaderfiles.jsp" %>
    </head>
    <body>
        <!-- start of container -->
        <div class="container-fluid display-table">
            <!-- start of row -->
            <div class="row display-table-row">
                <!-- side menu -->
                <%@include file="adminsidebar.jsp" %>
                <!-- end side menu -->
                <!-- main content area -->
                <div class="col-md-10 col-sm-11 box display-table-cell valign-top">
                    <!-- top menu area --->

                    <%@include file="admintopheader.jsp" %> 
                    <!-- end of top menu area -->
                    <!-- start of main content area -->
                    <div class="content" id="editCustomer" style="display:block">
                        <header>
                            <h2 class="page_title"> Add New Coupan </h2>
                        </header>
                        <div class="content-inner">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="panel-group">
                                        <div class="panel panel-default panel-custombasic">
                                            <div class="panel-heading">
                                                <div class="panel-title">
                                                    <div class="caption">
                                                        <i class="fa fa-briefcase"> Add Coupan</i>
                                                        <a data-toggle="collapse" href="#collapse1" data-original-title><i class="fa fa-plus"></i></a>
                                                    </div>
                                                </div>
                                            </div>                                           
                                            <div id="collapse1" class="panel-collapse in active">
                                                <div class="panel-body">
                                                    <div id="coupanError" class="alert alert-danger" style="display:none"></div>
                                                    <div id="successCoupan" class="alert alert-success" style="display:none"></div>                        
                                                    <div class="row">
                                                        <form   id="form1">
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <label  class="control-label" for="ownerName">Coupan Code<span class="red">*</span></label>
                                                                    <input type="text" placeholder="Code" id="code" name="ownerName" class="form-control" autocomplete="off" >
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <label  class="control-label" for="ownerName">Start Date<span class="red">*</span></label>
                                                                    <input type="text" placeholder="Start Date" id="sdate" name="ownerName" class="form-control" autocomplete="off" >
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <label  class="control-label" for="ownerName">Expiry Date<span class="red">*</span></label>
                                                                    <input type="text" placeholder="Expiry Date" id="edate" name="ownerName" class="form-control" autocomplete="off" >
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <label  class="control-label" for="ownerName">Discount<span class="red">*</span></label>
                                                                    <input type="text" placeholder="Discount" id="discount" name="ownerName" class="form-control" autocomplete="off" >
                                                                </div>
                                                            </div>                                                                                                         
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                </div>
                                                            </div>  
                                                            <div class="clearfix" style="height: 10px;clear: both;"></div>
                                                            <div class="form-group">
                                                                <div class="col-lg-12">
                                                                    <button class="btn btn-primary open1" id="addnewCoupan" type="button"><i class="fa fa-arrow-right fa-1x"></i>Submit</button>
                                                                    <button class="btn btn-default open1" id="cancelCoupan" type="button"><i class="fa fa-close fa-1x"></i>Cancel</button> 
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </div> 
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!--End content-inner-->
                    </div>
                    <!-- end of main content area -->

                    <%@include file="adminfooter.jsp" %>
                </div>
            </div>
        </div>

        <!-- end of main content area -->

    </body>
</html>
