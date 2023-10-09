package com.mycompany.week4.servlets;

import com.mycompany.week4.data.Employee;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.annotation.Resource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;

/**
 *
 * @author o_molloy
 */
@WebServlet(name = "CreateEmployee", urlPatterns =
{
    "/CreateEmployee"
})

public class CreateEmployee extends HttpServlet
{

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;
    
    @Resource
    private UserTransaction userTransaction;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws javax.transaction.NotSupportedException
     * @throws javax.transaction.SystemException
     * @throws javax.transaction.RollbackException
     * @throws javax.transaction.HeuristicMixedException
     * @throws javax.transaction.HeuristicRollbackException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, SecurityException, IllegalStateException, HeuristicRollbackException
    {
        String sid = request.getParameter("id");
        String name = request.getParameter("name");
        String ssalary = request.getParameter("salary");

        int id = Integer.parseInt(sid);
        double salary = Double.parseDouble(ssalary);

        System.out.println("creating: " + id + " " + name + " " + salary);
        Employee e1 = new Employee(id, name, (long) salary);
        System.out.println("employee created");
        userTransaction.begin();
        em.persist(e1);
        em.flush();
        userTransaction.commit();

        System.out.println("employee persisted");
      
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("GetEmployees");
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
            throws ServletException, IOException
    {
        try
        {
            processRequest(request, response);
        } catch (NotSupportedException ex)
        {
            Logger.getLogger(CreateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex)
        {
            Logger.getLogger(CreateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex)
        {
            Logger.getLogger(CreateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex)
        {
            Logger.getLogger(CreateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(CreateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex)
        {
            Logger.getLogger(CreateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex)
        {
            Logger.getLogger(CreateEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException
    {
        try
        {
            processRequest(request, response);
        } catch (NotSupportedException ex)
        {
            Logger.getLogger(CreateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex)
        {
            Logger.getLogger(CreateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex)
        {
            Logger.getLogger(CreateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex)
        {
            Logger.getLogger(CreateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(CreateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex)
        {
            Logger.getLogger(CreateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex)
        {
            Logger.getLogger(CreateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
