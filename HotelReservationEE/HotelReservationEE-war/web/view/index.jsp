<%-- 
    Document   : index
    Created on : 27-Mar-2015, 12:11:44 AM
    Author     : meenakshimehta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Paradise Hotel</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="stylesheet/style.css" rel="stylesheet" type="text/css" />
<link href="stylesheet/layout.css" rel="stylesheet" type="text/css" />
<script src="scripts/maxheight.js" type="text/javascript"></script>
</head>
<body id="page1" onload="new ElementMaxHeight();">
<div id="main">
   <%@include file="header.jsp" %>
 <!-- content -->
   <div id="content">
    <div class="wrapper">
      <div class="aside maxheight">
         <%@include file="bookingSidebar.jsp" %>
      </div>
<div class="content">
        <div class="indent">
          <h2>Paradise is happy to welcome you!</h2>
          <img class="img-indent png" alt="" src="../images/1page-img1.png" />
          <p class="alt-top">Come alone or bring your family with you, stay here for a night or for weeks, stay here while on business trip or at some kind of conference - either way our hotel is the best possible variant.</p>
          Feel free to contact us anytime in case you have any questions or concerns.
          <div class="clear"></div>
          <div class="line-hor"></div>
          <div class="wrapper line-ver">
            <div class="col-1">
              <h3>Special Offers</h3>
              <ul>
                <li>FREE wide-screen TV</li>
                <li>50% Discount for Restaraunt service</li>
                <li>30% Discount for 3 days+ orders</li>
                <li>FREE drinks and beverages in rooms</li>
                <li>Exclusive souvenirs</li>
              </ul>
              <div class="button"><span><span><a href="#">Order Now!</a></span></span></div>
            </div>
            <div class="col-2">
              <h3>Location</h3>
              <p>We are located in the center of Prague surrounded by malls and boutiques.</p>
              <dl class="contacts-list">
                <dt>Gazek st., 210</dt>
                <dd>1-800-412-4556</dd>
                <dd>1-800-542-6448</dd>
              </dl>
            </div>
          </div>
        </div>
      </div>
    </div>
   </div>
    <%@include file="footer.jsp" %>
 </div>
</html>