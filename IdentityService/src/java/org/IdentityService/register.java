/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.IdentityService;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author adyan
 */
public class register extends HttpServlet {

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
            out.println("<title>Servlet register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
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
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello, World!</h1>");
//        doPost(request, response);
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
        JSONObject json = new JSONObject();
        try {
            PrintWriter out = response.getWriter();
            Connection conDB = ConnectDBAccount.getConnection();
            if (conDB != null){
                Statement stmt = conDB.createStatement();
                String sql_query;
                
                String username = request.getParameter("username");
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                String phone_number = request.getParameter("phone");
                String driver = request.getParameter("driver");
                
                sql_query = "select * from account where "
                        + "(username = \""+ username +"\" or email = \""+ email +"\")";
                ResultSet result = stmt.executeQuery(sql_query);
                
                if (!result.next()){
                    sql_query = "insert into account (name, username, email, password, phone_number, driver)"
                            + " VALUES (\"" +name+ "\", \"" +username+"\", \"" +email+"\", \"" +password
                            +"\", \""+phone_number+"\", \""+driver+"\")";
                    stmt.executeUpdate(sql_query);
                    
                    sql_query = "select * from account where username = \""+username+"\"";
                    
                    result = stmt.executeQuery(sql_query);
                    
                    result.next();
                    int user_id = result.getInt("ID");
                   
                    String token = TokenGenerator.randomString(20);
                    
                    Timestamp now = new Timestamp(System.currentTimeMillis());
                    long nowMilis = now.getTime();
                    long expiry = nowMilis + 1800;
                    
                    sql_query = "insert into token (ID, access_token, expiry_time)"
                            + "VALUES (" + user_id + ", \""+ token + "\", " + expiry + ")";
                    stmt.executeUpdate(sql_query);
                    
                    json.put("status", "OK");
                    json.put("username", username);
                    json.put("ID", user_id);
                    json.put("token", token);
                    out.print(json.toString());
                }
                else {
                    json.put("status", "FAILED");
                    json.put("message", "user already registered");
                    out.print(json.toString());
                }
            } else {
                json.put("status", "ERROR");
                json.put("message", "can't connect to the database");
                out.print(json.toString());
            }
        } catch (SQLException ex) {
            System.out.println("Can't connect to database!");
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
