<%-- 
    Document   : restaurant
    Created on : 27-Mar-2015, 9:19:06 AM
    Author     : meenakshimehta
--%>

<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="session.OperationsRemote"%>
<%@page import="javax.naming.Context"%>
<%@page import="Entities.TblServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Paradise Hotel</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="stylesheet/style.css" rel="stylesheet" type="text/css" />
<link href="stylesheet/layout.css" rel="stylesheet" type="text/css" />
<script src="scripts/maxheight.js" type="text/javascript"></script>
</head>
<body id="page4" onload="new ElementMaxHeight();">
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
  <%  
            Context ctx = new InitialContext();
           OperationsRemote roomSession = (OperationsRemote) ctx.lookup(OperationsRemote.class.getName());
           List<TblServices>  service = (List<TblServices>) roomSession.getAllServices();             
                %>  
      <div class="content">
      <form action="RoomBooking.jsp" method="post">
          <div class="indent">
            
          <div class="extra-wrap">
              <img class="img-indent png alt" alt="" src="images/wifi.jpg" height="80" width="90"/>
            <h5>Free Standard WI-FI</h5>
            <div class="right" style="float:right; font-size: 50px;">
                 <input type="hidden" name="serviceid" value="<%=service.get(0).getServiceid()%>"/>
                <input type="checkbox" name="wifi" value="<%=service.get(0).getServiceid()%>"/></div>
            <ul class="list2">
                <li>Whether you need to check emails, surf the web or chat, we know how important<br/> mobile freedom is for you.So, we offer FREE OF CHARGE internet access in entire hotel</li>
            </ul>
           
          </div>
             <div class="extra-wrap">
              <img class="img-indent png alt" alt="" src="images/aircondtion.jpg" height="80" width="90"/>
            <h5>Air Conditioning</h5>
            <div class="right" style="float:right">
                <input type="hidden" name="serviceid" value="<%=service.get(1).getServiceid()%>"/>
                <input type="checkbox" name="aircondition" value="<%=service.get(1).getServiceid()%>"/></div>
            <ul class="list2">
                <li> From the lobby to restaurants, kitchen and bar, and from conference and meeting<br/> rooms to the spa, We provide ventilation and air conditioning</li>
            </ul>
           
          </div>
          </div>
            <div class="extra-wrap">
              <img class="img-indent png alt" alt="" src="images/bfast.jpg" height="80" width="90"/>
            <h5>Breakfast</h5>
            <div class="right" style="float:right"> 
                <input type="hidden" name="serviceid" value="<%=service.get(3).getServiceid()%>"/>
                <input type="checkbox" name="breakfast" value="<%=service.get(3).getServiceid()%>"/></div>
            <ul class="list2">
              <li>Healthy vitamin packed Breakfast buffet in the Bow Valley Grill for Two Adults.<br/>Purchase and save 25%</li>
            </ul>
           
          </div>
            <div class="extra-wrap">
              <img class="img-indent png alt" alt="" src="images/crib.jpg" height="80" width="90"/>
            <h5>Crib</h5>
               <div class="right" style="float:right">
                   <input type="hidden" name="serviceid" value="<%=service.get(4).getServiceid()%>"/>
                   <input type="checkbox" name="crib" value="<%=service.get(4).getServiceid()%>"/></div>
            <ul class="list2">
                <li>For parents traveling with little ones, Paradise has got you covered. We provide<br/> special services for the Kids here</li>
            </ul>
         
          </div>
        </div>
           <input type="submit" name="action" value="Add"/>
          <input type="submit" name="action" value="Proceed"/>
  </form>
      </div>
      <div class="clear"></div>
</div></div>
 
      <%@include file="footer.jsp" %>
         </div>
</body>
</html>