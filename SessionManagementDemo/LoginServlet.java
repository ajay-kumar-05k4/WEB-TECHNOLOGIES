import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String uid = request.getParameter("userid");
        String pwd = request.getParameter("password");

        Cookie[] cookies = request.getCookies();
        boolean valid = false;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(uid) && c.getValue().equals(pwd)) {
                    valid = true;
                    break;
                }
            }
        }

        out.println("<html><body>");
        if (valid) {
            out.println("<h2>Welcome, " + uid + "!</h2>");
        } else {
            out.println("<h2>You are not an authenticated user.</h2>");
        }
        out.println("</body></html>");
    }
}
