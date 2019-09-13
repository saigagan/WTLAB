import java.sql.*;

class ResultSetMeta
{
	public static void main(String args[]) throws Exception
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","gagan","gagan433");
		System.out.println("\nConnection Successful.\n");
		
		st=con.createStatement();
		
		rs=st.executeQuery("select * from account");
		
		rsmd=rs.getMetaData();
		
		//Using ResultSetMetaData
		for(int i=0;i<rsmd.getColumnCount();i++)
		{
			System.out.print("|"+rsmd.getColumnName(i+1)+"|");
		}
		
		System.out.println();
		//Using ResultSet
		while(rs.next())
		{
			System.out.println("|"+rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getInt(3)+"|");
		}
		
		//rsmd.close();
		rs.close();
		st.close();
		con.close();
		
	}
}