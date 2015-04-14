<%-- 
    Document   : menuSidebar
    Created on : 27-Mar-2015, 9:18:10 AM
    Author     : meenakshimehta
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Entities.TblServices"%>
<%@page import="session.RoomBookingBeanRemote"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.util.List"%>
<%@page import="Entities.TblRoom"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="box maxheight">
    <%
       
                        Context context = new InitialContext();
                        RoomBookingBeanRemote rbb = (RoomBookingBeanRemote) session.getAttribute("mycart");
                        if (rbb == null) {
                            rbb = (RoomBookingBeanRemote) context.lookup(RoomBookingBeanRemote.class.getName());
                            session.setAttribute("mycart", rbb);
                        }

     
           
           %>
    <div class="inner">
        <h3>Reservation Details</h3>
        <ul class="list4" >
            <li><h5>CheckIn Date<br/>
               <%  if (session.getAttribute("checkin") != null) {
                         out.println(session.getAttribute("checkin"));
                        }
                %>
                </h5></li>
            <li><h5>CheckOut Date <br/>
                
                  <%  if (session.getAttribute("checkout") != null) {
                         out.println(session.getAttribute("checkout"));
                        }
                %>
                </h5></li>
            <li><h5>Number of Persons<br/> 
                   <%
                        if (session.getAttribute("person") != null) {
                            out.println(session.getAttribute("person"));
                        }
                    %>
                </h5></li>
            <li><h5>Room Selected <br/>
                      <%
                                    List<TblRoom> roomList = (List<TblRoom>) rbb.getContents();
                                    for (TblRoom x : roomList) {
                                   
                                                out.println(x.getRoomnumber());                                         
                                            }
 
                                    %>
                </h5></li>
            <li><h5>Services Included<br/>
                    <%
                          List<TblServices> serviceList = (List<TblServices>) rbb.getServices();
                                    for (TblServices x : serviceList) {
                                             out.println(x.getName().toLowerCase());                                        
                                            }                     
                 
                    %>


                </h5></li>
        </ul>
    </div>
</div>
