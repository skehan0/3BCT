/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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
@WebServlet(name = "DeleteEmployee", urlPatterns =
{
    "/DeleteEmployee"
})
public class DeleteEmployee extends HttpServlet
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
            throws ServletException, IOException, NotSupportedException, SystemException, RollbackException, SecurityException, IllegalStateException, HeuristicRollbackException, HeuristicMixedException
    {
        String sid = request.getParameter("id");
        int iid = Integer.parseInt(sid);

        userTransaction.begin();
        {
            Employee e = em.find(Employee.class, iid);
            em.remove(e);
            em.flush();
        }
        userTransaction.commit();

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
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex)
        {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex)
        {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex)
        {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex)
        {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex)
        {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex)
        {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex)
        {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex)
        {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex)
        {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex)
        {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
