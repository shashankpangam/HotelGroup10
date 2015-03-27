<%-- 
    Document   : gallery
    Created on : 27-Mar-2015, 9:04:55 AM
    Author     : meenakshimehta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Paradise Hotel</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../stylesheet/style.css" rel="stylesheet" type="text/css" />
<link href="../stylesheet/layout.css" rel="stylesheet" type="text/css" />
<script src="../scripts/maxheight.js" type="text/javascript"></script>
</head>
<body id="page3" onload="new ElementMaxHeight();">
    <div id="main">
  <%@include file="header.jsp" %>
 
<div id="content">
    <div class="gallery">
      <ul>
        <li><a href="#"><img alt="" src="../images/2page-img1.jpg" /></a></li>
        <li><a href="#"><img alt="" src="../images/2page-img2.jpg" /></a></li>
        <li><a href="#"><img alt="" src="../images/2page-img3.jpg" /></a></li>
        <li><a href="#"><img alt="" src="../images/2page-img4.jpg" /></a></li>
        <li><a href="#"><img alt="" src="../images/2page-img5.jpg" /></a></li>
        <li><a href="#"><img alt="" src="../images/2page-img6.jpg" /></a></li>
      </ul>
    </div>
    <div class="container">
      <div class="aside maxheight">
<%@include file="gallerySidebar.jsp" %>
      </div>
 <div class="content">
        <div class="indent">
          <h2>Hotel’s picture gallery</h2>
          <div class="gallery-main png">
            <div class="inner"> <img alt="" src="../images/3page-img13.jpg" />
              <div class="prev"><a href="#"><img alt="" src="../images/prev.png" class="png" /></a></div>
              <div class="next"><a href="#"><img alt="" src="../images/next.png" class="png" /></a></div>
            </div>
          </div>
        </div>
      </div>
      <div class="clear"></div>
    </div></div>
<%@include file="footer.jsp" %>
    </div></html>