<%-- 
    Document   : DeleteRoom
    Created on : 10-Apr-2015, 7:04:38 PM
    Author     : Paramjyot
--%>


<%@page import="java.util.List"%>
<%@page import="Entities.TblRoom"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Paradise Hotel</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="stylesheet/style.css" rel="stylesheet" type="text/css" />
<link href="stylesheet/layout.css" rel="stylesheet" type="text/css" />
<style>
   select, input[type=text],input[type=radio]{
        margin-left: 25px;
    }
    
</style>
<script src="scripts/maxheight.js" type="text/javascript"></script>
    </head>
 <body id="page1" onload="new ElementMaxHeight();"> 
     <div id="main">
   <%@include file="adminHeader.jsp" %>
 <!-- content -->
   <div id="content">
    <div class="wrapper">
      <div class="aside maxheight">
            <img class="img-indent png" alt="" src="images/1page-img1.png" />
      </div>
<div class="content">
        <div class="indent">
        <h3>View Room</h3>
      
        <form name="deleteForm" action="AdminOperations.jsp?nextURL=UpdateRoom.jsp&returnURL=ViewRoom.jsp" method="get">

            <input type="text" name="roomNumber" placeholder="Room Number" />
           
            <input type="submit" value="Search" name="search" />

        </form>
        
    </body>
</html>
