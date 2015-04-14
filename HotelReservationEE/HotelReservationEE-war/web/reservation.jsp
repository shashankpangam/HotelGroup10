
<%-- 
    Document   : booking
    Created on : 27-Mar-2015, 9:26:07 AM
    Author     : meenakshimehta
--%>
<%@page import="java.util.List"%>
<%@page import="Entities.TblRoom"%>
<%@page import="Entities.TblBooking"%>
<%@page import="session.RoomBookingBeanRemote"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="Entities.TblServices"%>
<%@page import="javax.naming.Context"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Paradise Hotel</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="stylesheet/style.css" rel="stylesheet" type="text/css" />
        <link href="stylesheet/layout.css" rel="stylesheet" type="text/css" />
        <script src="scripts/maxheight.js" type="text/javascript"></script>
        <style>

        </style>
    </head>
    <body id="page5" onload="new ElementMaxHeight();">
        <div id="main">
            <%@include file="header.jsp" %>

            <div id="content">
                <div class="wrapper">
                    <div class="content" style="width:500px;">


                        <%

                            Context context = new InitialContext();
                            RoomBookingBeanRemote rbb = (RoomBookingBeanRemote) session.getAttribute("mycart");
                            if (rbb == null) {
                                rbb = (RoomBookingBeanRemote) context.lookup(RoomBookingBeanRemote.class.getName());
                                session.setAttribute("mycart", rbb);
                            }
                            float total = 0f;

                        %>

                        <h2>My Reservations</h2>
                        <form action="RoomBooking.jsp">
                            <h6> Room Booking:</h6>
                            <table border="1">
                                <tr>
                                    <th>CheckIn</th>
                                    <th>CheckOut </th>
                                    <th>Persons</th>
                                    <th>Rooms</th>
                                    <th>Room Price</th>
                                </tr>
                                <tr>
                                    <td>

                                        <%  if (session.getAttribute("checkin") != null) {
                                                out.println(session.getAttribute("checkin"));
                                            }
                                        %>
                                    </td>
                                    <td>
                                        <%  if (session.getAttribute("checkout") != null) {
                                                out.println(session.getAttribute("checkout"));
                                            }
                                        %>
                                    </td>

                                    <td>
                                        <%
                                            if (session.getAttribute("person") != null) {
                                                out.println(session.getAttribute("person"));
                                            }
                                        %>
                                    </td>

                                    <%
                                        List<TblRoom> roomList = (List<TblRoom>) rbb.getContents();
                                        for (TblRoom x : roomList) {
                                    %>
                                    <td>
                                        <%
                                                out.println("<input type='hidden' name='roomid' value='" + x.getRoomnumber() + "'/>");
                                                total = total + x.getPrice();

                                                out.println(x.getRoomnumber() + "</td><td>");
                                                out.println("$" + x.getPrice());
                                            }

                                        %>
                                    </td>   
                                    <td> <input type="submit" name="action" value="Delete Room"/></td>
                                </tr>
                            </table><br/><br/>
                            <h6> Services Selected:</h6>
                            <table border="1">
                                <tr>
                                    <th>Services</th>
                                    <th>Service Price</th>
                                </tr>

                                <%                                      List<TblServices> serviceList = (List<TblServices>) rbb.getServices();
                                    for (TblServices x : serviceList) {
                                %>
                                <tr><td>
                                        <%
                                                out.println("<input type='hidden' name='serviceid' value='" + x.getServiceid() + "'/>");
                                                total = total + x.getPrice();
                                                out.println(x.getName().toLowerCase() + "</td><td>");
                                                out.println("$" + x.getPrice());
                                            }


                                        %>
                                    </td>

                                    <td>  <input type="submit" name="action" value="Delete Service"/></td>


                                </tr>
                            </table><br/><br/>
                            <div>

                                <h6>Total Bill :  

                                    <%    out.println("$" + total);
                                    %>
                                </h6>
                                <br/><br/>
                                <input type="submit" name="action" value="Cancel Booking"/>
                                <input type="submit" name="action" value="Confirm Booking"/>


                            </div>
                        </form>

                    </div></div></div>



            <div class="clear"></div>
        </div>

        <%@include file="footer.jsp" %>

    </body></html>