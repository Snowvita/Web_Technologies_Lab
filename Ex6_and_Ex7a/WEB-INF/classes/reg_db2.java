import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class reg_db2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "");
            stmt = conn.createStatement();
            String n1 = request.getParameter("email");
            String sql = "SELECT * FROM userdata WHERE email=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, n1);

            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Your Registration Details</title>");
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
            out.println("    padding: 40px;");
            out.println("    border-radius: 10px;");
            out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);");
            out.println("}");
            out.println("h2 {");
            out.println("    color: #333;");
            out.println("    font-size: 24px;");
            out.println("    margin-bottom: 20px;");
            out.println("}");
            out.println(".info {");
            out.println("    text-align: left;");
            out.println("    font-size: 18px;");
            out.println("    margin-bottom: 10px;");
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
            out.println(".message {");
            out.println("    font-size: 15px;");
            out.println("    margin-top: 20px; margin-bottom: 20px;");
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
            out.println("<h2>Your Registration Details!</h2>");

            ResultSet rs = pstmt.executeQuery();

            // Extract data from the result set
            while (rs.next()) {
                // Retrieve by column name
                String email = rs.getString("email");
                String name = rs.getString("name");

                // Display values
                out.println("<div class='info'>");
                out.println("<strong>Name:</strong> " + name + "<br>");
                out.println("<strong>Email:</strong> " + email + "<br><br>");
                out.println("</div>");
                out.println("<form action='change.html' method='get'>");
                out.println("<input type='hidden' name='email' value='" + n1 + "'>");
                
                out.println("<p>You can now continue exploring.</p>");
                out.println("<a class='cta-button' href='homePage.html'>Start Exploring...!</a>");
                out.println("<p>Do you want to change your password? <a href='change.html'>Click here</a></p>");
                out.println("</form>");
            }

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
