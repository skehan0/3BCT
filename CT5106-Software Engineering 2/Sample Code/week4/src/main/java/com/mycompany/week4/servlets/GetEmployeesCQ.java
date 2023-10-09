/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.week4.servlets;

import com.mycompany.week4.data.Employee;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author o_molloy
 */
@WebServlet(name = "GetEmployeesCQ", urlPatterns
        = {
            "/GetEmployeesCQ"
        })
public class GetEmployeesCQ extends HttpServlet {

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;

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
            throws ServletException, IOException 
    {
        
        List<Employee> employees = new ArrayList<>();
        
        // use em to create CriteriaBuilder
        CriteriaBuilder cb = em.getCriteriaBuilder();
        
        // create a Query object
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        
        // set the query root - like the FROM part of a regular query
        Root<Employee> emp = cq.from(Employee.class);
        
        // Specify what the type of the query result will be
        cq.select(emp);
        
        // Prepare the query for execution 
        TypedQuery<Employee> q = em.createQuery(cq);
        
        // Execute the query
        employees = q.getResultList();

        //userTransaction.commit();
        HttpSession session = request.getSession();
        session.setAttribute("employees", employees);

        RequestDispatcher dispatcher = request.getRequestDispatcher("displayEmployees.jsp");
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
