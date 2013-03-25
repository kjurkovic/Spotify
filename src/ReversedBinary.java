import java.util.Scanner;

public class ReversedBinary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(
				Integer.parseInt(
						reverse(
								Integer.toBinaryString(
										Integer.parseInt(scanner.nextLine().trim())
										)
						), 2));
	}
	
	private static String reverse(String input) {
		char[] chars = input.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (int i = chars.length-1; i >= 0 ; i--) 
			builder.append(chars[i]);
		
		return builder.toString();
	}

}
