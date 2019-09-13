import java.sql.*;

class DatabaseMeta
{
	public static void main(String args[]) throws Exception
	{
		Connection con=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","gagan","gagan433");
		System.out.println("\nConnection Successful.\n");
		
		String s[]={"TABLE"};
		
		DatabaseMetaData dbmd=con.getMetaData();
		
		ResultSet rs=dbmd.getTables(null,null,null,s);
		System.out.println("Database Objects:");
		
		while(rs.next())
		{
			System.out.println("|"+rs.getString(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4)+"|");
		}
		
		System.out.println("\nDatabase Product Name: "+dbmd.getDatabaseProductName());
		
		System.out.println("\nDatabase Product Version: "+dbmd.getDatabaseProductVersion());
		
		System.out.println("\nSQL Keywords: "+dbmd.getSQLKeywords());
		
		System.out.println("\nNumeric Functions: "+dbmd.getNumericFunctions());
		
		System.out.println("\nString Functions: "+dbmd.getStringFunctions());
		
		con.close();
		rs.close();
	}
}