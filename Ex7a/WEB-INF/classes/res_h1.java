import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class res_h1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n1 = request.getParameter("name");
            String n2 = request.getParameter("date");
            String n3 = request.getParameter("time");
            String n4 = request.getParameter("num_people");
            String n5 = request.getParameter("table_preference");

            out.println("<html>");
            out.println("<head>");
            out.println("<style>");
            out.println("body { background-color: #fff1da; font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; }");
            out.println(".container { background-color: #ffe5b9; padding: 20px; border: 1px solid #ccc; border-radius: 10px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); max-width: 400px; text-align: center; }");
            out.println("h1 { color: #472d00; font-size: 36px; margin: 20px 0; }");
            out.println("p { font-size: 18px; color: #000000; margin: 20px 0; }");
            out.println("form { margin: 0 auto; }");
            // out.println("input[type='text'] { width: 100%; padding: 10px; margin: 10px 0; border: 1px solid #ccc; border-radius: 5px; }");
            out.println("input[type='submit'] { background-color: #91784d; color: #fff; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer; }");
            out.println("input[type='submit']:hover {background-color: #56401b;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class='container'>");

            out.print("<h1>Welcome, " + n1 + "!!</h1>");

            out.print("<form action='res_h2' method='POST'>");
            out.print("<input type='hidden' name='uname' value='" + n1 + "'>");
            out.print("<input type='hidden' name='date' value='" + n2 + "'>");
            out.print("<input type='hidden' name='time' value='" + n3 + "'>");
            out.print("<input type='hidden' name='num_people' value='" + n4 + "'>");
            out.print("<input type='hidden' name='table_preference' value='" + n5 + "'>");
            out.print("<p>Session management using Hidden form Element</p>");

            out.print("<input type='submit' value='Click to see the reservation details'>");
            out.print("</form>");

            out.println("</div>");

            out.println("</body>");
            out.println("</html>");

            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
