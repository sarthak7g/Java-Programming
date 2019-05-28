package programmingFundamentals;

import java.util.Scanner;

public class NumberPattern2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i=1;i<=n;i++) {
			int k=i;
			for(int j=1;j<=n;j++) {
				if(j<=n-i)
				System.out.print(" ");
				else System.out.print(k++);
			}
			System.out.println();
		}
	}

}
