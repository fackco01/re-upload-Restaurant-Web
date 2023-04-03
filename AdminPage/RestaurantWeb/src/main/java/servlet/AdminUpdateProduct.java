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

@MultipartConfig
@WebServlet(name = "AdminUpdateProduct", urlPatterns = {"/AdminUpdateProduct"})
public class AdminUpdateProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String PID = request.getParameter("PID");
        RestaurantDAO dao = new RestaurantDAO();
        Product b = dao.getProduct(PID);
        request.setAttribute("p", b);

        System.out.println("Before: " + b.toString());

        request.getRequestDispatcher("AdminUpdateProduct.jsp").
                forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RestaurantDAO dao = new RestaurantDAO();
        List<Product> pl = dao.getAllProduct();

        String id = request.getParameter("id");
        String pName = request.getParameter("name");
        int price = Integer.parseInt (request.getParameter("price"));
        String date = request.getParameter("date");
        String categoryID = request.getParameter("categoryID");
        
        
        Part part = request.getPart("photo");
        String photoPath = request.getServletContext().getRealPath("/img");

        String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
        if (!Files.exists(Path.of(photoPath))) {
            Files.createDirectories(Path.of(photoPath));
        }
        part.write(photoPath + "/" + filename);

        System.out.println("after: " + id + " - " + pName + " - " + categoryID + " - " + price + " - " + filename);
        System.out.println("UPDATED");
        dao.updateProduct(id, "img/" + filename, pName, categoryID, price);
        response.sendRedirect("AdminHomePage");
    }

}
