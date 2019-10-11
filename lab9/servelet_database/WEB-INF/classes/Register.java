import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class Register extends HttpServlet {
public void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String n=req.getParameter("userName");
String p=req.getParameter("userPass");
String e=req.getParameter("userEmail");
String c=req.getParameter("userCountry");
out.println("Insert");
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
PreparedStatement ps=con.prepareStatement("insert into registeruser values(?,?,?,?)");
ps.setString(1,n);
ps.setString(2,p);
ps.setString(3,e);
ps.setString(4,c);
int i=ps.executeUpdate();
if(i>0)
out.println("You are successfully registered...");
}catch (Exception e2) {
out.println(e2);
}
out.close();
}
}