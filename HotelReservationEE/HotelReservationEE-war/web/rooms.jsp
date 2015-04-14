<%-- 
    Document   : services
    Created on : 27-Mar-2015, 8:42:44 AM
    Author     : meenakshimehta
--%>

<%@page import="session.OperationsRemote"%>
<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Paradise Hotel</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="stylesheet/style.css" rel="stylesheet" type="text/css" />
        <link href="stylesheet/layout.css" rel="stylesheet" type="text/css" />
        <script src="scripts/maxheight.js" type="text/javascript"></script>
    </head>
    <body id="page2" onload="new ElementMaxHeight();">
        <div id="main">
            <%@include file="header.jsp" %>


            <div id="content">
                <div class="wrapper">
                    <div class="aside maxheight">
                        <%
                            String isAvailability = (String) session.getAttribute("isAvailability");
                            if (isAvailability=="true") {
                        %>
                        <%@include file="menuSidebar.jsp" %>
                        <%             } else {
                        %>
                        <%@include file="bookingSidebar.jsp" %>
                        <%
                            }
                        %>         


                    </div>

                    <div class="content">
                        <div class="indent">
                            <h2>We offer several kinds of rooms views</h2>
                            <div class="container">
                                <form action="ViewDetails.jsp" method="get">
                                    <div class="col-1">
                                        <h4>City View</h4><br/>
                                        <img alt="" src="images/city.jpeg" width="180" height="150"/>
                                        <br/><br/>

                                        <input type="submit" name="view" value="City View"/>
                                    </div>
                                    <div class="col-2">
                                        <h4>Ocean View</h4><br/>
                                        <img alt="" src="images/ocean.jpg" width="180" height="150"/>
                                        <br/><br/>
                                        <div class="button"><span><span>  
                                                    <input type="submit" name="view" value="Ocean View"/></span></span></div>
                                    </div>
                                    <div class="col-3"> 
                                        <h4>Mountain View</h4><br/>
                                        <img alt="" src="images/mountain.jpg" width="180" height="150"/>
                                        <br/><br/>
                                        <div class="button"><span><span>  
                                                    <input type="submit" name="view" value="Mountain View"/></span></span></div>
                                    </div>
                                </form>
                                <div class="clear"></div>
                            </div>
                        </div></div></div></div>


            <%@include file="footer.jsp" %>
        </div>
</html>