
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
	public class HelloServlet extends HttpServlet
	{
		public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
		{
		res.setContentType("text/html");
		String name=req.getParameter("name");
		PrintWriter out=res.getWriter();
		out.println("Welcome to CSE C :"+name);
		}
}
