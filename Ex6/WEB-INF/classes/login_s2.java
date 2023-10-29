import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class login_s2 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession(false);
            String n = (String) session.getAttribute("login_name");

            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Welcome Back</title>");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    background-color: #e0dcd5;");
            out.println("    margin: 0;");
            out.println("    padding: 0;");
            out.println("    display: flex;");
            out.println("    justify-content: center;");
            out.println("    align-items: center;");
            out.println("    height: 100vh;");
            out.println("}");

            out.println(".container {");
            out.println("    text-align: center;");
            out.println("    background-color: #e8dbc4;");
            out.println("    padding: 40px; padding-bottom: 60px;");
            out.println("    border-radius: 10px;");
            out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);");
            out.println("}");

            out.println("h2 {");
            out.println("    color: #000000;");
            out.println("}");

            out.println(".message {");
            out.println("    font-size: 20px;");
            out.println("    margin-top: 20px;margin-bottom: 40px;");
            out.println("}");

            out.println(".cta-button {");
            out.println("    text-decoration: none;");
            out.println("    background-color: #91784d;");
            out.println("    color: #fff;");
            out.println("    padding: 10px 20px;");
            out.println("    border-radius: 5px;");
            out.println("    font-size: 18px;");
            out.println("    transition: background-color 0.3s ease;");
            out.println("}");

            out.println(".cta-button:hover {");
            out.println("    background-color: #56401b;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h2>Hello, " + n + "!</h2>");
            out.println("<p class='message'>It's a beautiful day to explore new horizons.</p>");
            out.println("<a class='cta-button' href='homePage.html'>Start Exploring...!</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
