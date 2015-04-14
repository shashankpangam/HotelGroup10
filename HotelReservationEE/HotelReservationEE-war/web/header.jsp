<%-- 
    Document   : Hotel_Header
r-2015, 11:53:09 PM
    Author     : meenakshimehta
--%>

  <!-- header -->
  <div id="header">
    <div class="row-1">
      <div class="wrapper">
        <div class="logo">
          <h1><a href="#">Paradise</a></h1>
          <em>Hotel</em> <strong>True Luxury</strong></div>
          <div class="phones"><h4>Welcome &nbsp;
              <%
                    if (session.getAttribute("LoggedIn") != null) {
                    %>
                    <%= session.getAttribute("sessionFname")%>
                    &nbsp; | &nbsp; <a href="LoginServlet.jsp?next=logout" >Logout</a> |  <a href="myaccount.jsp">MyAccount</a>

                <%
                } else {
                %>
                <a href="LoginServlet.jsp?action=addNewUser&returnURL=/login.jsp&nextURL=/index.jsp">Log in</a> &nbsp; | &nbsp; <a href="LoginServlet.jsp?action=Register&returnURL=/View/register.jsp">Register</a>
                <%
                    }
                %>
              
       </div>
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
     


