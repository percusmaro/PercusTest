

import java.nio.ByteBuffer;

public class ByteUtils {
	
	public static int DOUBLE_SIZE = Double.SIZE/8;
	public static int LONG_SIZE = Long.SIZE/8;
	public static int FLOAT_SIZE = Float.SIZE/8;
	public static int INT_SIZE = Integer.SIZE/8;
	
	public static byte[] toByteArray(int value) {
	    byte[] bytes = new byte[INT_SIZE];
	    ByteBuffer.wrap(bytes).putInt(value);
	    return bytes;
	}
	
	public static byte[] toByteArray(long value) {
	    byte[] bytes = new byte[LONG_SIZE];
	    ByteBuffer.wrap(bytes).putLong(value);
	    return bytes;
	}
	
	public static byte[] toByteArray(float value) {
	    byte[] bytes = new byte[FLOAT_SIZE];
	    ByteBuffer.wrap(bytes).putFloat(value);
	    return bytes;
	}
	
	public static byte[] toByteArray(double value) {
	    byte[] bytes = new byte[DOUBLE_SIZE];
	    ByteBuffer.wrap(bytes).putDouble(value);
	    return bytes;
	}

	public static double toDouble(byte[] bytes) {
	    return ByteBuffer.wrap(bytes).getDouble();
	}
	
	public static long toLong(byte[] bytes) {
	    return ByteBuffer.wrap(bytes).getLong();
	}
	
	public static byte[] getSubBytes(byte[] src, int start, int length){
		byte[] temp = new byte[length];
		for( int i=0 ; i<length ; i++ ){
			temp[i] = src[start+i];
		}
		
		return temp;
	}
}
