/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;


import Entities.TblBooking;
import Entities.TblRoom;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.OperationsRemote;

/**
 *
 * @author Paramjyot
 */
public class AdminOperations extends HttpServlet {

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
            throws ServletException, IOException, NamingException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminOperations</title>");            
            out.println("</head>");
            out.println("<body>");
                                  
        InitialContext ic = new InitialContext();
        Object o = ic.lookup(OperationsRemote.class.getName());
        OperationsRemote roomSession = (OperationsRemote) o;               
        
         if(request.getParameter("search")!=null){
              int roomnumber=Integer.parseInt(request.getParameter("roomNumber"));
             // Object room = roomSession.getRoomByID(roomnumber);
               TblRoom room = (TblRoom) roomSession.getRoomByID(roomnumber);
              RequestDispatcher rd = request.getRequestDispatcher("/UpdateRoom.jsp");                                 
              request.setAttribute("room", room);
              rd.include(request, response);
         }
        
        
        if(request.getParameter("Add")!=null){
        
            int roomNumber=Integer.parseInt(request.getParameter("roomNumber"));
            short floor=Short.parseShort(request.getParameter("roomFloor"));
            int size=Integer.parseInt(request.getParameter("roomSize"));
            String view=request.getParameter("roomView");
            String bedType=request.getParameter("bedType");
            short bedCount=Short.parseShort(request.getParameter("bedCount"));
            boolean smoking = false;
            String insmoking= request.getParameter("smoking");
           
            float price=Float.parseFloat(request.getParameter("price"));
            String status=request.getParameter("status");
            short capacity=Short.parseShort(request.getParameter("capacity"));
            
            
        roomSession.addRoom(Classes.RoomObjectBuilder.getRoom(roomNumber,floor,size,view,bedType,bedCount,smoking,price,status,capacity));
             out.println("ROOM ADDED TO THE DATABASE");
               RequestDispatcher rd = request.getRequestDispatcher("AddRoom.jsp");
            rd.include(request, response);
       }
         if(request.getParameter("Update")!=null){   
             
             int roomNumber=Integer.parseInt(request.getParameter("roomNumber"));
            short floor=Short.parseShort(request.getParameter("roomFloor"));
            int size=Integer.parseInt(request.getParameter("roomSize"));
            String view=request.getParameter("roomView");
            String bedType=request.getParameter("bedType");
            short bedCount=Short.parseShort(request.getParameter("bedCount"));
            boolean smoking = false;
            String insmoking= request.getParameter("smoking");           
            float price=Float.parseFloat(request.getParameter("price"));
            String status=request.getParameter("status");
            short capacity=Short.parseShort(request.getParameter("capacity"));
                          
        roomSession.editRoom(Classes.RoomObjectBuilder.getRoom(roomNumber,floor,size,view,bedType,bedCount,smoking,price,status,capacity));
             out.println("ROOM DETAILS UPDATED");
                RequestDispatcher rd = request.getRequestDispatcher("AddRoom.jsp");
            rd.include(request, response);
       }
          if(request.getParameter("Delete")!=null){                             
        int roomNumber=Integer.parseInt(request.getParameter("roomNumber"));
        roomSession.deleteRoom(roomNumber);
             out.println("ROOM DELETED");
               RequestDispatcher rd = request.getRequestDispatcher("AddRoom.jsp");
            rd.include(request, response);
       }
                             
          
           if(request.getParameter("Generate")!=null){   
             
            String startDate = request.getParameter("startdate");
            String endDate = request.getParameter("enddate");              
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date startdate = format.parse(startDate);
            Date enddate = format.parse(endDate);
            List<TblBooking> report = (List<TblBooking>)roomSession.generateReport(startdate,enddate);
            out.println("REPORT GENERATED");
            request.setAttribute("report",report);
            RequestDispatcher rd = request.getRequestDispatcher("viewReport.jsp");
            rd.include(request, response);
            
       }
           
           if(request.getParameter("GenerateStatusReport")!=null){   
             
            String status = request.getParameter("status");
            String fl = request.getParameter("floor");   
            short floor = (short)(Integer.parseInt(fl));
                
            List<TblBooking> report = (List<TblBooking>)roomSession.generateStatusReport(floor,status);
            out.println("REPORT GENERATED");
            request.setAttribute("report",report);
            RequestDispatcher rd = request.getRequestDispatcher("viewReport.jsp");
            rd.include(request, response);
            
       }
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AdminOperations.class.getName()).log(Level.SEVERE, null, ex);
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
