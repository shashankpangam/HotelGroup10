<%-- 
    Document   : services
    Created on : 27-Mar-2015, 8:42:44 AM
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
<body id="page2" onload="new ElementMaxHeight();">
    <div id="main">
  <%@include file="header.jsp" %>


<div id="content">
    <div class="wrapper">
      <div class="aside maxheight">
<%@include file="servicesSidebar.jsp" %>
      </div>
       <div class="content">
        <div class="indent">
          <h2>We offer several kinds of rooms</h2>
          <div class="container">
            <div class="col-1"> <img alt="" src="../images/2page-img11.png" class="extra-img png"/>
              <dl class="list1">
                <dt>Discounted Rooms</dt>
                <dd>Omnis iste natus error sit volupta- tem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi.</dd>
                <dd><span>6-10</span>Floor</dd>
                <dd><span>1</span>Rooms</dd>
                <dd><span>1</span>Beds</dd>
                <dd class="alt"><span>1</span>Baths</dd>
                <dd class="last"><span>$49</span>Price:</dd>
              </dl>
              <div class="button"><span><span><a href="#">Order Now!</a></span></span></div>
            </div>
            <div class="col-2"> <img alt="" src="../images/2page-img12.png" class="extra-img png"/>
              <dl class="list1">
                <dt>Business Class Rooms</dt>
                <dd>Omnis iste natus error sit volupta- tem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi.</dd>
                <dd><span>3-5</span>Floor</dd>
                <dd><span>2</span>Rooms</dd>
                <dd><span>2</span>Beds</dd>
                <dd class="alt"><span>1</span>Baths</dd>
                <dd class="last"><span>$99</span>Price:</dd>
              </dl>
              <div class="button"><span><span><a href="#">Order Now!</a></span></span></div>
            </div>
            <div class="col-3"> <img alt="" src="../images/2page-img13.png" class="extra-img png"/>
              <dl class="list1">
                <dt>Premium Rooms</dt>
                <dd>Omnis iste natus error sit volupta- tem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi.</dd>
                <dd><span>1-2</span>Floor</dd>
                <dd><span>3</span>Rooms</dd>
                <dd><span>3</span>Beds</dd>
                <dd class="alt"><span>2</span>Baths</dd>
                <dd class="last"><span>$199</span>Price:</dd>
              </dl>
              <div class="button"><span><span><a href="#">Order Now!</a></span></span></div>
            </div>
              <div class="clear"></div>
              
          </div></div></div></div></div>
           
 
<%@include file="footer.jsp" %>
   </div>
</html>