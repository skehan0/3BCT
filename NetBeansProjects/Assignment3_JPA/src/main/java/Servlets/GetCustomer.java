package Servlets;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import newpackage.Customer;

/**
 *
 * @author skeha
 */
@WebServlet(name = "GetCustomer", urlPatterns = {"/GetCustomer"})
public class GetCustomer extends HttpServlet {

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        List<Customer> customers = new ArrayList<>();

        //userTransaction.begin();
        Query q = em.createQuery("select e from Customer e");

        customers = q.getResultList();

        //userTransaction.commit();
        
        HttpSession session = request.getSession();
        session.setAttribute("customers", customers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("displayCustomer.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}
