package jdbc.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class DB_RUN_loop_ReverseOrder 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        				 
        //
        /*
         *  connection string : 
         *  	1 , jdbc
         *  2 , vendor name  for example : oracle mysql mariadb posgress 
         *  3 , sub type : driver type 
         *  4 , hostname  
         *  5 , port name
         *  6 , SID / Service    
         * 
         * */
        
        
        //String url = "jdbc:oracle:thin:@YOUR-EC2-HOSTNAME-GOES-HERE:1521:xe";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "HR"; // or your username
		String password= "HR";// or your password
		Connection conn = DriverManager.getConnection(url, user, password) ;
		
		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs = st.executeQuery("SELECT * FROM JOBS") ; 
		ResultSetMetaData rsmd = rs.getMetaData() ; 
		
		int colCount = rsmd.getColumnCount() ; 
		
		rs.afterLast();
//		while(rs.previous()) {
//			for (int i =1 ; i <= colCount; i++) {
//				System.out.print(rs.getObject(i)+ "--");
//			}
//			System.out.println();
//		}
		
		for (int i = 2; i < 6; i++) {
			rs.absolute(i) ; 
			
			for (int j =1 ; j <= colCount; j++) {
				System.out.print(rs.getObject(j)+ "--");
			}
			System.out.println();
			
		}
				
		

			
			
			//System.out.println(rs.getInt(4) );
			
			/// try to print out all the value from all other column on this row 
		    
			
		System.out.println("connected ");
        
    }
}
