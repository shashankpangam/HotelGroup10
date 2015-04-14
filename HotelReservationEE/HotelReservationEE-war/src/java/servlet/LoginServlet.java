/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Entities.TblBooking;
import Entities.TblCustomer;
import Entities.TblLogin;
import Entities.TblRoom;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.OperationsRemote;
import session.UserOperationsRemote;

/**
 *
 * @author ShashankPangam
 */
public class LoginServlet extends HttpServlet {

    Context ctx;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String returnURL = request.getParameter("returnURL");
            String nextURL = request.getParameter("nextURL");
            HttpSession session = request.getSession(true);
            if (action.equalsIgnoreCase("myAccount")) {
                TblCustomer customer = (TblCustomer) session.getAttribute("customerDetails");
                if (customer == null) {
                    out.println("Please Login first");
                    includeRequest(request, response, returnURL);
                } else {
                    UserOperationsRemote uor = (UserOperationsRemote) session.getAttribute("uor");
                    if (uor == null) {
                        Context ctx = new InitialContext();
                        uor = (UserOperationsRemote) ctx.lookup(UserOperationsRemote.class.getName());
                        session.setAttribute("uor", uor);
                    }
                    List<TblBooking> myBookings = uor.getBookingsByCustomerId(customer);
                    session.setAttribute("myBookings", myBookings);
                    forwardRequest(request, response, nextURL);
                }
            } else if (action.equalsIgnoreCase("Logout")) {
                session.setAttribute("LoggedIn", null);
                session.setAttribute("customerDetails", null);
                session.invalidate();
                ServletConfig cfg = getServletConfig();
                ServletContext sc = cfg.getServletContext();
                forwardRequest(request, response, nextURL);
            } else if (action.equalsIgnoreCase("currentRoom")) {
                int roomid = Integer.parseInt(request.getParameter("roomid"));
                Context ctx = new InitialContext();
                OperationsRemote or = (OperationsRemote) ctx.lookup(OperationsRemote.class.getName());
                TblRoom rooms = (TblRoom) or.getRoomByID(roomid);
                request.setAttribute("rooms", rooms);
                forwardRequest(request, response, nextURL);
            }

        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        HttpSession session = request.getSession(true);
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String returnURL = request.getParameter("returnURL");
            String nextURL = request.getParameter("nextURL");
            if (action.equalsIgnoreCase("addNewUser")) {
                String title = request.getParameter("title");
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                String dobText = request.getParameter("dob");
                DateFormat format = new SimpleDateFormat("yy-MM-dd");
                Date dob = format.parse(dobText);
                String address1 = request.getParameter("addressLine1");
                String address2 = request.getParameter("addressLine2");
                String city = request.getParameter("city");
                String province = request.getParameter("province");
                String zip = request.getParameter("zip");
                String country = request.getParameter("country");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String passwordrepeat = request.getParameter("passwordrepeat");

                boolean flag = true;

                if (fname.equals("") || lname.equals("") || dob.equals("") || address1.equals("") || city.equals("") || zip.equals("") || province.equals("") || email.equals("") || password.equals("") || passwordrepeat.equals("")) {
                    if (fname == null || fname.equals("")) {
                        out.println("<p style='color:red'>Please enter your First Name <p/>");
                        flag = false;
                    }
                    if (lname == null || lname.equals("")) {
                        out.println("<p style='color:red'>Please enter your Last Name <p/>");
                        flag = false;
                    }
                    if (dob == null || dob.equals("")) {
                        out.println("<p style='color:red'>Please enter your Date Of Birth <p/>");
                        flag = false;
                    }
                    if (address1 == null || address1.equals("")) {
                        out.println("<p style='color:red'>Please enter your address <p/>");
                        flag = false;
                    }

                    if (city == null || city.equals("")) {
                        out.println("<p style='color:red'>Please enter your City<p/>");
                        flag = false;
                    }
                    if (zip == null || zip.equals("")) {
                        out.println("<p style='color:red'>Please enter your ZipCode<p/>");
                        flag = false;
                    }
                    if (province == null || province.equals("")) {
                        out.println("<p style='color:red'>Please enter your Province<p/>");
                        flag = false;
                    }
                    if (password == null || password.equals("")) {
                        out.println("<p style='color:red'>Please enter your Password<p/>");
                        flag = false;
                    }
                    if (passwordrepeat == null || passwordrepeat.equals("")) {
                        out.println("<p style='color:red'>Please enter your Retyped Password<p/>");
                        flag = false;
                    }
                    if (password != passwordrepeat) {
                        out.println("<p style='color:red'>Passwords dont match.<p/>");
                        flag = false;
                    }
                } else if (!alpha(fname) || (!alpha(lname))) {
                    out.println("<p style='color:red'>Enter only alphabets for Name <p />");
                    flag = false;
                } else if ((zip.length() != 6)) {
                    out.println("<p style='color:red'>Zip should be 6 in length<p/>");
                    flag = false;
                } else if ((password.length() <= 7)) {
                    out.println("<p style='color:red'>Password should be at least 8 Characters in length<p/>");
                    flag = false;
                } else if (!emailregex(email)) {
                    out.println("<p style='color:red'>Invalid Email Address<p/>");
                    flag = false;
                } else if (!datecheck(dobText)) {
                    out.println("<p style='color:red'>Invalid DOB<p/>");
                    flag = false;
                } else {
                    flag = true;
                }

                if (flag) {
                    TblCustomer newCustomer = new TblCustomer();
                    newCustomer.setTitle(title);
                    newCustomer.setFname(fname);
                    newCustomer.setLname(lname);
                    newCustomer.setDob(dob);
                    newCustomer.setAddressline1(address1);
                    newCustomer.setAddressline2(address2);
                    newCustomer.setCity(city);
                    newCustomer.setProvince(province);
                    newCustomer.setZip(zip);
                    newCustomer.setCountry(country);
                    newCustomer.setEmail(email);
                    UserOperationsRemote uor = (UserOperationsRemote) session.getAttribute("uor");
                    if (uor == null) {
                        Context ctx = new InitialContext();
                        uor = (UserOperationsRemote) ctx.lookup(UserOperationsRemote.class.getName());
                        session.setAttribute("uor", uor);
                    }
                    int pass = uor.insertNewUser(newCustomer);
                    if (pass != 0) {
                        TblLogin newLogin = new TblLogin();
                        TblCustomer addedUser = (TblCustomer) uor.getCustomerById(pass);
                        newLogin.setCustomerid(addedUser);
                        newLogin.setEmail(email);
                        newLogin.setLogintype("USER");
                        newLogin.setPassword(password);
                        Date d = new Date();
                        newLogin.setLastlogin(d);
                        boolean flag1 = uor.insertNewLogin(newLogin);
                        if (flag) {
                            out.println("User Added Successfully!");
                            session.setAttribute("sessionFname", addedUser.getFname());
                            session.setAttribute("sessionCustId", addedUser.getCustomerid());
                            forwardRequest(request, response, nextURL);
                        }
                    } else {
                        out.println("Error Occured, Please try again later");
                        forwardRequest(request, response, returnURL);
                    }

                }

            } else if (action.equalsIgnoreCase("loginAction")) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                boolean flag = true;
                if ((email != "" && !emailregex(email)) || email == "") {
                    out.println("<p style='color:red'>Invalid Email Address<p/>");
                    flag = false;
                }
                if (password == null || password == "") {
                    out.println("<p style='color:red'>Please enter a password<p/>");
                    flag = false;
                }
                if (flag) {
                    UserOperationsRemote uor = (UserOperationsRemote) session.getAttribute("uor");
                    if (uor == null) {
                        Context ctx = new InitialContext();
                        uor = (UserOperationsRemote) ctx.lookup(UserOperationsRemote.class.getName());
                        session.setAttribute("uor", uor);
                    }
                    TblLogin user = (TblLogin) uor.login(email, password);
                    if (user != null) {
                        session.setAttribute("LoggedIn", user);
                        TblCustomer customerDetails = user.getCustomerid();
                        session.setAttribute("customerDetails", customerDetails);
                        if (user.getLogintype().equalsIgnoreCase("ADMIN")) {
                            nextURL = "/AddRoom.jsp";
                        }
                        forwardRequest(request, response, nextURL);
                        out.println("Login Successful!");
                    } else {
                        includeRequest(request, response, returnURL);
                        out.println("Error Occured, Please try again later");
                    }
                }
            } else if (action.equalsIgnoreCase("Delete")) {
                int bookingid = Integer.parseInt(request.getParameter("bookingid"));
                UserOperationsRemote uor = (UserOperationsRemote) session.getAttribute("uor");
                if (uor == null) {
                    Context ctx = new InitialContext();
                    uor = (UserOperationsRemote) ctx.lookup(UserOperationsRemote.class.getName());
                    session.setAttribute("uor", uor);
                }
                boolean flag = uor.deleteBooking(bookingid);
                if (flag) {
                    TblCustomer customer = (TblCustomer) session.getAttribute("customerDetails");
                    List<TblBooking> myBookings = uor.getBookingsByCustomerId(customer);
                    session.setAttribute("myBookings", myBookings);
                    forwardRequest(request, response, nextURL);
                    out.println("Delete Successful");
                } else {
                    forwardRequest(request, response, returnURL);
                    out.println("Error Occured!");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void forwardRequest(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException {
        ServletConfig cfg = getServletConfig();
        ServletContext sc = cfg.getServletContext();
        try {
            RequestDispatcher rd = sc.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void includeRequest(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException {
        ServletConfig cfg = getServletConfig();
        ServletContext sc = cfg.getServletContext();
        try {
            RequestDispatcher rd = sc.getRequestDispatcher(path);
            rd.include(request, response);
        } catch (IOException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    boolean digits(String id) {
        return id.matches("[0-9]+");
    }

    boolean alpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    boolean emailregex(String email) {
        return email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    }

    boolean datecheck(String date) {
        return date.matches("^[0-9]{4}-[0-1][0-9]-[0-3][0-9]$");
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
