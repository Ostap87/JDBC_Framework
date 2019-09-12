package jdbc.JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.stream.events.StartElement;

/**
 * Hello world!
 *
 */
public class DB_RUN 
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
		
		ResultSet rs = st.executeQuery("SELECT * FROM JOB_HISTORY") ; 
		
			System.out.println(rs.next());
//			System.out.println(rs.getObject(1));
//			System.out.println(rs.getObject(2));
//			System.out.println(rs.getObject(3));
//			System.out.println(rs.getObject(4));
//			System.out.println(rs.getObject(5));
			
			for (int i = 1; i <= 5; i++) {
				System.out.print(rs.getObject(i) + " ----");
			}
			System.out.println(rs.next());
			for (int i = 1; i <= 5; i++) {
				System.out.print(rs.getObject(i) + " ----");
			}
			
			
			
			
			//System.out.println(rs.getInt(4) );
			
			/// try to print out all the value from all other column on this row 
		    
			
		System.out.println("connected ");
        
    }
}
