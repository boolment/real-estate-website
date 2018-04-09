
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include  file="adminheaderfiles.jsp" %>
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

                    <%@include  file="admintopheader.jsp" %>

                    <!-- end of top menu area -->
                    <!-- start of main content area -->
                    <div class="content" id="getAllOwner"  style="display:block">
                        <header>
                            <h2 class="page_title">Manage All Your Coupan</h2>
                        </header>
                        <div class="content-inner">
                            <div class="row">
                                <div class="col-sm-12"> 
                                    <div id="errorOwner" class="alert alert-danger" style="display:none"></div>

                                    <table id="ownerDisplay" class="table table-striped table-bordered removeTableWeight" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th>F Name</th>
                                                <th>L Name</th>
                                                <th>Mobile no.</th>
                                                <th>Mail Id</th>
                                                <th>Address</th> 
                                                <th>Date</th> 
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>F Name</th>
                                                <th>L Name</th>
                                                <th>Mobile no.</th>
                                                <th>Mail Id</th>
                                                <th>Address</th> 
                                                <th>Date</th> 
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>

                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                    </div> 
                    <!-- start of view Lead content area --->
                    <div class="content" id="viewOwner" style="display:none">
                        <header>
                            <h2 class="page_title">View Staff Details</h2>
                        </header> 
                        <div class="customerProfile">
                            <div class="content-inner">                         
                                <div id="errorCoupanProfile" class="alert alert-danger" style="display:none"></div>
                                <div id="successCoupanProfile" class="alert alert-success" style="display:none"></div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <a href="viewAllOwner.jsp" class="pull-right btnAddOutLet"><i class="fa fa-arrow-left"></i> Back To Owner List</a>
                                    </div>
                                    <div class="col-sm-12 col-md-4">
                                        <div class="row">

                                            <div class="col-sm-12">
                                                <div class="customerProfileSidebar">
                                                    <div class="profilePic">
                                                        <img src="../images/userProfile.jpg" alt="">
                                                        <h6 id="profileName"></h6>
                                                        <p id="staffPhone"></p>
                                                    </div>
                                                    <span><i class="fa fa-home"></i> <a href="#bookingHistory" id="booking"> Overview</a></span>
                                                    <span><i class="fa fa-gear"></i> <a href="#" id="ownerEditInfo"> Edit Info</a></span>

                                                    <a class="btn btn-primary" id="customerBtn">Book Appointment</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <div class="businessCount">
                                                    <ul class="clearfix">
                                                        <li><label>100</label> Total Business </li>
                                                        <li><label>100</label> Total Booking </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-8">
                                        <div class="customerProfileRightSidebar" id="bookingHistory" style="display: block">
                                            <h5>Owner Profile</h5>
                                            <ul id="ownerProfileView">
                                                <!--view Profile Data here    -->


                                            </ul>                                           
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end of view Lead content area --->
                    <!-- start of main content area -->
                    <div class="content" id="editOwner" style="display:none">
                        <header>
                            <h2 class="page_title">Edit Coupan Details</h2>
                        </header>
                        <div class="content-inner">
                            <div class="row">
                                <div class="col-md-12">
                                    <a href="viewAllCoupan.jsp" class="pull-right btnAddOutLet"><i class="fa fa-arrow-left"></i> Back To Owner List</a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="panel-group">
                                        <div class="panel panel-default panel-custombasic">
                                            <div class="panel-heading">
                                                <div class="panel-title">
                                                    <div class="caption">
                                                        <i class="fa fa-briefcase"> Owner Profile</i>
                                                        <a data-toggle="collapse" href="#collapse1" data-original-title><i class="fa fa-plus"></i></a>
                                                    </div>


                                                </div>
                                            </div>                                           
                                            <div id="collapse1" class="panel-collapse in active">
                                                <div class="panel-body">
                                                    <div id="errorOwner" class="alert alert-danger" style="display:none"></div>
                                                    <div id="successBusiness" class="alert alert-success" style="display:none"></div>                        
                                                    <div class="row">
                                                        <form   id="form1">
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <label  class="control-label" for="ownerName">First Name <span class="red">*</span></label>
                                                                    <input type="text" placeholder="First Name" id="fname" name="ownerName" class="form-control" autocomplete="off" >
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <label  class="control-label" for="ownerName">Last Name<span class="red">*</span></label>
                                                                    <input type="text" placeholder="Start Date" id="lname" name="ownerName" class="form-control" autocomplete="off" >
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <label  class="control-label" for="ownerName">Mobile Number<span class="red">*</span></label>
                                                                    <input type="text" placeholder="Expiry Date" id="mobno" name="ownerName" class="form-control" autocomplete="off" >
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <label  class="control-label" for="ownerName">Email Id<span class="red">*</span></label>
                                                                    <input type="text" placeholder="Discount" id="emailId" name="ownerName" class="form-control" autocomplete="off" >
                                                                </div>
                                                            </div>
                                                             <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <label  class="control-label" for="ownerName">Date Of Birth<span class="red">*</span></label>
                                                                    <input type="text" placeholder="Discount" id="dob" name="ownerName" class="form-control" autocomplete="off" >
                                                                </div>
                                                            </div>
                                                             <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <label  class="control-label" for="ownerName">Address<span class="red">*</span></label>
                                                                    <input type="text" placeholder="Discount" id="address" name="ownerName" class="form-control" autocomplete="off" >
                                                                </div>
                                                            </div>
                                                                  <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <label  class="control-label" for="ownerName">Status<span class="red">*</span></label>
                                                                    <select class="form-control required" id ="ostatus" name="dropdownlist">
                                                                        <option value="">Select Status</option>
                                                                        <option value="Active">Active</option>
                                                                        <option value="Block">Block</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                                <input type="hidden" id="ownerId"/>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                </div>
                                                            </div>                                                                         
                                                            <div class="clearfix" style="height: 10px;clear: both;"></div>
                                                            <div class="form-group">
                                                                <div class="col-lg-12">
                                                                    <button class="btn btn-primary open1" id="editOwnerBasic" type="button"><i class="fa fa-arrow-right fa-1x"></i>Update</button>
                                                                    <button class="btn btn-default open1" id="cancelOwnerupdate" type="button"><i class="fa fa-close fa-1x"></i>Cancel</button> 
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
                    <%@include  file="adminfooter.jsp" %>
                </div>
            </div>
        </div>

        <!-- end of main content area -->

    </body>
</html>