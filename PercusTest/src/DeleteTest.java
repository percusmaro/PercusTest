import java.io.File;
import java.io.IOException;


public class DeleteTest {
	
	public static String targetDirectory = "/Users/nhn/temp/read";
	
	public static void deleteDirectory(){
		long start = System.currentTimeMillis();
		
		File f = new File(targetDirectory);
		boolean result = f.delete();
		System.out.println(result);
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("deleteDirectory Time : "+time);
	}
	
	public static void deleteRecursive(){
		long start = System.currentTimeMillis();
		
		File f = new File(targetDirectory);
		DeleteRecursive(f);
		
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("deleteDirectory Time : "+time);
	}
	
	public static void DeleteRecursive(File f) {
		
	    if (f.isDirectory())
	        for (File child : f.listFiles())
	            DeleteRecursive(child);

	    f.delete();
	}

	
	public static void deleteDirectory2(){
		long start = System.currentTimeMillis();
		
		String cmd = "rm -rf "+targetDirectory;
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("deleteDirectory Time : "+time);
	}
	
	public static void deleteFiles() {
		long start = System.currentTimeMillis();
	    File file = new File(targetDirectory);

	    if (file.exists()) {
	        String deleteCmd = "rm -r " + targetDirectory;
	        Runtime runtime = Runtime.getRuntime();
	        try {
	            runtime.exec(deleteCmd);
	        } catch (IOException e) { }
	    }
	    long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("deleteDirectory Time : "+time);
	}
	
	public static void moveFiles() {
		long start = System.currentTimeMillis();
	    File file = new File(targetDirectory);

	    if (file.exists()) {
	        String deleteCmd = "rm -r " + targetDirectory;
	        Runtime runtime = Runtime.getRuntime();
	        try {
	            runtime.exec(deleteCmd);
	        } catch (IOException e) { }
	    }
	    long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("deleteDirectory Time : "+time);
	}
	
	public static void main(String[] args){
		DeleteTest.deleteFiles();
	}
}
