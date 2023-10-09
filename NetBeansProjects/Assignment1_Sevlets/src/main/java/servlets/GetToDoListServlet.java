package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;
import mypackage.ToDo;

/**
 *
 * @author skeha
 */
@WebServlet(name = "GetTodoListServlet", urlPatterns = {"/GetToDoListServlet"})
public class GetToDoListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        List<ToDo> todoList = (List<ToDo>) session.getAttribute("todoList");
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ToDo List</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Todo Tasks</h1>");

            if (todoList == null || todoList.isEmpty()) { // Check if tasks is null or empty
                out.println("<a href='AddToDo.html'>Add a task</a>");
            } else {
                // Display the tasks in an HTML table
                out.println("<table border='4'>");
                out.println("<tr><th>Subject</th><th>Details</th></tr>");

                for (ToDo newTask : todoList) {
                    out.println("<tr><td>" + newTask.getSubject() + "</td><td>" + newTask.getDetails() + "</td></tr>");
                }

                out.println("</table>");
                out.println("<a href='AddToDo.html'>Add a task</a>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }
}


