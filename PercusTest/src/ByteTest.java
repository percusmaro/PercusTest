import java.nio.ByteBuffer;

public class ByteTest {

	public static void main(String[] args) {
		Double d = new Double("-22.1234323432");
		double d2 = -22.1234323432;
		
		byte b = d.byteValue();

		System.out.println("The double number is: " + d);
		System.out.println("The byte value is: " + b);
		System.out.println("The byte size is: " + Double.SIZE);
		System.out.println("The byte size is: " + Float.SIZE);
		
		byte[] temp = new byte[8];
		ByteBuffer.wrap(temp).putDouble(d2);
		System.out.println("The byte value is: " + temp);
		
		double d3 = ByteBuffer.wrap(temp).getDouble();
		System.out.println("The byte value is: " + d3);
		
		
	}

}
