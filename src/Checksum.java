import java.io.*;
import java.util.zip.*;
import java.lang.*;

public class Checksum {
	
	public static void main(String[] args) {
		System.out.println(getChecksum(args));
	}

	// Returns null if I/O exception thrown
	private static String getChecksum(String[] args) {
		CRC32 crc = new CRC32();
		String crcString = null;
		try {			
			crc.update(readByteArray(args));
			crcString = String.valueOf(crc.getValue());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return crcString;
	}

	private static byte[] readByteArray(String[] args) throws FileNotFoundException, IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(args[0]));
		File source = new File(args[0]);
		byte[] byteArray = new byte[(int)source.length()];
		is.read(byteArray);
		is.close();
		return byteArray;
	}
}
