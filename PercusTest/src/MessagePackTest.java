import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.msgpack.MessagePack;
import org.msgpack.annotation.Message;

public class MessagePackTest {

	@Message
	public static class MyMessage {
		public double doubleVal1 = 21312313123.1312312;
		public double doubleVal2 = 11312313123.1312312;
		public double doubleVal3 = 31312313123.1312312;
		public double doubleVal4 = 41312313123.1312312;
		public float floatVal = 32232332.233f;
		public long longVal = 32232332234232L;
		
		public byte[] addVal(int val){
			doubleVal1 += val;
			doubleVal2 += val;
			doubleVal3 += val;
			doubleVal4 += val;
			floatVal += val;
			longVal += val;
			
			return this.toString().getBytes();
		}
		
		@Override
		public String toString() {
			return "MyMessage [ doubleVal1=" + doubleVal1 + ", doubleVal2="
					+ doubleVal2 + ", doubleVal3=" + doubleVal3 + ", "
					+ "	doubleVal4=" + doubleVal4 + ", floatVal=" + floatVal
					+ ", longVal=" + longVal + "]";
		}
	}
	
	public void testJson(int count)throws IOException {
		
		MyMessage src = new MyMessage();
		//byte[] byteData = src.toString().getBytes();
		//System.out.println("json Size : " + byteData.length);
		byte[] byteData = null;
		try {
			BufferedOutputStream bos = new BufferedOutputStream(
					 new FileOutputStream("/Users/nhn/study/start/" + "json"+count+".zip"));
			BufferedOutputStream bos2 = new BufferedOutputStream(
					 new FileOutputStream("/Users/nhn/study/start/" + "json"+count+".txt"));
			
			ZipOutputStream zipOs = new ZipOutputStream(bos);
			zipOs.setLevel(9);
			zipOs.putNextEntry(new ZipEntry("a"));
			
			for (int i = 0; i < count; i++) {
				byteData = src.addVal(i+1);
				zipOs.write(byteData);
				bos2.write(byteData);
			}

			zipOs.close();
			bos.close();
			bos2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testMessagePack(int count) throws IOException {
		MessagePack msgpack = new MessagePack();
		MyMessage src = new MyMessage();
		
		//byte[] bytes = msgpack.write(src);
		//MyMessage dst = msgpack.read(bytes, MyMessage.class);

		//System.out.println("MessagePack Data : " + dst);
		//System.out.println("MessagePack Size : " + bytes.length);
		
		byte[] bytes = null;
		try {
			BufferedOutputStream bos = new BufferedOutputStream(
					 new FileOutputStream("/Users/nhn/study/start/" + "messagepack"+count+".zip"));
			BufferedOutputStream bos2 = new BufferedOutputStream(
					 new FileOutputStream("/Users/nhn/study/start/" + "messagepack"+count+".txt"));
			
			ZipOutputStream zipOs = new ZipOutputStream(bos);
			zipOs.setLevel(5);
			zipOs.putNextEntry(new ZipEntry("b"));
			
			for (int i = 0; i < count; i++) {
				src.addVal(i+1);
				bytes = msgpack.write(src);
				zipOs.write(bytes);
				bos2.write(bytes);
			}

			zipOs.close();
			bos.close();
			bos2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testRealBinary(int count) {
		MyMessage src = new MyMessage();
		
//		int realSize = 0;
//
//		realSize += ByteUtils.toByteArray(src.doubleVal1).length;
//		realSize += ByteUtils.toByteArray(src.doubleVal2).length;
//		realSize += ByteUtils.toByteArray(src.doubleVal3).length;
//		realSize += ByteUtils.toByteArray(src.doubleVal4).length;
//		realSize += ByteUtils.toByteArray(src.floatVal).length;
//		realSize += ByteUtils.toByteArray(src.longVal).length;

//		byte[] doubleVal1Byte = ByteUtils.toByteArray(src.doubleVal1);
//		byte[] doubleVal2Byte = ByteUtils.toByteArray(src.doubleVal2);
//		byte[] doubleVal3Byte = ByteUtils.toByteArray(src.doubleVal3);
//		byte[] doubleVal4Byte = ByteUtils.toByteArray(src.doubleVal4);
//		byte[] floatValByte = ByteUtils.toByteArray(src.floatVal);
//		byte[] longValByte = ByteUtils.toByteArray(src.longVal);

		//System.out.println("Real Size : " + realSize);
		
		byte[] doubleVal1Byte = null;
		byte[] doubleVal2Byte = null;
		byte[] doubleVal3Byte = null;
		byte[] doubleVal4Byte = null;
		byte[] floatValByte = null;
		byte[] longValByte = null;

		try {
			BufferedOutputStream bos = new BufferedOutputStream(
			 new FileOutputStream("/Users/nhn/study/start/" + "real"+count+".zip"));
			BufferedOutputStream bos2 = new BufferedOutputStream(
					 new FileOutputStream("/Users/nhn/study/start/" + "real"+count+".txt"));
			
			ZipOutputStream zipOs = new ZipOutputStream(bos);
			zipOs.setLevel(5);
			zipOs.putNextEntry(new ZipEntry("c"));

			for (int i = 0; i < count; i++) {
				src.addVal(i+1);
				doubleVal1Byte = ByteUtils.toByteArray(src.doubleVal1);
				doubleVal2Byte = ByteUtils.toByteArray(src.doubleVal2);
				doubleVal3Byte = ByteUtils.toByteArray(src.doubleVal3);
				doubleVal4Byte = ByteUtils.toByteArray(src.doubleVal4);
				floatValByte = ByteUtils.toByteArray(src.floatVal);
				longValByte = ByteUtils.toByteArray(src.longVal);
				
				zipOs.write(doubleVal1Byte);
				zipOs.write(doubleVal2Byte);
				zipOs.write(doubleVal3Byte);
				zipOs.write(doubleVal4Byte);
				zipOs.write(floatValByte);
				zipOs.write(longValByte);
				
				bos2.write(doubleVal1Byte);
				bos2.write(doubleVal2Byte);
				bos2.write(doubleVal3Byte);
				bos2.write(doubleVal4Byte);
				bos2.write(floatValByte);
				bos2.write(longValByte);
			}

			zipOs.close();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] arg) {
		MessagePackTest mp = new MessagePackTest();
		int count = 21600;
		try {
			mp.testJson(count);
			mp.testMessagePack(count);
			mp.testRealBinary(count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}