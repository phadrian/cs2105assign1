import java.util.*;
import java.io.*;
import java.lang.Exception;

public class Copier {

	private static final String MESSAGE_FILE_NOT_FOUND = "File not found";
	private static final String MESSAGE_COMPLETE = "%1$s successfully copied to %2$s";
	
	public static void main(String[] args) {
		System.out.println(runProgram(args));
	}

	private static String runProgram(String[] args) {
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(args[0]));
			File sourceImage = new File(args[0]);
			byte[] byteArray = new byte[(int)sourceImage.length()];
			is.read(byteArray);
			is.close();
			
			OutputStream os = new BufferedOutputStream(new FileOutputStream(args[1]));
			os.write(byteArray);
			os.close();
			return String.format(MESSAGE_COMPLETE, args[0], args[1]);
		} catch (IOException e) {
			return MESSAGE_FILE_NOT_FOUND;
		}
	}
}
