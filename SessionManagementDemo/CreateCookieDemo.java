import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class CreateCookieDemo extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie c1 = new Cookie("user1", "pwd1");
        Cookie c2 = new Cookie("user2", "pwd2");
        Cookie c3 = new Cookie("user3", "pwd3");
        Cookie c4 = new Cookie("user4", "pwd4");

        response.addCookie(c1);
        response.addCookie(c2);
        response.addCookie(c3);
        response.addCookie(c4);

        out.println("<html><body>");
        out.println("<h3>Cookies Created Successfully!</h3>");
        out.println("</body></html>");
    }
}
