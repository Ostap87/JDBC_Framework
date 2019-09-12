package jdbc.JDBC.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB_Util {

	private static Connection connection ; 
	private static Statement statement ; 
	private static ResultSet resultSet ; 
	
	
	public static void main(String[] args) throws Exception {
		
		// Establish Connection 
		
		boolean b = createConnection() ; 
		System.out.println(b);
		
		List<Map<String, Object>> resultList = runQueryGetResult("SELECT * FROM EMPLOYEES") ; 
		System.out.println( resultList );
		
		// myResult.goToRow(2).getValueByColumnName("my name") --> value 
		
		System.out.println(   resultList.get(2).get("FIRST_NAME")     );
		
		// Create Statement Run Query to store result to collection object 
		
		// get row count 
		
		// Close The connection 

	}

	public static boolean createConnection() {
		
		String url = 	 ConfigurationReader.getProperty("connectionString");	//"jdbc:oracle:thin:@localhost:1521:xe";
		String user =    ConfigurationReader.getProperty("DB_user");//"HR"; // or your username
		String password= ConfigurationReader.getProperty("DB_pass");//"HR";// or your password
		
		 try {
			connection = DriverManager.getConnection(url, user, password) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		if(conn!= null)
//			return true ; 
		
		return false; 
	}
	
	
	// store the resultset is collection of some kind so we can directly work with 
	// myResult.goToRow(2).getValueByColumnName("my name") --> value 
	
	// List of rows ---> Map of colName-value 
	/// List< Map<String, Object> >
	
	public static  List<Map<String, Object> > runQueryGetResult(String query) throws Exception{
		
		List<Map<String, Object> > rowList = new ArrayList<>(); 
		
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY) ; 		
		resultSet = statement.executeQuery(query) ;
		
		ResultSetMetaData rsmd = resultSet.getMetaData() ; 
		while ( resultSet.next() ) {
			
			Map<String,Object> colNameValueMap = new HashMap<>() ; 
//			
			for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
//				
//				//System.out.println( "ColumnName : " + rsmd.getColumnName(i));
//				//System.out.println( "value  :     " + rs.getObject(i) );
				colNameValueMap.put(rsmd.getColumnName(i), resultSet.getObject(i) ) ; 
//				
			}
			
			rowList.add(colNameValueMap); 
			
			
		}
		
		return rowList ; 
		
	}
	
	
	
	public static int getRowCount() throws Exception {
		
		resultSet.last() ;
		
		int rowCount = resultSet.getRow() ; 
		return rowCount ; 
		
	}
	
	
}
