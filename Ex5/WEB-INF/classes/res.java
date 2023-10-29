import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class res extends HttpServlet {
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
            out.println("</style>");
            out.println("</head>");
            
            out.println("<body>");
            out.println("<div class='container'>");
            out.print("<h1>Welcome, " + n1 + "!!</h1>");
            out.print("<h2>Reservation Successful!!!</h2>");
            out.print("<p>Handling form data using Servlets</p>");
            out.print("<h3>Reservation Details:</h3>");
            out.print("<p><b>Date: </b>" + n2 + "<br/>");
            out.print("<p><b>Time: </b>" + n3 + "<br/>");
            out.print("<p><b>Number of people: </b>" + n4 + "<br/>");
            out.print("<p><b>Table preference: </b>" + n5 + "<br/>");
            out.println("</div>");
            out.println("</body>");

            out.println("</html>");

            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
