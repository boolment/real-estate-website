<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<link rel="stylesheet" type="text/css" href="../css/customadmin.css">

    </head>
    <body>

        <div class="login member">
            <div class="container">
                <div class="row">
                    <div id="ownerError" class="alert alert-danger" style="display:none"></div>


                    <div class="col-sm-12 col-md-9" id="osiginDiv">
                        <div class="loginForm">
                            <h1>Login <small>Owner Member login area</small></h1>

                            <div class="form-group">
                                <label for="inputEmail" class="control-label">Email Address</label>
                                <input type="email" name="ownerEmail" id="oEmail" placeholder="jho@boolemt.com" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="clientPass" class="control-label">Password</label>
                                <input type="password" name="ownerPassword" id="oPassword" placeholder="***********" class="form-control">
                            </div>
                            <div class="form-group">
                                <div class="inputWrapper"><a href="#" id="oforgotLink">Forgot Password</a></div>
                            </div>
                            <div class="form-group">
                                <label>
                                    <input type="checkbox"> Remember Me
                                </label>
                            </div>
                            <button type="submit" class="btn btn-primary" id="ownerSignIn">Sign In</button>                            
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-9" id="oforgotDiv" style="display: none">
                        <h1>Forgot Password</h1>

                        <div id="errorForgotPassword" class="alert alert-danger" style="display:none"></div>

                        <div class="form-group">
                            <label for="inputEmail" class="control-label">Email Address</label>
                            <input type="email" name="custoomerEmail" id="oforogotemail" placeholder="jhon@boolemt.com" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-primary" id="ownerSendOTP">Send OTP</button>  
                    </div>
                      <div class="col col-sm-12" id="oforgotPasswordOTP"  style="display:none">
                        <h1>User Forgot Password</h1>
                        <div id="errorBus" class="alert alert-danger" style="display:none"></div>
                        <div id="successBus" class="alert alert-success" style="display:none"></div>
                        
                            <div class="container-fluid">
                      
                            
                                    <div id="msgalert"></div>
                                    <div class="form-group">
                                        <label for="email-id" class="control-label">email ID<span class="red">*</span></label>
                                        <input type="email" name="emailID" id="oemailId" value=""  class="form-control" >
                                    </div>
                                    <div class="form-group">
                                        <label for="business-name" class="control-label">OTP<span class="red">*</span></label>
                                        <input type="password" name="otp" id="ootp" placeholder="Enter OTP" class="form-control">
                                    </div>
                                   <div class="form-group">
                                        <label for="business-name" class="control-label">New Password<span class="red">*</span></label>
                                        <input type="password" name="otp" id="onewpassword" placeholder="Enter New Password" class="form-control" >
                                    </div>
                                   <div class="form-group">
                                        <label for="business-name" class="control-label">Confirm New Password<span class="red">*</span></label>
                                        <input type="password" name="otp" id="oconfirmnewpassword" placeholder="Confirm New Password" class="form-control" >
                                    </div>
                                    <div class="form-group">
                                        <a href="#" id="oresendOTP">Resend OTP</a>
                                    </div>
                                    <div class="form-group">
                                        <label>&nbsp;</label>
                                        <input type="submit" value="Validate" id="ootpSubmit">
                                    </div>
                                 
                            </div>
                        
                    </div>
                </div><!--end of row -->
            </div><!--End container -->
             <script src="../js/jquery.min.js"></script>
    <script src="../js/customadmin.js"></script>
        </div><!--end of login -->


    </body>
</html>
