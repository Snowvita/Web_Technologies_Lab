import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class online1_c extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter pwriter = response.getWriter();

            String in_name = request.getParameter("name");

            Cookie c = new Cookie("UserCookie", in_name);
            response.addCookie(c);

            pwriter.print("<html><head><title>Welcome</title>");
            pwriter.print("<style>");
            pwriter.print("body { background-color: #f8f8e2; font-family: Arial, sans-serif; text-align: center; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
            pwriter.print(".container { max-width: 600px; padding: 20px; background-color: #fcfbbf; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); }");
            pwriter.print("h3 { color: #063965; font-size: 28px; margin-top: 20px; }");
            pwriter.print("p { font-size: 18px; color: #063965; margin: 20px 0; }");
            pwriter.print("a.button { display: inline-block; background-color: #138bcb; color: #fff; padding: 12px 24px; text-decoration: none; border-radius: 5px; margin-top: 20px; font-weight: bold; }");
            pwriter.print("</style>");
            pwriter.print("</head><body>");

            pwriter.print("<div class='container'>");
            pwriter.print("<h3>Welcome, " + in_name + "!</h3><p>Session management implemented using Cookies</p>");
            pwriter.print("<a href='online2_c' class='button'>Click to see Your Order Details</a>");
            pwriter.print("</div>");

            pwriter.print("</body></html>");

            pwriter.close();
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
}
