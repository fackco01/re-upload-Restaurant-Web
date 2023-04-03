package servlet;

import DAO.*;
import model.*;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "AdminDeleteAccount", urlPatterns = {"/AdminDeleteAccount"})
public class AdminDeleteAccount extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accID = request.getParameter("accID");

        LoginDAO dao = new LoginDAO();
        Account delUser = dao.getInfoAccByID(accID);
        System.out.println("DELETE USER: " + delUser);

        dao.deleteUser(accID);
        response.sendRedirect("AdminHomePage");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
