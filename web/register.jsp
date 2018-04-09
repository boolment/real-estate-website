<!DOCTYPE html>
<html lang="en">
    <head>
        <title></title>
        <!--ALL CSS FILES-->
        
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css">
        <link href="css/simple-line-icons.css" rel="stylesheet" type="text/css">
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/owl.carousel.min.css" rel="stylesheet" type="text/css">
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
       
        <section id="login-register">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-6 ">
                    <div class="WhyRegister">
                        <h2>Why You Should Register</h2>
                        <ul>
                            <li><span><i class="icon-loop"></i> Look </span> Finalise a time and date to visit the homes you like.</li>
                            <li><span><i class="icon-mouse"></i> Book  </span> Pay a token amount online to lock the bed / room / house.</li>
                            <li><span><i class="icon-location-pin"></i> Move In  </span> Choose a move-in date and just show up!</li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-12 col-md-6">
                    <div class="register">
                        
                        <h2>Sing Up Here</h2>
                        <form >
                            <div class="row">
                                <div class="col-sm-12 form-group">
                                    <input type="text" class="form-control" id="fname" name="fname" placeholder="Full Name">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 form-group">
                                    <input type="number" class="form-control" id="fname" name="fname" placeholder="Phone Number">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 form-group">
                                    <input type="email" class="form-control" id="fname" name="fname" placeholder="Email ID">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 form-group">
                                    <input type="password" class="form-control" id="fname" name="fname" placeholder="Password">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 form-group">
                                    <input type="password" class="form-control" id="fname" name="fname" placeholder="Confirm Password">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <button class="scheduleBtn">Sing Up</button>
                                </div>
                            </div>
                            
                             <div class="row">
                                    <div class="col-sm-12">
                                        <a href="http://localhost:8080/othogo/login.jsp" class="scheduleBtn">Log In Now</a>
                                    </div>
                                </div>
                        </form>
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
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/owl.carousel.min.js" type="text/javascript"></script>
        <script src="js/customscript.js" type="text/javascript"></script>
    </body>
</html>