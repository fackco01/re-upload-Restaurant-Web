/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet.Login;

import DAO.LoginDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Account;

/**
 *
 * @author lenovo
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";

        String user = request.getParameter("username");
        String pass = request.getParameter("pass");
        LoginDAO dao = new LoginDAO();

        Account result = dao.checkLogin(user, pass);
        System.out.println("USER VALID: " + result);

        if (result != null) {

            if (result.getRoleID().equals("R01")) {
                
                HttpSession session = request.getSession();
                session.setAttribute("NAME", result);
                url = "AdminHomePage";
                
            } else {
                url = "HomeServlet";
                HttpSession session = request.getSession();
                session.setAttribute("NAME", result);
            }

        } else {
            url = "login.jsp";
            request.setAttribute("show", "show");
            request.setAttribute("alert", "danger");
            request.setAttribute("ERROR", "<span><i class=\"bi bi-exclamation-triangle-fill\"></i></span> LOGIN FAIL");
        }
        System.out.println("url " + url);
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

}
