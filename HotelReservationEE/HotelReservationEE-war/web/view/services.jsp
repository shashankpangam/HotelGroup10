<%-- 
    Document   : restaurant
    Created on : 27-Mar-2015, 9:19:06 AM
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
<body id="page4" onload="new ElementMaxHeight();">
    <div id="main">
  <%@include file="header.jsp" %>

<div id="content">
    <div class="wrapper">
      <div class="aside maxheight">
<%@include file="menuSidebar.jsp" %>
      </div>

      <div class="content">
        <div class="indent">
          <h2>Today’s featured menu item</h2>
          <img class="img-indent png alt" alt="" src="../images/4page-img1.png" />
          <div class="extra-wrap">
            <h5>Foie gras!</h5>
            <ul class="list2">
              <li>Nice and tasty!</li>
              <li>Made from French ingredients!</li>
              <li>Cooked by Italian chef!</li>
              <li>Awarded by Czech assosiation of chef!</li>
              <li>Proved to be good for your health!</li>
            </ul>
            <div class="aligncenter"><strong class="txt2">AS LOW AS €19!</strong></div>
          </div>
        </div>
      </div>
      <div class="clear"></div>
</div></div>
 
      <%@include file="footer.jsp" %>
         </div>
</html>