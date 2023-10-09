
package com.mycompany.week3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author o_molloy
 */
@WebServlet(name = "GetProducts", urlPatterns = {"/GetProducts"})
public class GetProducts extends HttpServlet {

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

        Product p1 = new Product("Whiteboard", "Just a white board", 50.00, 101);
        Product p2 = new Product("Stapler", "Just a staple stapler", 10.00, 102);
        Product p3 = new Product("Chair", "Standard office chair", 40.00, 103);
        Product p4 = new Product("Lamp", "Anglepoise!", 25.00, 104);

        Supplier s1 = new Supplier ("ACME Products", "Coyote Avenue", "1800-34800", "sales@acme.com");
        Supplier s2 = new Supplier ("Staples Office Supplies", "Beijing", "00-86-6513-0828", "info@staples.cn");
       
        p1.setSupplier(s2);
        p2.setSupplier(s2);
        p3.setSupplier(s1);
        p4.setSupplier(s1);
        
        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

        HttpSession session = request.getSession();
        session.setAttribute("catalogue", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("displayProducts.jsp");
        dispatcher.forward(request, response);
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

}
