import java.sql.*;

class TransactionsDemo
{
	public static void main(String args[])
	{
		Connection con=null;
		Statement st=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","gagan","gagan43");
			System.out.println("\nConnection Successful.\n");
		
			con.setAutoCommit(false);
		
			st=con.createStatement();
		
			int res1=st.executeUpdate("insert into account values(5,'Rahul',40000)");
		
			int res2=st.executeUpdate("insert into account values(6,'Ritesh',40000)");
		
			//example error for rollback
			//int res1=st.executeUpdate("insert into account values(5,200,40000)");
			
			System.out.println("Res1: "+res1+" Res2: "+res2);
			con.commit();
			
			con.close();
			st.close();
		}
		
		catch(Exception e)
		{
			try
			{
				System.out.println(e);
				con.rollback();
			}
			
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
	}
}