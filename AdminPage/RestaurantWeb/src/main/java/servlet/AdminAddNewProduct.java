package servlet;

import DAO.*;
import model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.http.*;
import java.util.List;
import jakarta.servlet.annotation.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author duanh
 */
@MultipartConfig
@WebServlet(name = "AdminAddNewProduct", urlPatterns = {"/AdminAddNewProduct"})
public class AdminAddNewProduct extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = "";
        
        RestaurantDAO dao = new RestaurantDAO();
        List<Product> pl = dao.getAllProduct();
        
        //add photo
        Part part = request.getPart("photo");
        String photoPath = request.getServletContext().getRealPath("/img");

        String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
        if (!Files.exists(Path.of(photoPath))) {
            Files.createDirectories(Path.of(photoPath));
        }
        part.write(photoPath + "/" + filename);

        //add name, price, category ID, rate
        String nameP = request.getParameter("nameP");
        int price = Integer.parseInt(request.getParameter("price"));
        String categoryID = request.getParameter("categoryID");
        float rating = Float.parseFloat(request.getParameter("rating"));

        System.out.println(" - " + nameP + " - " + price + " - " + categoryID + " - " + filename);

        //----------------------
        if (duplicationName(nameP, pl)) {
            request.setAttribute("alert",pl );
            url = "AdminAddNewProduct.jsp";
        } else {
            dao.newProduct(autoIncreaseIDProduct(pl), "img/" + filename, nameP, categoryID, price, rating);
            System.out.println("ADD NEW PRODUCT: " + nameP + " - " + categoryID + " - " + price + " - " + rating);
            url = "AdminHomePage";
        }
        System.out.println("url: " + url);
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
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
        processRequest(request, response);
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

    boolean duplicationName(String name, List<Product> ls) {
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getNameP().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    String autoIncreaseIDProduct(List<Product> ls) {
        String id = "";
        int noId = 1;

        for (int i = 0; i < ls.size(); i++) {
            String[] str = ls.get(i).getPID().split("P");
            for (int j = 1; j < str.length; j++) {
                int no = Integer.parseInt(str[j]);
                while (noId <= no) {
                    noId++;
                }
            }
        }
        if (noId <= 9) {
            id = "P" + "000" + noId;

        } else if (noId <= 99) {
            id = "P" + "00" + noId;
        } else {
            id = "P" + "0" + noId;
        }
        return id;
    }
}
