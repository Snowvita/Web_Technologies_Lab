import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class login_s1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String n = request.getParameter("name");

            HttpSession session=request.getSession();  
            session.setAttribute("login_name",n);  

            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Welcome</title>");
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
            out.println("    padding-top: 10px;");
            out.println("    padding-left: 40px;");
            out.println("    padding-right: 40px;");
            out.println("    padding-bottom: 40px;");
            out.println("    border-radius: 10px;");
            out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);");
            out.println("}");
            out.println("h2 {");
            out.println("    margin-bottom:5px;");
            out.println("}");
            out.println(".message {");
            out.println("    color: #333; margin-bottom:12px;padding-bottom:20px;");
            out.println("}");
            out.println(".prof {");
            out.println("    text-decoration: none;");
            out.println("    background-color: #91784d;");
            out.println("    color: #fff;");
            out.println("    padding: 10px 20px;");
            out.println("    border-radius: 5px;");
            out.println("    font-size: 18px;");
            out.println("    transition: background-color 0.3s ease;");
            out.println("}");
            out.println(".prof:hover {");
            out.println("    background-color: #56401b;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h2>Welcome, " + n + "!!</h2><p class='message'>Session Management using Session ID</p>");
            out.println("<a class='prof' href='login_s2'>Visit your profile</a><br><br>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
