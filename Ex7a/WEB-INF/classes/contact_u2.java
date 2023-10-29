import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class contact_u2 extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();            
        String n = request.getParameter("uname"); 
        
        out.println("<html>");
        out.println("<head>");
        out.println("<style>");
        out.println("body { background-color: #d3e9f3; font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; }");
        out.println(".container { background-color: #a8d8eb; padding: 20px; border: 1px solid #ccc; border-radius: 10px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); max-width: 400px; text-align: center; }");
        out.println("h3 { color: #000000; font-size: 30px; margin: 20px 0; }");
        out.println("p { color: #e6624b; font-size: 22px; margin: 20px 0; }"); 
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.print("<h3>Hello, " + n + "!</h3>");
        out.print("<p>Message sent Successfully!!!</p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        out.close(); 
        }catch(Exception e){System.out.println(e);}  
    } 
}