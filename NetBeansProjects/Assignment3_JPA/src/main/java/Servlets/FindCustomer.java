package Servlets;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.UserTransaction;
import java.util.List;
import newpackage.Customer;

/**
 *
 * @author skeha
 */
@WebServlet(name = "FindCustomer", urlPatterns = {"/FindCustomer"})
public class FindCustomer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;

    @Resource
    private UserTransaction userTransaction;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String customerNumber = request.getParameter("customerNumber");

        // Use a named query to find a customer by customerNumber
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findByCustomerNumber", Customer.class);
        query.setParameter("customerNumber", customerNumber);

        List<Customer> customers = query.getResultList();

        if (customers.isEmpty()) {
            // Customer not found, handle the error or redirect to an error page
            response.getWriter().write("Customer not found.");
        } else {
            // Customer found, you can display or process the customer data as needed
            request.setAttribute("customers", customers);
            request.getRequestDispatcher("displayCustomer.jsp").forward(request, response);
        }
    }
}
