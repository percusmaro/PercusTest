import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;


public class IOTest {
	
	
	public static void copyIOFile(File oriFile, String toFilePath){
		FileInputStream in = null;
		FileOutputStream out = null;
		int i=0;
		
		try{
			in = new FileInputStream(oriFile);
			out = new FileOutputStream(toFilePath, false);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			while((i=in.read()) != -1){
				out.write(i);
			}
			in.close();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void copyNIOFile(String source, String target){
		FileChannel in = null;
		FileChannel out = null;
		int i=0;
		
		try{
			in = new FileInputStream(source).getChannel();
			out = new FileOutputStream(target).getChannel();
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			int maxCount = (64*1024*1024) - (32*1024);
			long size = in.size();
			long position = 0;
			while(position < size){
				position += in.transferTo(position, maxCount, out);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		String source = "/Users/nhn/Downloads/test.pptx";
		String target1 = "/Users/nhn/temp/test1.zip";
		String target2 = "/Users/nhn/temp/test2.zip";
		
		long start1 = System.currentTimeMillis();
		IOTest.copyIOFile(new File(source), target1);
		System.out.println(System.currentTimeMillis()-start1);
		
		long start2 = System.currentTimeMillis();
		IOTest.copyNIOFile(source, target2);
		System.out.println(System.currentTimeMillis()-start2);
	}
}
