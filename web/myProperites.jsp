<!DOCTYPE html>
<html lang="en">
    <head>
        <title></title>
        <!--ALL CSS FILES-->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/simple-line-icons.css" rel="stylesheet" type="text/css">
        <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
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
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12 col-md-4">
                        <%@include file="/clientInclude.jsp" %>
                    </div>
                    <div class="col-sm-12 col-md-7">
                        <div  class="clientHeader">
                            <h2>List Of All Properties</h2>
                        </div>
                        <div  class="mypropertyBody">
                            <div class="row">
                                <div class="col-sm-12 col-md-4">
                                    <div class="myPropertyType propertyRooms">
                                        <h2><span class="icon-home"></span>Rooms</h2>
                                        <span class="count">100</span>
                                    </div>
                                </div>
                                <div class="col-sm-12 col-md-4">
                                    <div class="myPropertyType propertyFlats">
                                        <h2><span class="icon-home"></span>Flats</h2>
                                        <span class="count">50</span>
                                    </div>
                                </div>
                                <div class="col-sm-12 col-md-4">
                                    <div class="myPropertyType propertyPG">
                                        <h2><span class="icon-home"></span>PG</h2>
                                        <span class="count">800</span>
                                    </div>
                                </div>
                            </div>
                            <!--                            <div class="row">
                                                            <div class="col-sm-12 col-md-6">
                                                                <div class="myPropertyType propertyPG">
                                                                    <h2><span class="icon-home"></span>PG</h2>
                                                                    <span class="count">800</span>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-12 col-md-6">
                                                                <div class="myPropertyType propertyHostels">
                                                                    <h2><span class="icon-home"></span>Hostels</h2>
                                                                    <span class="count">10</span>
                                                                </div>
                                                            </div>
                                                        </div>-->
                        </div>

                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="myProperties">
                            <h4>List Of All Properties</h4>

                            <table class="display" id="example">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Property ID</th>
                                        <th>Property Name</th>
                                        <th>Lisited Date of property</th>
                                        <th>Address</th>
                                        <th>Email Id</th>
                                        <th>Mobile Number</th>
                                        <th>Status</th>
                                        <th>Filled On</th>
                                        <th>Expired On</th>
                                        <th>Edit Operation</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>OTHO1290CF</td>
                                        <td>Raj PG</td>
                                        <td>23-JAN-2018</td>
                                        <td>E-26, Sector 3</td>
                                        <td>raj@gmail.com</t>
                                        <td>998999899</td>
                                        <td>Active</td>
                                        <td>16-JAN-2018</td>
                                        <td>23-April-2018</td>
                                        <td>
                                            <a href=""><span class="fa fa-edit"></span></a>
                                            <a href=""><span class="fa fa-eye"></span></a>
                                            <a href=""><span class="fa fa-recycle"></span></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>OTHO122332CF</td>
                                        <td><div>SANTAGIRLS PG</div></td>
                                        <td>1-JAN-2017</td>
                                        <td>SECTOR 44 NOIDA</td>
                                        <td>santa@gmail.com</td>
                                        <td>998999899</td>
                                        <td>pending</td>
                                        <td>9-Jun-2017</td>
                                        <td>18-May-2018</td>
                                        <td>
                                            <a href=""><span class="fa fa-edit"></span></a>
                                            <a href=""><span class="fa fa-eye"></span></a>
                                            <a href=""><span class="fa fa-recycle"></span></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>OTHO123213234CF</td>
                                        <td>BHAVAN TOWER</td>
                                        <td>2-Jun-2018</td>
                                        <td>Viman Nage</td>
                                        <td>bhavan@gmail.com</td>
                                        <td>6789002393</td>
                                        <td>Approved</td>
                                        <td>12-April-2019</td>
                                        <td>8-Dec-2018</td>
                                        <td>
                                            <a href=""><span class="fa fa-edit"></span></a>
                                            <a href=""><span class="fa fa-eye"></span></a>
                                            <a href=""><span class="fa fa-recycle"></span></a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
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
        <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/customscript.js" type="text/javascript"></script>
    </body>
</html>