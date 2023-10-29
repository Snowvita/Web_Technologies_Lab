import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class online2_c extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter pwriter = response.getWriter();
            Cookie[] ck = request.getCookies();

            pwriter.println("<html><head><title>Order Details</title>");
            pwriter.println("<style>");
            pwriter.println("body { background-color: #d6fae5; font-family: Arial, sans-serif; text-align: center; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
            pwriter.println(".container { max-width: 600px; padding: 20px; background-color: #b8fbd4; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); }");
            pwriter.println("h1 { color: #FF5733; font-size: 28px; margin-top: 20px; }"); 
            pwriter.println("h2 { color: #8B4513; font-size: 24px; margin-top: 20px; }");
            pwriter.println("p { font-size: 18px; color: #000000; margin: 20px 0; }");
            pwriter.println("h4 { color: #000000; font-size: 20px; margin-top: 20px; }");
            pwriter.println("</style>");
            pwriter.println("</head><body>");

            pwriter.println("<div class='container'>");
            pwriter.println("<h1>Hello, " + ck[0].getValue() + "!</h1>");
            pwriter.println("<h2>Order Details</h2>");
            pwriter.println("<p>Order placed successfully!</p>");
            pwriter.println("<p>Expected to arrive at your doorstep in 40 minutes.</p>");
            pwriter.println("<h4>Thank you for ordering from Snowbee's!</h4>");
            pwriter.println("</div>");

            pwriter.println("</body></html>");
            pwriter.close();
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
}
