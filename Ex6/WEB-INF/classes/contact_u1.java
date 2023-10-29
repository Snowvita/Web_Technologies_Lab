import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class contact_u1 extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{  
        try{  
            response.setContentType("text/html");  
            PrintWriter out = response.getWriter();  
            String n=request.getParameter("name");  
            out.println("<html>");
            out.println("<head>");
            out.println("<style>");
            out.println("body { background-color: #d3e9f3; font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; }");
            out.println(".container { background-color: #a8d8eb; padding: 20px; border: 1px solid #ccc; border-radius: 10px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); max-width: 400px; text-align: center; }");
            out.println("h1 { color: #472d00; font-size: 36px; margin: 20px 0; }");
            out.println("p { font-size: 18px; color: #000000; margin: 20px 0; }");
            out.println("button { background-color: #ff8f7b; color: #fff; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer; }");
            out.println("button:hover {background-color: #e6624b;}");
            out.println("a{text-decoration:none; color:#fff}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class='container'>");

            out.print("<h1>Welcome, " + n + "!!</h1>");
            out.print("<p>Session management using URL Mapping</p>");
            out.print("<button><a href='url2?uname="+n+"'>View More...!!!</a></button>");  
            out.print("</form>");

            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
            out.close();  
        }
        catch(Exception e){System.out.println(e);}  
    } 
}