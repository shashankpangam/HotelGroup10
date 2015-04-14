<%-- 
    Document   : viewReport
    Created on : 13-Apr-2015, 3:34:10 PM
    Author     : Paramjyot
--%>

<%@page import="Entities.TblBooking"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    List<TblBooking> report = (List<TblBooking>)(request.getAttribute("report")); %>
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
        <h3>Report</h3>
        <table>
            <tr>
                <td>  <th>Room Number</th> </td><td><th>Number of People</th></td><td> <th>CheckOut Date</th></td></tr>
            <tr> 
               <% for(int i=0; i<report.size(); i++){%>                                                
               <td> <%out.println(report.get(i).getRoomnumber());%></td>
               <td> <%out.println(report.get(i).getNoofpeople());%></td>
               <td><%out.println(report.get(i).getDateto());%></td>        
                </tr>
<%
               }
%>     
       
                
            
        </table>
       
    </body>
</html>
