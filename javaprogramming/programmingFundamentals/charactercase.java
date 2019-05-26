package programmingFundamentals;

import java.util.Scanner;

public class charactercase {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String a = s.nextLine();
		char n = a.charAt(0);
		if(n<=90 && n>=65)
			System.out.println(1);
		else if (n<=122 && n>=97)
			System.out.println(0);
		else  System.out.println(-1);

	}
}
