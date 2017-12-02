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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author adyan
 */
public class userid extends HttpServlet {

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
            out.println("<title>Servlet userid</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet userid at " + request.getContextPath() + "</h1>");
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
        JSONObject json = new JSONObject();
        try {
            PrintWriter out = response.getWriter();
            Connection conDB = ConnectDBAccount.getConnection();
            if (conDB != null){
                Statement stmt = conDB.createStatement();
                String sql_query;
                
                String token = request.getParameter("token");
                sql_query = "select * from token where "
                        + "(access_token = \""+ token +"\")";
                ResultSet result = stmt.executeQuery(sql_query);

                if (result.next()){
                    int user_id = result.getInt("ID");
                    json.put("status", "OK");
                    json.put("user_id", Integer.toString(user_id));
                    out.print(json.toString());
                }
                else {
                    json.put("status", "ERROR");
                    json.put("message", "user doesn't exist");
                    out.print(json.toString());
                }
            } else {
                json.put("status", "ERROR");
                json.put("message", "can't connect to the database");
                out.print(json.toString());
            }
            
        } catch (SQLException ex) {
            PrintWriter out = response.getWriter();
            json.put("status", "ERROR : Can't connect to database!");
            json.put("message", ex.getMessage());
            out.print(json.toString());
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
        doGet(request, response);
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
