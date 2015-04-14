<%-- 
    Document   : adminHeader
    Created on : 13-Apr-2015, 6:10:33 PM
    Author     : Paramjyot
--%>

<%@page import="Entities.TblCustomer"%>
<%@page import="Entities.TblLogin"%>
<!-- header -->
  <div id="header">
    <div class="row-1">
      <div class="wrapper">
        <div class="logo">
          <h1><a href="#">Paradise</a></h1>
          <em>Hotel</em> <strong>True Luxury</strong></div>
          <div class="phones">Welcome &nbsp;<%
                if (session.getAttribute("LoggedIn") != null) {
                    TblLogin loggedInUser = (TblLogin) session.getAttribute("LoggedIn");
                    TblCustomer customer = (TblCustomer) session.getAttribute("customerDetails");
                    out.println(customer.getFname());
      }else {out.println("ADMIN");}%> | <a href="myaccount.jsp">My Account</a><br />
         </div>
      </div>
    </div>
    <div class="row-2">
      <div class="indent">
        <!-- header-box begin -->
        <div class="header-box">
          <div class="inner">
            <ul class="nav">
              <li><a href="AddRoom.jsp">Add</a></li>
              <li><a href="ViewRoom.jsp">Update</a></li>
              <li><a href="adminReports.jsp">Reports</a></li>          
            </ul>
          </div>
        </div>
      </div>
    </div>
      </div>
     


