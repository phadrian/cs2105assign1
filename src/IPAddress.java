import java.util.*;
import java.lang.Math;

public class IPAddress {
	
	public static void main(String[] args) {
		String binaryInput = getBinaryInput();
		System.out.println(convertToDecimalString(binaryInput));
	}

	private static String convertToDecimalString(String binaryInput) {
		// Run  (32 / 8) = 4 times for 32bit IP address
		String decimalAddress = "";
		for (int i = 0; i < 4; i++) {
			decimalAddress += "." + String.valueOf(convertToDecimal(binaryInput.substring(i * 8, (i + 1) * 8)));
		}
		return decimalAddress.substring(1);
	}

	private static int convertToDecimal(String binaryInput) {
		int decimalSum = 0;
		for (int i = 0; i < binaryInput.length(); i++) {
			int binaryValue = Integer.parseInt(binaryInput.substring(i, i+1));
			decimalSum += binaryValue * (Math.pow(2, binaryInput.length() - 1 - i));
		}
		return decimalSum;
	}

	private static String getBinaryInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
}
