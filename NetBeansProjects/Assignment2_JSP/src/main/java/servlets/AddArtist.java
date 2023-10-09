package servlets;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javapackage.Artist;

/**
 *
 * @author skeha
 */
@WebServlet(name = "AddArtist", urlPatterns = {"/AddArtist"})
public class AddArtist extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String firstName = request.getParameter("firstName");
    String surname = request.getParameter("surname");
    String nationality = request.getParameter("nationality");
    String yearOfBirth = request.getParameter("yearOfBirth");
    String yearOfDeath = request.getParameter("yearOfDeath");
    String biography = request.getParameter("biography");
    String photoURL = request.getParameter("photoURL");
    
    // Generate a unique ID, for example using UUID
    String artistId = UUID.randomUUID().toString();
    
    // Create new artist object with input data
    Artist newArtist = new Artist(artistId, firstName, surname, nationality, yearOfBirth, yearOfDeath, biography, photoURL);
    
    // get or create a new session
    HttpSession session = request.getSession();
    
    // Retrieve list of artists
    List<Artist> artistList = (List<Artist>) session.getAttribute("artistList");
    
    
    // If artist list doesn't exist create a new one
    if (artistList == null) {
        artistList = new ArrayList<>();
        session.setAttribute("artistList", artistList);
    }
    
    // add new artist to the list
    artistList.add(newArtist);
    
    // Debugging output
    // System.out.println("New artist added: " + newArtist.getFirstName());

    // Set the newArtist as a request attribute
    request.setAttribute("newArtist", newArtist);
    
    // Forward to displayArtists.jsp
    request.getRequestDispatcher("displayArtists.jsp").forward(request, response);
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
            throws ServletException, IOException
    {
        processRequest(request, response);
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
