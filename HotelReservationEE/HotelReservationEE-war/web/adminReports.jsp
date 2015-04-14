<%-- 
    Document   : adminReports
    Created on : 13-Apr-2015, 3:09:41 AM
    Author     : Paramjyot
--%>

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
 
        <h3>Generate Reports</h3>
        
        <h5>Rooms Booked :</h5>
        <form id="frmReports" name="frmReports" action="AdminOperations.jsp?nextURL=index.jsp&returnURL=adminReports.jsp">
                <table>
                    <tr>
                        <td>
                          From
                        </td>
                        <td>
                            <input type="date" name="startdate">
                        </td>
                    </tr>
                    <tr>
                        <td>
                           To:
                        </td>
                        <td>
                            <input type="date" name="enddate">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" name="Generate" Value="Generate" />
                        </td>                       
                    </tr>
                </table>
            
            <table>
                    <tr>
                        <td>
                          Floor:
                        </td>
                        <td>
                            <input type="text" name="floor">
                        </td>
                    </tr>
                    <tr>
                        <td>
                           Status:
                        </td>
                        <td>
                            <select name="status">
                                <option value="VACANT">VACANT</option>
                                <option value="BOOKED">BOOKED</option>
                                <option value="NEEDS CLEANING">NEEDS CLEANING</option>                                
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" name="GenerateStatusReport" Value="Generate" />
                        </td>                       
                    </tr>
                </table>
        
        
        
        
        
        
        </form>
      

    </body>
</html>
