package servlet;

import Entities.TblServices;
import Entities.TblRoom;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.OperationsRemote;
import session.RoomBookingBeanRemote;

/**
 *
 * @author meenakshimehta
 */
public class RoomBooking extends HttpServlet {

    private RoomBookingBeanRemote mycart;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
             Context ctx = new InitialContext();
            HttpSession session = request.getSession();
            OperationsRemote roomSession = (OperationsRemote) ctx.lookup(OperationsRemote.class.getName());
            ServletContext sc = getServletConfig().getServletContext();
             mycart = (RoomBookingBeanRemote) session.getAttribute("mycart");
                if (mycart == null) {
                    mycart = (RoomBookingBeanRemote) ctx.lookup(RoomBookingBeanRemote.class.getName());
                    session.setAttribute("mycart", mycart);
                }
            String submit = request.getParameter("action");
              switch (submit) {
                case "Book Now":
                   {
                int roomid = Integer.parseInt(request.getParameter("roomid"));
                TblRoom room = (TblRoom) roomSession.getRoomByID(roomid);
               
                boolean flag;
                flag = mycart.addRoom(room);
                if (flag) {
                    RequestDispatcher rd = sc.getRequestDispatcher("/services.jsp");
                    session.setAttribute("roomno", room.getRoomnumber());
                    rd.include(request, response);
                } else {
                    out.println("Error Occured, Please try again later! :)");
                }

            }
                case "Add":
                  {        
                TblServices service;
                boolean flag = true;
                if (request.getParameter("wifi") != null) {
                    service = (TblServices) roomSession.getServiceByID(Integer.parseInt(request.getParameter("wifi")));
                  
                   flag = mycart.addService(service);
                } else if (request.getParameter("aircondition") != null) {
                    service = (TblServices) roomSession.getServiceByID(Integer.parseInt(request.getParameter("aircondition") ));
                    flag = mycart.addService(service);
                } else if (request.getParameter("breakfast") != null) {
                    service = (TblServices) roomSession.getServiceByID(Integer.parseInt(request.getParameter("breakfast")));
                    flag = mycart.addService(service);
                } else if (request.getParameter("crib") != null) {
                    service = (TblServices) roomSession.getServiceByID(Integer.parseInt(request.getParameter("crib")));
                    flag = mycart.addService(service);
                }
                if (flag) {
                    RequestDispatcher rd = sc.getRequestDispatcher("/services.jsp");
                    ArrayList<TblServices> services = (ArrayList<TblServices>) mycart.getServices();
                    session.setAttribute("service", services);
                    rd.forward(request, response);
                }
                 RequestDispatcher rd = sc.getRequestDispatcher("/services.jsp");
                     rd.include(request, response);
                     break;
            }    
                case "Proceed":
                {
               
                    RequestDispatcher rd = sc.getRequestDispatcher("/reservation.jsp");
                    session.setAttribute("mycart", mycart);
                    rd.forward(request, response);
                    break;
                  
              }
                case "Check Availability":
             {
                String checkin = request.getParameter("checkIndate");
                String checkout = request.getParameter("checkOutdate");
                String person = request.getParameter("person");
                String isAvailability="true";
                RequestDispatcher rd = sc.getRequestDispatcher("/rooms.jsp");
                session.setAttribute("checkin", checkin);
                session.setAttribute("checkout", checkout);
                session.setAttribute("person", person);
                session.setAttribute("isAvailability", isAvailability);
                rd.forward(request, response);
                break;

            }
                case "Cancel Booking":
                {
                    mycart.clearCart();
                    session.invalidate();
                    RequestDispatcher rd = sc.getRequestDispatcher("/reservation.jsp");
                    rd.forward(request, response);   
                    break;
                }
                case "Delete Room":
                {
                    int roomid = Integer.parseInt(request.getParameter("roomid"));
                    TblRoom room = (TblRoom) roomSession.getRoomByID(roomid);
                    boolean flag;
                    flag = mycart.removeRoom(room);
                    if (flag) {
                    RequestDispatcher rd = sc.getRequestDispatcher("/reservation.jsp");
                    rd.include(request, response);
                 
                }
                   break;
                    
                }
                case "Delete Service":
                {
                    int serviceid = Integer.parseInt(request.getParameter("serviceid"));
                    TblServices service = (TblServices) roomSession.getServiceByID(serviceid);
                    boolean flag;
                    flag = mycart.removeService(service);
                    if (flag) {
                    RequestDispatcher rd = sc.getRequestDispatcher("/reservation.jsp");
                    rd.include(request, response);
                  
                    
                }
                      break;
                }
                
                    
              }

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(RoomBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(RoomBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
