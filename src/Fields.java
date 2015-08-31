import java.util.*;
import java.io.*;

public class Fields {

	private static final String MESSAGE_UNKNOWN = "Unknown field";
	private static final String KEYWORD_END = "QUIT";

	public static void main(String[] args) {
		Vector<String> fieldVector = new Vector<String>();
		Vector<String> valueVector = new Vector<String>();
		
		Scanner sc = new Scanner(System.in);
		
		String inputLine;
		getFields(fieldVector, valueVector, sc);
		queryFields(fieldVector, valueVector, sc);
		
	}

	private static void queryFields(Vector<String> fieldVector, Vector<String> valueVector, Scanner sc) {
		String inputLine;
		while (true) {
			inputLine = sc.nextLine();
			if (inputLine.toUpperCase().equals(KEYWORD_END)) {
				sc.close();
				System.exit(0);
			} else {
				int valueIndex = fieldVector.indexOf(inputLine.toUpperCase());
				if (valueIndex == -1) {
					System.out.println(MESSAGE_UNKNOWN);
				} else {
					System.out.println(valueVector.get(valueIndex));
				}
			}
		}
	}

	private static void getFields(Vector<String> fieldVector, Vector<String> valueVector, Scanner sc) {
		String inputLine = sc.nextLine();
		while (!inputLine.equals("")) {
			String[] splitString = inputLine.split(":");
			String field = splitString[0];		
			String value = splitString[1].trim();
			
			fieldVector.add(field.toUpperCase());
			valueVector.add(value);
			inputLine = sc.nextLine();
		}
	}
}
