
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="Entities.TblServices"%>
<%@page import="Entities.TblRoom"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="session.OperationsRemote"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="Entities.TblBooking"%>
<%-- 
    Document   : booking
    Created on : 27-Mar-2015, 9:26:07 AM
    Author     : meenakshimehta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Paradise Hotel</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="stylesheet/style.css" rel="stylesheet" type="text/css" />
        <link href="stylesheet/layout.css" rel="stylesheet" type="text/css" />
        <script src="scripts/maxheight.js" type="text/javascript"></script>
    </head>
    <body id="page5" onload="new ElementMaxHeight();">
        <div id="main">
            <%@include file="header.jsp" %>
            <%                List<TblBooking> myBookings = (List<TblBooking>) session.getAttribute("myBookings");
                OperationsRemote or = (OperationsRemote) session.getAttribute("or");
                if (or == null) {
                    Context ctx = new InitialContext();
                    or = (OperationsRemote) ctx.lookup(OperationsRemote.class.getName());
                    session.setAttribute("or", or);
                }
            %>
            <div id="content">
                <div class="wrapper">
                    <!--<div class="aside maxheight">

                    </div>-->

                    <div class="myaccount">
                        <h2>My Account</h2>
                        <div class="indent">
                            <form method="post" action="LoginServlet.jsp?action=Delete&returnURL=/myaccount.jsp&nextURL=/myaccount.jsp">
                                <table border="1">
                                    <tr>
                                        <th>Rooms</th>
                                        <th>Services</th>
                                        <th>No Of People</th>
                                        <th>Date From</th>
                                        <th>Date to</th>
                                        <th>Status</th>
                                        <th>Total</th>
                                    </tr>
                                    <%
                                        SimpleDateFormat myformat = new SimpleDateFormat("EEE, dd MMM, YYYY");
                                        for (TblBooking booking : myBookings) {
                                            out.println("<tr>");
                                            String rooms = booking.getRoomnumber().trim();
                                            String services = booking.getServices().trim();
                                            List<String> roomsById = Arrays.asList(rooms.split(" "));
                                            List<String> servicesById = Arrays.asList(services.split(" "));
                                            out.println("<td>");
                                            for (int i = 0; i < roomsById.size(); i++) {
                                                TblRoom room = (TblRoom) or.getRoomByID(Integer.parseInt(roomsById.get(i)));
                                                out.println("<a href='LoginServlet.jsp?action=currentRoom&nextURL=/currentRoom.jsp&roomid=" + room.getRoomnumber() + "'>" + room.getRoomnumber() + " - " + room.getRoomview() + "</a>");
                                            }
                                            out.println("</td><td>");
                                            for (int i = 0; i < servicesById.size(); i++) {
                                                TblServices service = (TblServices) or.getServiceByID(Integer.parseInt(servicesById.get(i)));
                                                out.println(service.getName());
                                            }
                                            
                                            out.println("</td><td>");
                                            out.println(booking.getNoofpeople());
                                            out.println("</td><td>");
                                            out.println(myformat.format(booking.getDatefrom()));
                                            out.println("</td><td>");
                                            out.println(myformat.format(booking.getDateto()));
                                            out.println("</td><td>");
                                            out.println(booking.getStatus());
                                            out.println("</td><td>");
                                            out.println(booking.getTotal());
                                            out.println("</td><td><input type='submit' name='submit' value='Delete'/><input type='hidden' name='bookingid' value='"+booking.getBookingid()+"'/></td>");
                                            out.println("<tr>");
                                        }
                                    %>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>

            <%@include file="footer.jsp" %>
        </div>
    </body></html>