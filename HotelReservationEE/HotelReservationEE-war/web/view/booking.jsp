
<%-- 
    Document   : booking
    Created on : 27-Mar-2015, 9:26:07 AM
    Author     : meenakshimehta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Paradise Hotel</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../stylesheet/style.css" rel="stylesheet" type="text/css" />
<link href="../stylesheet/layout.css" rel="stylesheet" type="text/css" />
<script src="../scripts/maxheight.js" type="text/javascript"></script>
</head>
<body id="page5" onload="new ElementMaxHeight();">
    <div id="main">
  <%@include file="header.jsp" %>

<div id="content">
    <div class="wrapper">
      <div class="aside maxheight">
<%@include file="bookingSidebar.jsp" %>
      </div>

 <div class="content">
        <div class="indent">
          <h2>Our location</h2>
          <img class="img-indent png" alt="" src="../images/5page-img1.png" />
          <div class="extra-wrap">
            <p class="alt-top">Our hotel is located in the most spectacular part of Prague - surrounded by boutiques, restaurants and luxurious shops.</p>
            <p>Please feel free to come visit us at the following adress:</p>
            <dl class="contacts-list">
              <dt>Gazek st., 210</dt>
              <dd>1-800-412-4556</dd>
              <dd>1-800-542-6448</dd>
            </dl>
          </div>
          
        </div>
      </div>
    </div>
      <div class="clear"></div>
  </div>

<%@include file="footer.jsp" %>
    </div></html>