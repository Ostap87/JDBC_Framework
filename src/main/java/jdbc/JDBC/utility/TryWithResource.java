package jdbc.JDBC.utility;

public class TryWithResource implements AutoCloseable{

	public static void main(String[] args) throws Exception {
		
		try (TryWithResource t = new TryWithResource() ) {
			
			t.open();
			
			
		} catch(Exception e){
			System.out.println("aaaaaa");
		} 
		
//		TrWithResource t = null;
//		try {
//			 t = new TrWithResource() ;
//			t.open();
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			
//			if(t!=null)
//				t.close() ; 
//					
//		}


	}
	
	public TryWithResource() throws Exception{
		System.out.println("creating ");
	} 
	

	
	public void open() {
		System.out.println("opening");
	}
	
	
	@Override     
	/// narrower exception // the same 
	// unchecked exception 
	// no exception at all 
	
	// NO NEW OR BROADER CHECKED EXCEPTION IS ALLOWED IN OVERRDING METHOD IN SUB CLASSS
	
	public void close() {
		
		System.out.println("closing ");
		
	}

}
