import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ConfigContextDemo extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Access servlet-specific parameter
        ServletConfig config = getServletConfig();
        String trainer = config.getInitParameter("trainer");

        // Access context-wide parameter
        ServletContext context = getServletContext();
        String college = context.getInitParameter("college");

        out.println("<html><body>");
        out.println("<h2>Servlet Config and Context Demo</h2>");
        out.println("<p><b>Trainer Name:</b> " + trainer + "</p>");
        out.println("<p><b>College Name:</b> " + college + "</p>");
        out.println("</body></html>");
    }
}
