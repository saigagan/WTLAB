import java.sql.*;

class ResultSetDemo
{
	public static void main(String args[]) throws Exception
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","gagan","gagan433");
		st=con.createStatement();
		System.out.println("\nConnection Successful.\n");
		
		rs=st.executeQuery("select * from Account");
		
		while(rs.next())
		{
			System.out.println("|"+rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getInt(3)+"|");
		}
		System.out.println("\nEnd of Information Recieved.\n");
		
		
		rs.close();
		st.close();
		con.close();
	}
}