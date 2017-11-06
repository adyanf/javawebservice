/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.IdentityService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author adyan
 */
public class logout extends HttpServlet {

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
            out.println("<title>Servlet logout</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet logout at " + request.getContextPath() + "</h1>");
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
        JSONObject responseJSON = new JSONObject();
        try {
            PrintWriter out = response.getWriter();
            Connection conDB = ConnectDBAccount.getConnection();
            if (conDB != null){
                Statement stmt = conDB.createStatement();
                String sql_query;
                
                String token = request.getParameter("token");
              
                sql_query = "SELECT * FROM token WHERE access_token=\""+ token +"\"";
                ResultSet rs = stmt.executeQuery(sql_query);
                
                String username;
                if (rs.next()) {
                    sql_query = "UPDATE token SET expiry_time = 0 WHERE access_token=\""+token+"\"";
                    stmt.executeUpdate(sql_query);
                    String message = "User telah logout.";
                    responseJSON.put("status","OK");
                    responseJSON.put("message", message);
                    out.println(responseJSON.toString());
                }
                else {
                    responseJSON.put("status","ERROR");
                    responseJSON.put("message", "User tidak ditemukan");
                    out.println(responseJSON.toString());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(logout.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
