/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.*;
import model.*;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

/**
 *
 * @author duanh
 */
@WebServlet(name = "AdminUpdateAccount", urlPatterns = {"/AdminUpdateAccount"})
public class AdminUpdateAccount extends HttpServlet {

//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accID = request.getParameter("accID");
        System.out.println("ID update: " + accID);
        
        LoginDAO dao = new LoginDAO();
        Account acc = dao.getInfoAccByID(accID);
        
        request.setAttribute("u", acc);
        
        System.out.println("Before: " + acc.toString());
        
        request.getRequestDispatcher("AdminUpdateAccount.jsp").
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accID = request.getParameter("accID");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String roleID = request.getParameter("roleID");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        
        System.out.println("Update: " + accID + " - " + username + " - " + password + " - " + fullname +" - " + roleID + " - " + status);
        System.out.println("HAS UPDATED");
        
        LoginDAO dao = new LoginDAO();
        dao.updateAcc(accID, username, password, fullname, roleID, true);
        
        response.sendRedirect("AdminHomePage");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
