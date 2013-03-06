

public class BitTest {
	
	public static final int NONE = 16;
	public static final int NETWORK_ERROR = 1;
	public static final int DISK_FULL = 2;
	public static final int HTTP_ERROR = 4;
	public static final int CLIENT_ERROR = 8;
	public static final int ALL = 31;
	
	private void executeManagedExceptionHandle(int exceptTargetFlag){
		
		System.out.println("exceptTargetFlag : "+exceptTargetFlag);
		
		executeManagedExceptionHandle(NETWORK_ERROR, exceptTargetFlag);
		executeManagedExceptionHandle(DISK_FULL, exceptTargetFlag);
		executeManagedExceptionHandle(HTTP_ERROR, exceptTargetFlag);
		executeManagedExceptionHandle(CLIENT_ERROR, exceptTargetFlag);
	}
	
	public void executeManagedExceptionHandle(int targetFlag, int exceptTargetFlag){
		System.out.println("targetFlag : "+targetFlag);
		System.out.println("exceptTargetFlag : "+exceptTargetFlag);
		System.out.println(exceptTargetFlag+" | "+targetFlag+" => "+String.valueOf(exceptTargetFlag | targetFlag));
		System.out.println(exceptTargetFlag+" | "+targetFlag+" == "+exceptTargetFlag);
		
		if( !((exceptTargetFlag | targetFlag) == exceptTargetFlag) ){
			System.out.println("Not Except Code");System.out.println("");
			return;
		}
		System.out.println("Except Code");System.out.println("");
		return;
	}
	
	public static void main(String[] args){
		BitTest a = new BitTest();
		a.executeManagedExceptionHandle(NONE);
//		a.executeManagedExceptionHandle(NETWORK_ERROR);
//		a.executeManagedExceptionHandle(NETWORK_ERROR|CLIENT_ERROR);
//		a.executeManagedExceptionHandle(ALL);
	}
}
