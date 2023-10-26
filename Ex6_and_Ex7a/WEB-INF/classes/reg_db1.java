import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class reg_db1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "");
            stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("insert into userdata values(?, ?, ?)");
            String n1 = request.getParameter("email");
            pstmt.setString(1, n1);
            pstmt.setString(2, request.getParameter("name"));
            pstmt.setString(3, request.getParameter("password"));
            pstmt.executeUpdate();

            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Registration Successful</title>");
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
            out.println("    color: #333; padding-bottom: 5px;");
            out.println("}");
            out.println(".message {");
            out.println("    font-size: 14px; padding-bottom: 10px;");
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
            out.println("<h2>Registration successful!!</h2><p class='message'>(Inserted into the Database)</p>");
            out.println("<p>Click the button below to view your details:</p>");
            out.println("<form action='reg_db2' method='get'>");
            out.println("<input type='hidden' name='email' value='" + n1 + "'>");
            out.println("<input type='submit' class='prof' value='Click to view your details'>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.print("Failed to connect to DB - Error: " + e);
        }
    }
}
