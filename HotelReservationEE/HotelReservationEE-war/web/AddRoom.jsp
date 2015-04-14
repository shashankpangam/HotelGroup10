<%-- 
    Document   : adminHome
    Created on : 29-Mar-2015, 4:48:40 PM
    Author     : Paramjyot
--%>

<%@page import="session.OperationsRemote"%>
<%@page import="Entities.TblRoom"%>

<%@page import="javax.naming.InitialContext"%>
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
       <% 
        InitialContext ic = new InitialContext();
        Object o = ic.lookup(OperationsRemote.class.getName());
        OperationsRemote roomSession = (OperationsRemote) o;

        %>
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
 
 <!-- content -->        
              <h3> OPERATIONS ON ROOM DATABASE </h3>
                 
              <form id="form1" name="form1" action="AdminOperations.jsp?nextURL=index.jsp&returnURL=AddRoom.jsp">
                <table>
                    <tr>
                        <td>
                           Room Number:
                        </td>
                        <td>
                            <input type="text" name="roomNumber">
                        </td>
                    </tr>
                    <tr>
                        <td>
                           Room Floor:
                        </td>
                        <td>
                            <input type="text" name="roomFloor">
                        </td>
                    </tr>
                    <tr>
                        <td>
                           Room Size:
                        </td>
                        <td>
                            <input type="text" name="roomSize">
                        </td>
                    </tr>
                    <tr>
                        <td>
                           Room View:
                        </td>
                        <td>
                            <select name="roomView">
                                <option value="CITY">CITY</option>
                                <option value="OCEAN">OCEAN</option>
                                <option value="MOUNTAIN">MOUNTAIN</option>                                
                            </select>
                        </td>
                    </tr>
                       <tr>
                        <td>
                           Bed Type:
                        </td>
                           <td>
                         <select name="bedType">
                                <option value="KING">KING</option>
                                <option value="QUEEN">QUEEN</option>
                                <option value="DOUBLE">DOUBLE</option>                                
                            </select>
                       </td>
                    </tr>
                    <tr>
                        <tr>
                        <td>
                           Bed Count:
                        </td>
                        <td>
                            <input type="text" name="bedCount">
                        </td>
                    </tr>
                  
                   
                    <tr>
                        <td>
                           Price:
                        </td>
                        <td>
                            <input type="text" name="price">
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
                           Capacity
                        </td>
                        <td>
                            <input type="text" name="capacity">
                        </td>
                    </tr>
                         <tr>  
                           <td>
                           Smoking:
                        </td>   
                        <td>
                           <input type="radio" name="smoking" value="Smoking">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" name="Add" Value="Add" />
                        </td>                       
                    </tr>
                </table>
            </form>
        </div>
</div>
   
</html>
