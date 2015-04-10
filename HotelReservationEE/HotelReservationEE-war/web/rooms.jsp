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
<%@include file="roomsSidebar.jsp" %>
      </div>
     
       <div class="content">
           <div class="indent">
          <h2>We offer several kinds of rooms views</h2>
          <div class="container">
              <form action="ViewDetails">
              <div class="col-1">
                  <h4>City View</h4><br/>
              <img alt="" src="images/city.jpeg" width="180" height="150"/>
              <!--<dl class="list1">
                <dt>City View</dt>
                <dd>Omnis iste natus error sit volupta- tem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi.</dd>
                <dd><span>6-10</span>Floor</dd>
                <dd><span>1</span>Rooms</dd>
                <dd><span>1</span>Beds</dd>
                <dd class="alt"><span>1</span>Baths</dd>
                <dd class="last"><span>$49</span>Price:</dd>
              </dl>-->
                         
                  <input type="submit" name="view" value="City View"/>
              </div>
                  <div class="col-2">
                       <h4>Ocean View</h4><br/>
                      <img alt="" src="images/ocean.jpg" width="180" height="150"/>
              <!--<dl class="list1">
                <dt>Ocean View</dt>
                <dd>Omnis iste natus error sit volupta- tem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi.</dd>
                <dd><span>3-5</span>Floor</dd>
                <dd><span>2</span>Rooms</dd>
                <dd><span>2</span>Beds</dd>
                <dd class="alt"><span>1</span>Baths</dd>
                <dd class="last"><span>$99</span>Price:</dd>
              </dl>-->
              <div class="button"><span><span>  
                          <input type="submit" name="view" value="Ocean View"/></span></span></div>
                  </div>
            <div class="col-3"> 
                 <h4>Mountain View</h4><br/>
                <img alt="" src="images/mountain.jpg" width="180" height="150"/>
             <!-- <dl class="list1">
                <dt>Mountain View</dt>
                <dd>Omnis iste natus error sit volupta- tem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi.</dd>
                <dd><span>1-2</span>Floor</dd>
                <dd><span>3</span>Rooms</dd>
                <dd><span>3</span>Beds</dd>
                <dd class="alt"><span>2</span>Baths</dd>
                <dd class="last"><span>$199</span>Price:</dd>
              </dl>-->
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