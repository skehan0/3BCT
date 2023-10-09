/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.week4.servlets;

import com.mycompany.week4.data.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
@WebServlet(name = "JPQLQueries", urlPatterns =
{
    "/JPQLQueries"
})
public class JPQLQueries extends HttpServlet
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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SystemException, NotSupportedException, SecurityException, IllegalStateException, HeuristicRollbackException, HeuristicMixedException, RollbackException
    {

        // Select Query
        Query q1 = em.createQuery("select e from Employee e where e.name = 'mary'");
        Employee e1 = (Employee) q1.getSingleResult();
        System.out.println("Employee with name mary has id: " + e1.getEmpid());
        System.out.println();

        // Select Query with parameterised elements
        Query q2 = em.createQuery("select e from Employee e where e.name = :name");
        q2.setParameter("name", "Marg");
        Employee e2 = (Employee) q2.getSingleResult();
        System.out.println("Employee with name Marg has id: " + e2.getEmpid());
        System.out.println();

        // Update
        e2.setSalary((long) 450000.00);
        userTransaction.begin();
        {
            em.merge(e2);
            em.flush();
        }
        userTransaction.commit();
        System.out.println("Employee with name Marg has had salary set to 45000");
        System.out.println();

        // Select Query with positional parameters
        List<Employee> employees = new ArrayList<>();
        Query q3 = em.createQuery("select e from Employee e where e.salary > ?1");
        q3.setParameter(1, 50000.00);
        employees = q3.getResultList();
        System.out.println(employees.size() + " employees have salary > 50000");
        System.out.println();
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
        } catch (SystemException ex)
        {
            Logger.getLogger(JPQLQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSupportedException ex)
        {
            Logger.getLogger(JPQLQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(JPQLQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex)
        {
            Logger.getLogger(JPQLQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex)
        {
            Logger.getLogger(JPQLQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex)
        {
            Logger.getLogger(JPQLQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex)
        {
            Logger.getLogger(JPQLQueries.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SystemException ex)
        {
            Logger.getLogger(JPQLQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSupportedException ex)
        {
            Logger.getLogger(JPQLQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(JPQLQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex)
        {
            Logger.getLogger(JPQLQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex)
        {
            Logger.getLogger(JPQLQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex)
        {
            Logger.getLogger(JPQLQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex)
        {
            Logger.getLogger(JPQLQueries.class.getName()).log(Level.SEVERE, null, ex);
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
