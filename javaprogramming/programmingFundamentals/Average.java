package programmingFundamentals;

import java.util.Scanner;

public class Average {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String a = s.nextLine();
		int avg=s.nextInt();
		avg+=s.nextInt();
		avg+=s.nextInt();
		avg/=3;
		System.out.println(a);
		System.out.println(avg);
	}
}
