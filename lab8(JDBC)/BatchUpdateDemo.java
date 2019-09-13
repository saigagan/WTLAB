import java.sql.*;

class BatchUpdateDemo
{
	public static void main(String args[])
	{
		Connection con=null;
		Statement st=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","gaganl","gagan433");
			System.out.println("\nConnection Successful.\n");
		
			con.setAutoCommit(false);
		
			st=con.createStatement();
		
			st.addBatch("insert into account values(7,'dheeraj,90000)");
		
			st.addBatch("insert into account values(8,'Hemanth',99999)");
		
			st.executeBatch();
			
			con.commit();
			System.out.println("\nBatch Execute Successful.\n");
			
			con.close();
			st.close();
		}
		
		catch(Exception e)
		{
			try
			{
				System.out.println(e);
				System.out.println("\nBatch Execute Unsuccessful.\n");
				con.rollback();
			}
			
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
	}
}