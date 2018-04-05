<!DOCTYPE html>
<html lang="en">
    <head>
        <title></title>
        <!--ALL CSS FILES-->

        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">

        <link href="css/simple-line-icons.css" rel="stylesheet" type="text/css">
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/customstyle.css" rel="stylesheet" type="text/css">
        <link href="css/responsive.css" rel="stylesheet" type="text/css">
        <!--Google Fonts.-->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700,800" rel="stylesheet">
        <!-- Search Engine -->
        <meta name="" content="">
        <meta name="keywords" content="">
        <!-- Schema.org for Google -->
        <meta itemprop="name" content="">
        <meta itemprop="description" content="">
        <meta itemprop="image" content="http://www.boolment.com">
        <!-- Open Graph general (Facebook, Pinterest & Google+) -->
        <meta name="og:title" content="">
        <meta name="og:description" content="">
        <meta name="og:image" content="">
        <meta name="og:url" content="">
        <meta name="og:site_name" content="">
        <meta name="og:locale" content="">
        <meta name="fb:app_id" content="">
        <meta name="og:type" content="website">
        <!-- Twitter -->
        <meta name="twitter:card" content="summary_large_image">
        <meta name="twitter:site" content="@">
        <meta name="twitter:creator" content="@">
        <meta name="twitter:title" content="">
        <meta name="twitter:description" content="">
        <meta name="twitter:image" content="">
        <!--SEO TAGS-->
    </head>
    <body>
        <%-- Including header Section --%>
        <%@include file="/headerInclude.jsp" %>

        <section id="addNewProperty">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12 col-md-3">
                        <%@include file="/clientInclude.jsp" %>
                    </div>
                    <div class="col-sm-12 col-md-9">

                        <div class="propDetails">
                            <h4>Submit New Property</h4>
                            <form>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <h4>Owner Basic Details </h4>
                                    </div> 
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <label for="fname" class="control-label">First Name</label>
                                            <input type="text" class="form-control" id="fname" placeholder="First Name" required="">
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <label for="lname" class="control-label">Last Name</label>
                                            <input type="text" class="form-control" id="lname" placeholder="Last Name">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <label for="mnumber" class="control-label">Phone Number</label>
                                            <input type="number" class="form-control" id="mnumber" placeholder="998998999" required="">
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <label for="email" class="control-label">Email Id</label>
                                            <input type="email" class="form-control" id="email" placeholder="jhon@othogo.com" required="">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="ownershipDetails">
                                            <h4>OwnerShip Details</h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group customRadio">
                                            <label for="owner" class="control-label">Ownership Details</label>
                                            <div class="radio">
                                                <label class="radio-custom radio-inline" data-initialize="radio" id="owner-0">
                                                    <input name="owner" type="radio" value="Landlord"> <span class="radio-label">Landlord</span>
                                                </label>

                                                <label class="radio-custom radio-inline" data-initialize="radio" id="owner-1">
                                                    <input name="owner" type="radio" value="Tenant"> <span class="radio-label">Tenant</span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group customRadio">
                                            <label for="livestype" class="control-label">Who lives in the property ?</label>

                                            <div class="radio">
                                                <label class="radio-custom radio-inline" data-initialize="radio" id="livestype-0">
                                                    <input name="livestype" type="radio" value="Landlord"> <span class="radio-label">Landlord</span>
                                                </label>

                                                <label class="radio-custom radio-inline" data-initialize="radio" id="livestype-1">
                                                    <input  name="livestype" type="radio" value="Tenants"> <span class="radio-label">Tenants</span>
                                                </label>

                                                <label class="radio-custom radio-inline" data-initialize="radio" id="livestype-2">
                                                    <input name="livestype" type="radio" value="Empty"> <span class="radio-label">Empty</span>
                                                </label>

                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div  class="row">
                                    <div class="col-sm-12">
                                        <div class="form-group customRadio">
                                            <h4>Accommodation Type</h4>
                                            <div class="radio">
                                                <label class="radio-custom radio-inline" data-initialize="radio">
                                                    <input name="propType" type="radio" value="flat"> <span class="radio-label">Flat</span>
                                                </label>
                                                <label class="radio-custom radio-inline" data-initialize="radio">
                                                    <input  name="propType" type="radio" value="pg"> <span class="radio-label">PG</span>
                                                </label>
                                                <label class="radio-custom radio-inline" data-initialize="radio">
                                                    <input  name="propType" type="radio" value="room"> <span class="radio-label">Room</span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 col-md-4">
                                        <div class="form-group">
                                            <label for="flatType">Flat Types</label>
                                            <select class="form-control" id="flatType">
                                                <option>1 BHK</option>
                                                <option>2 BHK</option>
                                                <option>3 BHK</option>
                                                <option>4 BHK</option>
                                                <option>5 BHK</option>
                                                <option>1 RK</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-4">
                                        <div class="form-group">
                                            <label for="pgType">PG Types</label>
                                            <select class="form-control" id="pgType">
                                                <option>Single Sharing</option>
                                                <option>Double Sharing</option>
                                                <option>Triple Sharing</option>
                                                <option>Quad Sharing</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-4">
                                        <div class="form-group">
                                            <label for="roomType">Room Types</label>
                                            <select class="form-control" id="roomType">
                                                <option>Single Sharing</option>
                                                <option>Double Sharing</option>
                                                <option>Triple Sharing</option>
                                                <option>Quad Sharing</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="rentalDetails">
                                            <h4>Property Rental Details</h4>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="row">
                                            <div class="col-sm-12 col-md-6">
                                                <div class="form-group">
                                                    <label for="minRent" class="control-label">Min Rent</label>
                                                    <input type="text" class="form-control" id="minRent" placeholder="1000">
                                                </div>
                                            </div>
                                            <div class="col-sm-12 col-md-6">
                                                <div class="form-group">
                                                    <label for="maxRent" class="control-label">Max Rent</label>
                                                    <input type="text" class="form-control" id="maxRent" placeholder="1000">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="row">
                                            <div class="col-sm-12 col-md-6">
                                                <div class="form-group">
                                                    <label for="minSecurity" class="control-label">Min Security</label>
                                                    <input type="text" class="form-control" id="minSecurity" placeholder="1000">
                                                </div>
                                            </div>
                                            <div class="col-sm-12 col-md-6">
                                                <div class="form-group">
                                                    <label for="maxSecurity" class="control-label">Max Security</label>
                                                    <input type="text" class="form-control" id="maxSecurity" placeholder="1000">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="registerAddress">
                                            <h4>Property Address Details</h4>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <label for="houseno" class="control-label">House Number</label>
                                            <input type="number" class="form-control" id="houseno" placeholder="J-177" required="">
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <label for="floorType">Floor</label>
                                            <select class="form-control" id="floorType">
                                                <option>Ground Floor</option>
                                                <option>First Floor</option>
                                                <option>Second Floor</option>
                                                <option>Thrid Floor</option>
                                                <option>other</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <label for="street" class="control-label">Street </label>
                                            <input type="text" class="form-control" id="street" placeholder="E Block">
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <label for="landmark" class="control-label">Landmark</label>
                                            <input type="text" class="form-control" id="landmark" placeholder="Near Sector 16 Metro Station">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <label for="sector" class="control-label">Sector</label>
                                            <input type="text" class="form-control" id="sector" placeholder="Sector 3">
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <label for="city" class="control-label">City</label>
                                            <input type="text" class="form-control" id="city" placeholder="Noida">  
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <label for="state" class="control-label">State</label>
                                            <input type="text" class="form-control" id="state" placeholder="Uttar Pradesh">
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <label for="pincode" class="control-label">PIN Code</label>
                                            <input type="number" class="form-control" id="pincode" placeholder="201301">

                                        </div>
                                    </div>
                                </div>


                                <div class="row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <label for="pgType">Available for</label>
                                            <select class="form-control" id="pgType">
                                                <option>Male</option>
                                                <option>Female</option>
                                                <option>Any</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <label for="roomType">Availability Details</label>
                                            <select class="form-control" id="roomType">
                                                <option>Available Now</option>
                                                <option>After 15 Days</option>
                                                <option>In 1 Month</option>
                                                <option>In 2 Month</option>

                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="amenities">
                                            <h4>Property Amenities</h4>
                                        </div>
                                    </div>
                                </div>


                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="allCheckBox">
                                            <label><input type="checkbox" value="">Food</label>
                                            <label><input type="checkbox" value="">AC</label>
                                            <label><input type="checkbox" value="">Non AC</label>
                                            <label><input type="checkbox" value="">Cooler</label>
                                            <label><input type="checkbox" value="">Parking</label>
                                            <label><input type="checkbox" value="">Maid / Servant</label>
                                            <label><input type="checkbox" value="">Laundry</label>
                                            <label><input type="checkbox" value="">Water Supply</label>
                                            <label><input type="checkbox" value="">Electricity</label>
                                            <label><input type="checkbox" value="">Fridge</label>
                                            <label><input type="checkbox" value="">Washing Machine</label>
                                            <label><input type="checkbox" value="">Land Line Phone</label>
                                            <label><input type="checkbox" value="">TV</label>
                                            <label><input type="checkbox" value="">Almirah</label>
                                            <label><input type="checkbox" value="">Mail Box</label>
                                            <label><input type="checkbox" value="">Door Bell</label>
                                            <label><input type="checkbox" value="">Bathroom</label>
                                            <label><input type="checkbox" value="">Balcony</label>
                                            <label><input type="checkbox" value="">Lift</label>
                                            <label><input type="checkbox" value="">Wifi</label>
                                            <label><input type="checkbox" value="">Overlooking Garden</label>
                                            <label><input type="checkbox" value="">Geyser</label>
                                            <label><input type="checkbox" value="">Gym</label>
                                            <label><input type="checkbox" value="">Vasstushastra</label>
                                            <label><input type="checkbox" value="">Gated Society</label>
                                            <label><input type="checkbox" value="">Security Gard</label>
                                            <label><input type="checkbox" value="">Swimming Pool</label>
                                            <label><input type="checkbox" value="">Power Backup</label>
                                            <label><input type="checkbox" value="">Indian Toilet</label>
                                            <label><input type="checkbox" value="">Western Toilet</label>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="form-group addPropBtn">
                                            <button class="btn btn-success">Save Property</button>
                                        </div>
                                    </div>
                                </div>

                                <!--end of form row-->                                
                            </form>
                        </div>
                        <!--propDetails-->
                    </div>
                    <!--end of col-md-9-->
                </div>
                <!--end of row-->
            </div>
            <!--end of container-fluid-->
        </section>
        <!-- end of section addNewProperty -->

        <!--include  footer-->
        <%@include file="/footer.jsp" %>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/customscript.js" type="text/javascript"></script>

    </body>
</html>