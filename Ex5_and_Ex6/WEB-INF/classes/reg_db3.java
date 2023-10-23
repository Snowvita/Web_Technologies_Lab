import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class reg_db3 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "");
            stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("update userdata set password = ? where email = ?");
            String n1 = request.getParameter("email");
            String n2 = request.getParameter("npass");
            pstmt.setString(1, n2);
            pstmt.setString(2, n1);
            int n = pstmt.executeUpdate();

            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Password Update</title>");
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
            out.println("    margin-top: 20px; margin-bottom: 25px;");
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

            if (n > 0) {
                out.println("<h2>Password Updated Successfully!!</h2>");
                out.println("<p class='message'>You can now continue exploring.</p>");
                out.println("<a class='cta-button' href='homePage.html'>Start Exploring...!</a>");
            } else {
                out.println("<h2>Password Update Failed</h2>");
                out.println("<p class='message'>No records updated.</p>");
            }

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.print("Could not connect to DB - Error: " + e);
        }
    }
}
