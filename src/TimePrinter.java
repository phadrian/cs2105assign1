import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class TimePrinter extends TimerTask {

	private String outputMessage;
	
	public TimePrinter(String message) {
		outputMessage = message;
	}
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimePrinter(args[0]), 
				Integer.parseInt(args[1]) * 1000, 
				Integer.parseInt(args[2]) * 1000);
		
		Scanner sc = new Scanner(System.in);
		String exitCode = sc.nextLine();
		while(!exitCode.equals("q")) {
			exitCode = sc.nextLine();
		}
		timer.cancel();
		System.exit(0);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(outputMessage);
	}
}
