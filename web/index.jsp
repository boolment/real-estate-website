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

        <section id="header">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12 offset-md-7 col-md-5">
                        <div  class="headDiv">
                            <h1>Book Your Dream living Standard</h1> 
                            <ul>
                                <li><span class="freeServices"><i class="icon-badge"></i> Brokerage Free Flat</span></li>
                                <li><span class="freeServices"><i class="icon-badge"></i> Brokerage Free PG</span></li>
                                <li><span class="freeServices"><i class="icon-badge"></i> Brokerage Free Hostel</span></li>
                                <li><span class="freeServices"><i class="icon-badge"></i> Brokerage Free Rooms</span></li>
                            </ul>
                            <button class="customBtn">Book Now</button>
                        </div>
                        <!--                        <div class="headBooking">
                                                    <form>
                                                        <div class="row">
                                                            <div class="form-group col-sm-12 col-md-8">
                                                                <label for="fname" class="control-label">Full Name</label>
                                                                <input type="text" class="form-control" id="fname" placeholder="Jhon"></input>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="form-group col-md-8">
                                                                <label for="fname" class="control-label">Full Name</label>
                                                                <input type="text" class="form-control" id="fname" placeholder="Jhon"></input>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="form-group col-md-8">
                                                                <label for="fname" class="control-label">Full Name</label>
                                                                <input type="text" class="form-control" id="fname" placeholder="Jhon"></input>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="form-group col-md-8">
                                                                <label for="fname" class="control-label">Full Name</label>
                                                                <input type="text" class="form-control" id="fname" placeholder="Jhon"></input>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>-->
                    </div>
                </div>
            </div>
        </section>
        <%@include file="/searchBarInclude.jsp" %>

        
        <section id="allPropList">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12 col-md-8">
                        <div class="bodyAllPropList">
                            <div class="row">
                                <div class="col-sm-12 col-md-6">
                                    <div class="propDiv">
                                        <div class="propImgDiv">
                                            <img  src="images/pic-1.jpg">
                                            <div class="topDivImg">
                                                <span class="property-badge">Hostel</span>
                                                <span class="property-for">Girls</span>
                                            </div>
                                            <div class="bottomDivImg">
                                                <span class="listing-type"><i class="fa fa-bed"></i> 3 BHK Flat</span>
                                                <div class="listing-info">
                                                    <span class="listing-loc"><i class="fa fa-map-marker"></i> Sector 3, Noida</span>
                                                    <span class="listing-st">Uttar Pradesh</span>
                                                </div>
                                                <span class="listing-price"><i class="fa fa-rupee"></i> 10,000/<sub>Mon</sub></span>
                                            </div>
                                        </div>
                                        <div class="propIntro">
                                            <div class="propAni">
                                                <ul class="clearfix">
                                                    <li><span class="propIcons"><i class="fa fa-home"></i> Home</span></li>
                                                    <li><span class="propIcons"><i class="fa fa-female"></i> Girls</span></li>
                                                    <li><span class="propIcons"><i class="fa fa-bed"></i> Bed</span></li>
                                                    <li><span class="propIcons"><i class="fa fa-bath"></i> Bathroom</span></li>
                                                    <li><span class="propIcons"><i class="fa fa-battery-full"></i> PowerBackup</span></li>
                                                    <li><span class="propIcons"><i class="fa fa-tv"></i> TV</span></li>
                                                </ul>
                                            </div>
                                            <div class="propBookingDiv clearfix">
                                                <span class="listing-view"><a href=""><i class="fa fa-eye"></i> View Details</a></span>
                                                <span class="listing-booking"><a href=""><i class="fa fa-calendar"></i> Book Now</a></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!--services-->
        <section id="services">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12 col-md-6">
                        <div class="relaEstateServices">
                            <h2>Best Real Estate Property Services</h2>
                            <p>He made his passenger captain of one, with four of the men; and himself, his mate, and five more, went in the other; and they contrived their business very well, for they came up to the ship about midnight.</p>
                            <div class="row">
                                <div class="col-sm-12 col-md-6">
                                    <ul>
                                        <li><span class="servicesIcons"><i class="icon-home"></i></span> Worldwide Company</li>
                                        <li><span class="servicesIcons"><i class="icon-home"></i></span> Fastest Services</li>
                                        <li><span class="servicesIcons"><i class="icon-home"></i></span> Personal Assistant</li>
                                    </ul>
                                </div>
                                <div class="col-sm-12 col-md-6">
                                    <ul>
                                        <li><span class="servicesIcons"><i class="icon-home"></i></span> Largest Real Estate Base</li>
                                        <li><span class="servicesIcons"><i class="icon-home"></i></span> Lowest Commission</li>
                                        <li><span class="servicesIcons"><i class="icon-home"></i></span> Property Insurance</li>
                                    </ul>
                                </div>
                            </div>
                            <p>He made his passenger captain of one with four of the men.</p>
                            <button class="customBtn createAccount">Create Account</button>
                            <button class="customBtn signup">Sign Up</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--end of services-->

        <!--features -->
        <section id="features">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12 offset-md-6 col-md-6">
                        <div class="featuresBody">
                            <ul>
                                <li>
                                    <div class="featuresHeading">
                                        <h4><span class="servicesIcons"><i class="icon-home"></i></span>World Wide Company</h4>
                                        <p>He made his passenger captain of one, with four of the men; and himself, his mate, and five more, went in the other</p>
                                    </div>
                                </li>
                                <li>
                                    <div class="featuresHeading">
                                        <h4><span class="servicesIcons"><i class="icon-home"></i></span>World Wide Company</h4>
                                        <p>He made his passenger captain of one, with four of the men; and himself, his mate, and five more, went in the other</p>
                                    </div>
                                </li>
                                <li>
                                    <div class="featuresHeading">
                                        <h4><span class="servicesIcons"><i class="icon-home"></i></span>World Wide Company</h4>
                                        <p>He made his passenger captain of one, with four of the men; and himself, his mate, and five more, went in the other</p>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--end of features-->

        <section id="newsletter">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12 col-md-3">
                        <div class="newsletterBody">
                            <img src="images/emailSupport.png" alt="email">

                            <h5>Send Your Query</h5>
                            <p>contact@othogo.com</p>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-3">
                        <div class="newsletterBody">
                            <img src="images/phoneSupport.png" alt="email">
                            <h5>Talk to No brokerage</h5>
                            <p>+91-9988899989</p>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                        <div class="newsletterBody">
                            <img src="images/emailSupport.png" alt="email">
                            <h5>Property Newsletter </h5>
                            <div class="newsletterForm">
                                <form>
                                    <div class="row">
                                        <div class="form-group col-sm-12 col-md-6">
                                            <input type="text" placeholder="Enter Your Email Id" class="form-control">  
                                        </div>
                                        <div class="col-sm-12 offset-md-2 col-md-3">
                                            <button class="customBtn">Subscribe</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>



        <!--include  footer-->
        <%@include file="/footer.jsp" %>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/customscript.js" type="text/javascript"></script>
    </body>
</html>