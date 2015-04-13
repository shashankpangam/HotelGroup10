<%-- 
    Document   : rooms
    Created on : 27-Mar-2015, 8:42:44 AM
    Author     : meenakshimehta
--%>

<%@page import="session.RoomBookingBeanRemote"%>
<%@page import="Entities.TblRoom"%>
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
          <div class="container">
        <%  
           List<TblRoom> room=(List<TblRoom>)request.getAttribute("rooms");   
            for(TblRoom r : room){              
                %>      
                 <dl class="list1">
                   <form action="ViewDetails.jsp" method="get">
                   <input type="hidden" name="roomid" value="<%=r.getRoomnumber()%>"/>
                   <dt><%=r.getRoomview()+" "+ "View"%></dt>
                   <dd>Floor :<span> <%=r.getFloor()%></span></dd>
                   <dd>Room Size :<span> <%=r.getRoomsize()%></span></dd>
                   <dd>Beds :<span> <%=r.getNoofbeds() + " " + r.getBedtype()%></span></dd>
                   <input type="submit" name="view" value="Select Room"/>
                   </form>
                   </dl>
                   <br/>
        <% } %>
              <div class="clear"></div>
              </div>
          </div></div></div></div>
           
<%@include file="footer.jsp" %>
   </div>
</html>