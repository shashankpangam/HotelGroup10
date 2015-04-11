<%-- 
    Document   : login
    Created on : 27-Mar-2015, 10:36:18 AM
    Author     : meenakshimehta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Paradise Hotel</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="stylesheet/style.css" rel="stylesheet" type="text/css" />
        <link href="stylesheet/layout.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
            <script src="scripts/maxheight.js" type="text/javascript"></script>
            <script type="text/javascript" src="jquery.idTabs.min.js"></script>
            <script src="//code.jquery.com/jquery-1.10.2.js"></script>
            <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
            <script>
                $(function () {
                    $("#tabs").tabs();
                });
            </script>

    </head>
    <body id="page6" onload="new ElementMaxHeight();">
        <div id="main">
            <%@include file="header.jsp" %>
            <div id="content">
                <div class="wrapper">
                    <div class="content">
                        <div class="indent">
                            <div id="tabs" align="left">
                                <ul>
                                    <li><a href="#tabs-1">Not a Member?</a></li>
                                    <li><a href="#tabs-2">User</a></li>
                                </ul>
                                <div id="tabs-1">
                                    <form id="register" method="post" action="LoginServlet.jsp?action=addNewUser&returnURL=/login.jsp&nextURL=/index.jsp">
                                        <label>Title* :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                        <select name="title" id="title">
                                            <option value="MR">Mr.</option>
                                            <option value="MRS">Mrs.</option>
                                            <option value="MISS">Miss</option>
                                            <option value="DR">Dr.</option>
                                        </select><br/><br/>
                                        <label>First Name* :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="fname"/><br/><br/>
                                        <label>Last Name* :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="lname"/><br/><br/>
                                        <label>Date of Birth* :&nbsp;</label><input type="date" name="dob"/><br/><br/>
                                        <label>Address Line 1* :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="addressLine1"/><br/><br/>
                                        <label>Address Line 2 :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="addressLine2"/><br/><br/>
                                        <label>City* :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        </label><input type="text" name="city"/><br/><br/>
                                        <label>Province* :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="province"/><br/><br/>
                                        <label>Zip/Postal Code* :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="zip"/><br/><br/>
                                        <label>Country* :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="country"/><br/><br/>
                                        <label>Email* :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="email"/><br/><br/>
                                        <label>Password* :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="password" name="password"/><br/><br/><br/>
                                        <label>Repeat Password* :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="password" name="passwordrepeat"/><br/><br/><br/>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="register" value="Create Account"/><br/>

                                    </form>
                                </div>
                                <div id="tabs-2">
                                    <form id="login" method="post" action="LoginServlet.jsp?action=loginAction&returnURL=/login.jsp&nextURL=/index.jsp">
                                        <label>Email* :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="email"/><br/><br/>
                                        <label>Password* :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="password" name="password"/><br/><br/><br/>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="login" value="Login"/><br/>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <%@include file="footer.jsp" %>
    </div></html>