package servlets;

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
import mypackage.ToDo;

/**
 *
 * @author skeha
 */
@WebServlet(name = "AddToDoServlet", urlPatterns = {"/AddToDoServlet"})
public class AddToDoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve task data from the form
        String subject = request.getParameter("subject");
        String details = request.getParameter("details");

        // Create a new ToDo object with the input data
        ToDo newTask = new ToDo(subject, details);

        // Retrieve the list of todoList from the session
        HttpSession session = request.getSession();
        
        // Retrieve list
        List<ToDo> todoList = (List<ToDo>) session.getAttribute("todoList");

        if (todoList == null) {
            // If there is no todoList, create a new list
            todoList = new ArrayList<>();
            session.setAttribute("todoList", todoList);
        }

        // Add the new task to the list
        todoList.add(newTask);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Task Added</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Task added successfully</h1>");
            out.println("<a href='GetToDoListServlet'>Go back to Task List</a>");
            out.println("</body>");
            out.println("</html>");
        }

        // Redirect back to the GetTodoList servlet to display the updated task list
        response.sendRedirect("GetToDoListServlet");
    }
}


    