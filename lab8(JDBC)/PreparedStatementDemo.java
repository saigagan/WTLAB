import java.sql.*;

class PreparedStatementDemo
{
	public static void main(String args[ ]) throws Exception
	{
		Connection con=null;
		PreparedStatement ps=null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","gagan","gagan33");
		System.out.println("\nConnection Successful.\n");
		
		ps=con.prepareStatement("insert into account values(?,?,?)");
		
		ps.setInt(1,4);
		ps.setString(2,"Prajeet");
		ps.setInt(3,50000);
		
		ps.execute();
		System.out.println("Insert Operation Successful.");
		
		ps.close();
		con.close();
	}
}