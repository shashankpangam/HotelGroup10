<%-- 
    Document   : Hotel_Header
r-2015, 11:53:09 PM
    Author     : meenakshimehta
--%>

<%@page import="Entities.TblLogin"%>
<%@page import="Entities.TblCustomer"%>
<!-- header -->
<div id="header">
    <div class="row-1">
        <div class="wrapper">
            <div class="logo">
                <h1><a href="#">Paradise</a></h1>
                <em>Hotel</em> <strong>True Luxury</strong></div>

            <div class="phones"><h4>Welcome &nbsp; <%
                if (session.getAttribute("LoggedIn") != null) {
                    TblLogin loggedInUser = (TblLogin) session.getAttribute("LoggedIn");
                    TblCustomer customer = (TblCustomer) session.getAttribute("customerDetails");
                    out.println(customer.getFname());
                    %>
                    <input type="hidden" name="customerid" value="<%=customer.getCustomerid()%>"/>
                    <a href="LoginServlet.jsp?action=Logout&nextURL=/index.jsp">Log Out</a> | <a href="LoginServlet.jsp?action=myAccount&nextURL=/myaccount.jsp">My Account</a><%
                    } else {%>
                    <a href="login.jsp#tabs-1">Login</a> | <a href="login.jsp#tabs-2">Register</a><%
                        }
                    %>
                </h4></div>
        </div>
    </div>
    <div class="row-2">
        <div class="indent">
            <!-- header-box begin -->
            <div class="header-box">
                <div class="inner">
                    <ul class="nav">
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="rooms.jsp">Rooms</a></li>
                        <li><a href="gallery.jsp">Gallery</a></li>
                        <li><a href="services.jsp">Services</a></li>
                        <li><a href="reservation.jsp">Reservation</a></li>
                        <li><a href="contact.jsp">Contact Us</a></li>             
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>



