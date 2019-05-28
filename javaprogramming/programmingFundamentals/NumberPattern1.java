package programmingFundamentals;

import java.util.Scanner;

public class NumberPattern1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=i;j<2*i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

}
