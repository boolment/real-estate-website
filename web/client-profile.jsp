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

        <section id="client-Profile">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 col-md-4">
                        <%@include file="/clientInclude.jsp" %>
                    </div>
                    <div class="col-sm-12 col-md-7">
                        <div  class="clientHeader">
                            <h2>My Account Details</h2>
                        </div>
                        <div class="clientBody">
                            <div class="row">
                                <div class="col-sm-12 col-md-3">
                                    <img src="images/mahainder.png" alt="Client Img" class="img-fluid">
                                </div>
                                <div class="col-sm-12 col-md-9 form-group">
                                    <div class="upload-btn-wrapper">
                                        <button class="btn">Upload a file</button>
                                        <input type="file" name="myfile" class="form-control" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="clientProfileForm">
                            <form>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <label for="fname" class="control-label">First Name</label>
                                            <input type="text" class="form-control" id="fname" placeholder="Ram Chander" name="fname" required autocomplete="off">
                                        </div>
                                        <div class="form-group">
                                            <label for="email" class="control-label">Email Id</label>
                                            <input type="email" class="form-control" id="email" placeholder="ramlala@othogo.com" name="email" required autocomplete="off">
                                        </div>
                                        <div class="form-group">
                                            <label for="mnumber" class="control-label">Mobile No</label>
                                            <input type="number" class="form-control" id="mnumber" placeholder="Ram Chander" name="mnumber" required autocomplete="off">
                                        </div>
                                        <div class="form-group">
                                            <label for="mnumber" class="control-label">About Me</label>
                                            <textarea  class="form-control"></textarea>
                                        </div>
                                        <div class="form-group addPropBtn">
                                            <button class="btn btn-success">Save Profile</button>
                                        </div>
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
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/customscript.js" type="text/javascript"></script>
    </body>
</html>