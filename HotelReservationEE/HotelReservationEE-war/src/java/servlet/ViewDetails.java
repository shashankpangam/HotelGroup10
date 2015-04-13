/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Entities.TblRoom;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
import session.OperationsRemote;

/**
 *
 * @author meenakshimehta
 */
public class ViewDetails extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        String submit = request.getParameter("view");
       
        Context ctx = new InitialContext();   
        OperationsRemote roomSession = (OperationsRemote) ctx.lookup(OperationsRemote.class.getName());
        ServletContext sc = getServletConfig().getServletContext();
            switch (submit) {
                case "City View":
                    {                    
                        List<TblRoom> rooms = roomSession.getRoomByView("CITY");
                        RequestDispatcher rd = sc.getRequestDispatcher("/roomsDetails.jsp");
                        request.setAttribute("rooms", rooms);
                        rd.forward(request, response);
                        break;
                    }
                case "Ocean View":
                   {
                        List<TblRoom> rooms = roomSession.getRoomByView("OCEAN");
                        RequestDispatcher rd = sc.getRequestDispatcher("/roomsDetails.jsp");
                        request.setAttribute("rooms", rooms);
                        rd.forward(request, response);
                        break;
                    }
                case "Mountain View":
                    {
                        List<TblRoom> rooms = roomSession.getRoomByView("MOUNTAIN");
                        RequestDispatcher rd = sc.getRequestDispatcher("/roomsDetails.jsp");
                        request.setAttribute("rooms", rooms);
                        rd.forward(request, response);
                        break;
                    }
                case "Select Room":
                        int roomid = Integer.parseInt(request.getParameter("roomid"));
                        TblRoom rooms = (TblRoom) roomSession.getRoomByID(roomid);
                        RequestDispatcher rd = sc.getRequestDispatcher("/currentRoom.jsp");
                        request.setAttribute("rooms", rooms);
                        rd.forward(request, response);
                        break;
                    
            }
        
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
            Logger.getLogger(ViewDetails.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ViewDetails.class.getName()).log(Level.SEVERE, null, ex);
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
