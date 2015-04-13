package servlet;

import Entities.TblServices;
import Entities.TblRoom;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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

            String action = request.getParameter("action");
            String wifi = request.getParameter("wifi");
            String aircondition = request.getParameter("aircondition");
            String connectingroom = request.getParameter("connectingroom");
            String breakfast = request.getParameter("breakfast");
            String crib = request.getParameter("crib");

            Context ctx = new InitialContext();
            HttpSession session = request.getSession();
            OperationsRemote roomSession = (OperationsRemote) ctx.lookup(OperationsRemote.class.getName());
            ServletContext sc = getServletConfig().getServletContext();
            
            if (action.equals("Book Now")) {
                int roomid = Integer.parseInt(request.getParameter("roomid"));
                TblRoom room = (TblRoom) roomSession.getRoomByID(roomid);
                mycart = (RoomBookingBeanRemote) session.getAttribute("mycart");
                if (mycart == null) {
                    mycart = (RoomBookingBeanRemote) ctx.lookup(RoomBookingBeanRemote.class.getName());
                    session.setAttribute("mycart", mycart);
                }
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

            if (action.equals("Proceed")) {
                int id = Integer.parseInt(request.getParameter("serviceid"));
                TblServices service;
                mycart = (RoomBookingBeanRemote) session.getAttribute("mycart");
                if (mycart == null) {
                    RoomBookingBeanRemote mycart = (RoomBookingBeanRemote) ctx.lookup(RoomBookingBeanRemote.class.getName());
                    session.setAttribute("mycart", mycart);
                }
                boolean flag = true;
                if (wifi != null) {
                    service = (TblServices) roomSession.getServiceByID(Integer.parseInt(wifi));
                  
                   flag = mycart.addService(service);
                } else if (aircondition != null) {
                    service = (TblServices) roomSession.getServiceByID(Integer.parseInt(aircondition));
                    flag = mycart.addService(service);
                } else if (breakfast != null) {
                    service = (TblServices) roomSession.getServiceByID(Integer.parseInt(breakfast));
                    flag = mycart.addService(service);
                } else if (crib != null) {
                    service = (TblServices) roomSession.getServiceByID(Integer.parseInt(crib));
                    flag = mycart.addService(service);
                }
                if (flag) {
                    RequestDispatcher rd = sc.getRequestDispatcher("/services.jsp");
                    ArrayList<TblServices> services = (ArrayList<TblServices>) mycart.getServices();
                    session.setAttribute("service", services);
                    rd.include(request, response);
                } else {
                    RequestDispatcher rd = sc.getRequestDispatcher("/services.jsp");
                     rd.include(request, response);
                }
            }

            if (action.equals("Check Availability")) {
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
