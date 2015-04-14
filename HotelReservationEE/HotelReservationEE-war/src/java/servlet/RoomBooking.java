package servlet;

import Entities.TblBooking;
import Entities.TblCustomer;
import Entities.TblLogin;
import Entities.TblServices;
import Entities.TblRoom;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import session.UserOperationsRemote;

/**
 *
 * @author meenakshimehta
 */
public class RoomBooking extends HttpServlet {

    private RoomBookingBeanRemote mycart;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-DD");
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
                case "Book Now": {
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
                case "Add": {
                    TblServices service;
                    boolean flag = true;
                    if (request.getParameter("wifi") != null) {
                        service = (TblServices) roomSession.getServiceByID(Integer.parseInt(request.getParameter("wifi")));

                        flag = mycart.addService(service);
                    } else if (request.getParameter("aircondition") != null) {
                        service = (TblServices) roomSession.getServiceByID(Integer.parseInt(request.getParameter("aircondition")));
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
                case "Proceed": {

                    RequestDispatcher rd = sc.getRequestDispatcher("/reservation.jsp");
                    session.setAttribute("mycart", mycart);
                    rd.forward(request, response);
                    break;

                }
                case "Check Availability": {
                    String checkin = request.getParameter("checkIndate");
                    String checkout = request.getParameter("checkOutdate");
                    String person = request.getParameter("person");
                    String isAvailability = "true";
                    RequestDispatcher rd = sc.getRequestDispatcher("/rooms.jsp");
                    session.setAttribute("checkin", checkin);
                    session.setAttribute("checkout", checkout);
                    session.setAttribute("person", person);
                    session.setAttribute("isAvailability", isAvailability);
                    rd.forward(request, response);
                    break;

                }
                case "Cancel Booking": {
                    mycart.clearCart();
                    session.invalidate();
                    RequestDispatcher rd = sc.getRequestDispatcher("/reservation.jsp");
                    rd.forward(request, response);
                    break;
                }
                case "Delete Room": {
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
                case "Delete Service": {
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
                case "Confirm Booking": {
                    if (session.getAttribute("LoggedIn") == null) {
                        RequestDispatcher rd = sc.getRequestDispatcher("/login.jsp?action=confirm");
                        rd.forward(request, response);
                    } else {
                        Date dateIn = new Date();
                        Date dateOut = new Date();
                        short s = 0;
                        List<TblRoom> selectedRooms = null;
                        List<TblServices> selectedServices = null;
                        String rooms = "", services = "";
                        float total = 0f;
                        if (session.getAttribute("checkin") != null) {
                            dateIn = format.parse(session.getAttribute("checkin").toString());
                        }
                        if (session.getAttribute("checkout") != null) {
                            dateOut = format.parse(session.getAttribute("checkout").toString());
                        }
                        if (session.getAttribute("person") != null) {
                            s = Short.parseShort((String) session.getAttribute("person"));
                        }
                        if (session.getAttribute("selectedRooms") != null) {
                            selectedRooms = (List<TblRoom>) session.getAttribute("selectedRooms");
                        }
                        if (session.getAttribute("selectedServices") != null) {
                            selectedServices = (List<TblServices>) session.getAttribute("selectedServices");
                        }
                        if (session.getAttribute("total") != null) {
                            total = (float) session.getAttribute("total");
                        }
                        for (TblRoom r : selectedRooms) {
                            rooms = rooms + " " + r.getRoomnumber();
                        }
                        for (TblServices sr : selectedServices) {
                            services = services + " " + sr.getServiceid();
                        }
                        String specialRequest = request.getParameter("specialRequest");
                        TblLogin loggedInUser = (TblLogin) session.getAttribute("LoggedIn");
                        TblCustomer customer = (TblCustomer) session.getAttribute("customerDetails");
                        TblBooking newBooking = new TblBooking();
                        newBooking.setCustomerid(customer);
                        newBooking.setDatefrom(dateIn);
                        newBooking.setDateto(dateOut);
                        newBooking.setNoofpeople(s);
                        newBooking.setRoomnumber(rooms);
                        newBooking.setServices(services);
                        newBooking.setStatus("BOOKED");
                        newBooking.setTotal(total);
                        newBooking.setRequest(specialRequest);
                        boolean flag = mycart.addNewBooking(newBooking);
                        if (flag) {
                            UserOperationsRemote uor = (UserOperationsRemote) session.getAttribute("uor");
                            if (uor == null) {
                                uor = (UserOperationsRemote) ctx.lookup(UserOperationsRemote.class.getName());
                                session.setAttribute("uor", uor);
                            }
                            TblCustomer cust = (TblCustomer) session.getAttribute("customerDetails");
                            List<TblBooking> myBookings = uor.getBookingsByCustomerId(cust);
                            session.setAttribute("myBookings", myBookings);
                            out.println("Booking Confirmed");
                            RequestDispatcher rd = sc.getRequestDispatcher("/myaccount.jsp");
                            rd.forward(request, response);
                        } else {
                            RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");
                            out.println("Error Occured!");
                            rd.forward(request, response);
                        }

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
        } catch (ParseException ex) {
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
        } catch (ParseException ex) {
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
