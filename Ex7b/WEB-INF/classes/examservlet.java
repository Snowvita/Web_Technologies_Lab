import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class examservlet extends HttpServlet {
    private int counter = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "");
            for (int i = 1; i <= 10; i++) {
                String userAnswer = request.getParameter("answer" + i);
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM answers WHERE qno = ?");
                stmt.setInt(1, i);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String Answer = rs.getString("ans");
                    if (userAnswer != null && userAnswer.equals(Answer)) {
                        counter++;
                    }
                }
                rs.close();
                stmt.close();
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body style='font-family: 'Roboto', sans-serif; background-color: #f0ffe4; display: flex; align-items: center; justify-content: center; height: 100vh;'>");
        out.println("<div style='background-color: #edf9e5; border-radius: 10px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2); max-width: 500px; margin-left: 350px; margin-top: 200px; padding: 20px; text-align: center;'>");
        out.println("<h2 style='color: #ff5722; font-size: 28px;'>Quiz Results</h2>");
        out.println("<p style='color: #0066cc; font-size: 18px;'>You Scored: " + counter + " out of 10</p>");
        
        if (counter >= 5) {
            out.println("<p style='color: #6c136f; font-size: 20px;'>Congratulations! You've Passed!</p>");
        } else {
            out.println("<p style='color: #6c136f; font-size: 20px;'>Oops!! You Didn't Pass This Time.</p>");
            out.println("<p><a href='index.html' style='text-decoration: none; color: #7e22ff; font-size: 18px;'>Try Again</a></p>");
            out.println("<style>a:hover{ text-decoration: underline !important;}</style>"); 
        }
        out.println("</div>");
        out.println("</body></html>");
        counter = 0;        
    }
}
